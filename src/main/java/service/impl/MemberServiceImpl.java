package service.impl;

import com.alibaba.fastjson.JSONObject;
import entity.RestTemplateRequestUtil;
import org.springframework.stereotype.Service;
import service.MemberService;

/**
 * @author tianqinghua
 * @date 2018/12/21 13:06
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Override
    public String getMember() {
        String url = "https://i-gateway-t.4008827123.cn/api/open-api/member/memberAsset?access_token=GuCYu6VkATBkYKm3xsmM5kGTkR42H2WB";
        JSONObject param = new JSONObject(4);
        param.put("membershipId", "1000003300041");
//        param.put("cardNo","6201910013601108");
        param.put("tenantId", "18627300005");
        param.put("appId", "700001");
        param.put("secretKey", "8c3109a0d6e443a0892e00f9af8d55a3");
        JSONObject realParam = new JSONObject(1);
        realParam.put("body", param);
        return RestTemplateRequestUtil.postRequest(url, realParam, String.class);
    }
}
