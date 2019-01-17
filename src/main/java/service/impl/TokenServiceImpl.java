package service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import entity.RestTemplateRequestUtil;
import entity.UrlYazuo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.TokenService;

/**
 * @author tianqinghua
 * @date 2018/12/21 10:08
 */
@Service
public class TokenServiceImpl implements TokenService {
    @Override
    public String getToken() {
        String url = "https://i-gateway-t.4008827123.cn/api/oauth2/token";
        JSONObject param = new JSONObject(3);
        param.put("grant_type", "client_credentials");
        param.put("client_id", "e8313e964d434820ba2a5bef348fd0e3");
        param.put("client_secret", "76b4f6ba3858426a8207659f00fe7c4f");
        String str = RestTemplateRequestUtil.postRequest(url, param, String.class);
        return str;
    }
}
