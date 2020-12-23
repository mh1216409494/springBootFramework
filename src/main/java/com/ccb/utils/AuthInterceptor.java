package com.ccb.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {
    private Logger logger = LogManager.getLogger(AuthInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("-------开始preHandle过滤----------");
        String servletPath = request.getServletPath();
        String requestURI = request.getRequestURI();
        logger.info("servletPath:" + servletPath);
        logger.info("requestURI:" + requestURI);
        logger.info("--------结束preHandle过滤----------");
        /*if(request.getServletPath().endsWith("html")){

            response.getWriter().print("access denied");
            return false;
        }*/
       return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
