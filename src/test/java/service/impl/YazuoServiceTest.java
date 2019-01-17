package service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import service.MemberService;
import service.TokenService;

/**
 * @author tianqinghua
 * @date 2018/12/21 10:43
 */
@SpringBootTest
public class YazuoServiceTest {
    @Test
    public void testGetToken(){
        TokenService tokenService=new TokenServiceImpl();
        System.out.println(tokenService.getToken());
    }
    @Test
    public void testGetMember(){
        MemberService memberService=new MemberServiceImpl();
        System.out.println(memberService.getMember());;
    }
}
