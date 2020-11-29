package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.pojo.BackendUser;
import project.pojo.DevUser;
import project.service.DevUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author 杨乔瀚
 * @create 2020/11/26 - 17:26
 */
@Controller
public class DevUserController {



    @Autowired
    DevUserService devUserService;


    /**
     * 登录
     * @return
     */
    @RequestMapping(value = "/dev/login",method = RequestMethod.POST)
    public String login(DevUser devUser,HttpSession session){
        if(devUser.getDevCode()==null||devUser.getDevCode().equals("")||devUser.getDevPassword()==null||devUser.getDevPassword().equals("")){
            session.setAttribute("error","用户名或密码不能为空");
            return "devlogin";
        }

        Map<String, Object> loginResult = devUserService.login(devUser);

        if (loginResult.get("message").equals("true")){
            session.setAttribute("devUserSession",loginResult.get("devUser"));
            return "developer/main";
        }
            session.setAttribute("error","用户名或密码错误");
            return "devlogin";
    }


    @RequestMapping(value = "/dev/logout",method = RequestMethod.GET)
    public String logout(HttpSession session){
        session.invalidate();
        return "devlogin";
    }

}
