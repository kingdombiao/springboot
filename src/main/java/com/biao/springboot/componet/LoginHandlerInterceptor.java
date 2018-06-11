package com.biao.springboot.componet;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        Object login = request.getSession().getAttribute("userLogin");
        if(StringUtils.isEmpty(login)){
            request.setAttribute("msg","你还未有权限，请登录！");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return  false;
        }
        return true;
    }
}
