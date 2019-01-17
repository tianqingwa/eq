package controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author tianqinghua
 * @date 2018/8/10 10:57
 */
@SpringBootApplication
public class SimpleApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SimpleApplication.class, args);
    }
}
