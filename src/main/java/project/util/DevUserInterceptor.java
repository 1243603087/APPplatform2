package project.util;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import project.pojo.DevUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 杨乔瀚
 * @create 2020/11/26 - 21:42
 */
public class DevUserInterceptor implements HandlerInterceptor {
    /**
     * 拦截没有登录的请求
     * @param request
     * @param response
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        DevUser devUser= (DevUser)request.getSession().getAttribute("devUserSession");
        if (devUser==null){
            request.setAttribute("error","你还没有登录，请先登录");
            request.getRequestDispatcher("/developer/login").forward(request,response);
            return  false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
