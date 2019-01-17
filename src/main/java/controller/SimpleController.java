package controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import entity.Coupon;
import entity.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tianqinghua
 * @date 2018/8/10 11:01
 */
@RestController
@RequestMapping("/member")
public class SimpleController {
    private static final Logger log = LoggerFactory.getLogger(SimpleController.class);
    @RequestMapping("/testCallback")
    public JSONObject testCallback(HttpEntity<JSONObject> httpEntity) throws Exception {
        JSONObject returnObj = new JSONObject();
        JSONObject body = httpEntity.getBody();
        log.info("请求body={}",body.toJSONString());
        HttpHeaders headers = httpEntity.getHeaders();
        List<String> list = headers.get("sign");
        List<String> list1 = headers.get("sign_type");
        String sign = null;
        String sign_type = null;
        if (list != null && list.size() > 0) {
            sign = list.get(0);
        }
        if (list1 != null && list1.size() > 0) {
            sign_type = list1.get(0);
        }
        if (sign == null || sign_type == null) {
            returnObj.put("data", "");
            returnObj.put("code", "10000");
            returnObj.put("msg", "签名无效,请求的数据：" + body.toJSONString());
            return returnObj;
        }
        //验签操作
        MessageDigest md5 = MessageDigest.getInstance(sign_type);
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String encode = base64Encoder.encode(md5.digest(("我是public_key" + "_" + body.toJSONString()).getBytes("UTF-8")));
        if (!encode.equals(sign)) {
            returnObj.put("data", "");
            returnObj.put("code", "10000");
            returnObj.put("msg", "签名无效,请求的数据：" + body.toJSONString());
            return returnObj;
        }
        returnObj.put("data", "我是testCallback返回的数据");
        returnObj.put("code", "10000");
        returnObj.put("msg", "我是商家eq,请求的数据：" + body.toJSONString());
        return returnObj;
    }
}
