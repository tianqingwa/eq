package controller;

import com.alibaba.fastjson.JSONObject;
import com.sun.deploy.net.HttpResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author tianqinghua
 * @date 2018/12/6 15:18
 */
@RestController
public class TestModifyContentTypeController {
    @PostMapping("/testContentType")
    public void testContentType(HttpServletResponse response) throws IOException {
        response.setHeader("content-type", "application/json; charset=utf-8");
        JSONObject obj = new JSONObject(1);
        obj.put("desc", "this is body");
        response.getOutputStream().print(obj.toJSONString());

    }
}
