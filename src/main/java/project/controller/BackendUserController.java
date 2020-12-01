package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.pojo.BackendUser;
import project.service.BackendUserService;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author 杨乔瀚
 * @create 2020/11/26 - 22:11
 */
@Controller
public class BackendUserController {


    @Autowired
    BackendUserService backendUserService;

    @RequestMapping(value = "/back/login",method = RequestMethod.POST)
    public String login(BackendUser backendUser, HttpSession session){

        if (backendUser.getUserCode()==null||backendUser.getUserCode().equals("")||backendUser.getUserPassword()==null||backendUser.getUserPassword().equals("")){
            session.setAttribute("error","用户名或密码不能为空");
            return "backendlogin";
        }

        Map<String, Object> loginResult = backendUserService.login(backendUser);
        if (loginResult.get("message").equals("true")){
            session.setAttribute("userSession",loginResult.get("backendUser"));
            return "backend/main";
        }
        session.setAttribute("error","用户名或密码错误");
        return "backendlogin";
    }


    @RequestMapping(value = "/backend/logout",method = RequestMethod.GET)
    public String logout(HttpSession session){
        session.invalidate();
        return "backendlogin";
    }
}
