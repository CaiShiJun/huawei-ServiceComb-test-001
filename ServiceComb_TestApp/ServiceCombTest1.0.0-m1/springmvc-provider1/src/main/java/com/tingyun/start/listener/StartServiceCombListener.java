package com.tingyun.start.listener;

import org.apache.servicecomb.foundation.common.utils.BeanUtils;
import org.apache.servicecomb.foundation.common.utils.Log4jUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//@WebListener
public class StartServiceCombListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //初始化日志， 加载Bean(包括它们的参数), 以及注册Service, 更多信息可以参见文档 : http://servicecomb.incubator.apache.org/cn/users/application-boot-process/
        try {
            Log4jUtils.init();
            BeanUtils.init();
            System.out.println("StartServiceCombListener初始化");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
