package com.robinzhu.filter_listener_interceptor.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Create by zhudapeng
 * 2019-08-11 00:15
 */

/**
 * 监听器
 *  监听器是servlet规范中定义的一种特殊类。用于监听servletContext、HttpSession和servletRequest等域对象的创建和销毁事件。监听域对象的属性发生修改的事件。用于在事件发生前、发生后做一些必要的处理。一般是获取在线人数等业务需求
 *  监听器创建成功后，需要在启动类中加入@ServletComponentScan进行注册才能生效
 */
@WebListener
@Slf4j
public class CustomLister implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("监听器：初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("监听器：销毁");
    }
}
