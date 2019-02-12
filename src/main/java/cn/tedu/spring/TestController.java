package cn.tedu.spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

@Controller
public class TestController {

    public String test(HttpServletRequest request){
        request.getServletContext();
        return null;
        
    }
}
