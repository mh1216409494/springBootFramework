package com.ccb.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootConfiguration
public class AppConfig implements WebMvcConfigurer {
    private final Logger logger = LoggerFactory.getLogger(AppConfig.class);



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        logger.info("------addInterceptors-----------");
        registry.addInterceptor(new AuthInterceptor())
                .addPathPatterns("/**");

    }

}
