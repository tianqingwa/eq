package controller;

import com.alibaba.fastjson.JSONObject;
import entity.ExcelEntity;
import entity.ExcelUtil;
import entity.RestTemplateRequestUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @author tianqinghua
 * @date 2018/11/30 10:32
 */
@RestController
public class TestRestController {
    @PostMapping("/testRest")
    public String testExpost(@RequestBody Map<String, Object> param) {
        return RestTemplateRequestUtil.postRequest("http://124.74.243.132:8120/action/choice.aspx", param, String.class);

    }
}
