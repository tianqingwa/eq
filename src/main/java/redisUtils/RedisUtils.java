package redisUtils;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisCommands;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * Created by huxl on 2018-03-09.
 * 需要用注入的方式用
 */
@Repository
public class RedisUtils {

    private static final String FIRSTKEY = "mweeapi";
    private final static String RESULT_OK = "OK"; //单个业务持有锁的时间20s,防止死锁
    private StringRedisTemplate template;

    /**
     * @param key   String 类型的key
     * @param value Object类型的value
     */
    public void setObj(String key, Object value) {
        String str;
        if (value instanceof String) {
            str = (String) value;
        } else {
            str = JSON.toJSONString(value);
        }
        template.opsForValue().set(FIRSTKEY + key, str);
    }

    /**
     * @param key   String 类型的key
     * @param value Object类型的value
     */
    public void set(String key, String value) {
        template.opsForValue().set(FIRSTKEY + key, value);
    }

    public boolean setNX(String key, String value, long expireTime) {
        String result = template.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                JedisCommands commands = (JedisCommands) connection.getNativeConnection();
                return commands.set(key, value, "NX", "PX", expireTime);
            }
        });
        if (RESULT_OK.equals(result)) {
            return true;
        }
        return false;
    }

    // 使用Lua脚本删除Redis中匹配value的key，可以避免由于方法执行时间过长而redis锁自动过期失效的时候误删其他线程的锁
// spring自带的执行脚本方法中，集群模式直接抛出不支持执行脚本的异常，所以只能拿到原redis的connection来执行脚本
    public boolean releaseLock(String key, String value) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Long result = template.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                Object nativeConnection = connection.getNativeConnection();
                // 集群模式和单机模式虽然执行脚本的方法一样，但是没有共同的接口，所以只能分开执行
                // 集群模式
                if (nativeConnection instanceof JedisCluster) {
                    return (Long) ((JedisCluster) nativeConnection).eval(script, Collections.singletonList(key), Collections.singletonList(value));
                }

                // 单机模式
                else if (nativeConnection instanceof Jedis) {
                    return (Long) ((Jedis) nativeConnection).eval(script, Collections.singletonList(key), Collections.singletonList(value));
                }
                return 0L;
            }
        });
        if (1l == result) {
            return true;
        }
        return false;
    }

    /**
     * @param key
     * @param obj
     * @param sec 保存时间 单位秒
     */
    public void setSEC(String key, Object obj, int sec) {
        String value = JSON.toJSONString(obj);
        template.opsForValue().set(FIRSTKEY + key, value, sec, TimeUnit.SECONDS);
    }

    /**
     * @param key
     * @param value
     * @param sec
     */
    public void setStrSEC(String key, String value, int sec) {
        template.opsForValue().set(FIRSTKEY + key, value, sec, TimeUnit.SECONDS);
    }

    /**
     * @param key
     * @return String
     */
    public String get(String key) {
        return template.opsForValue().get(FIRSTKEY + key);
    }

    /**
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getObj(String key, final Class<T> clazz) {
        String str = template.opsForValue().get(FIRSTKEY + key);
        return JSON.parseObject(str, clazz);
    }

    /**
     * @param key
     */

    public void del(String key) {
        template.delete(FIRSTKEY + key);
    }

    /**
     * @param key
     * @return
     */
    public boolean hasKey(String key) {
        return template.hasKey(FIRSTKEY + key);
    }

    @Autowired
    public void setTemplate(StringRedisTemplate template) {
        this.template = template;
    }
}
