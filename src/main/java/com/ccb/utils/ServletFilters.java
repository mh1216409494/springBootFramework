package com.ccb.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName ApplicationFilter
 * @Descridtion
 * @Author MaHuanHuan
 * @Date 2020/12/12 11:46
 **/
@Component
public class ServletFilters implements Filter {
    private Logger log= LogManager.getLogger(ServletFilters.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       log.info("--------开始过滤---------");
        filterChain.doFilter(servletRequest,servletResponse);
       log.info("---------结束过滤----------");
    }

    @Override
    public void destroy() {

    }
}
