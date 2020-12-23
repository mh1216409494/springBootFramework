package com.ccb.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.ApplicationListener;
/**
 * @ClassName ApplicationListener
 * @Descridtion
 * @Author MaHuanHuan
 * @Date 2020/12/11 22:59
 **/
@Configuration
public class ServletListeners implements ApplicationListener<ApplicationEvent> {
    Logger log= LogManager.getLogger(ServletListeners.class);

//    ApplicationStartedEvent ：spring boot启动开始时执行的事件
//    ApplicationEnvironmentPreparedEvent：spring boot 对应Enviroment已经准备完毕，但此时上下文context还没有创建。
//    ApplicationPreparedEvent：spring boot上下文context创建完成，但此时spring中的bean是没有完全加载完成的。
//    ApplicationFailedEvent：spring boot启动异常时执行事件

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {

        //log.info("-------开始监听---------");
        //String str=applicationEvent.toString();
        //System.out.println(getClass().getSimpleName());
        //log.info("-------结束监听---------");
    }
}
