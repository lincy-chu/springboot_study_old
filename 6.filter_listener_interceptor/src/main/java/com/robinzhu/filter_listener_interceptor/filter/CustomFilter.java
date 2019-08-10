package com.robinzhu.filter_listener_interceptor.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Create by zhudapeng
 * 2019-08-10 22:57
 */

/**
 * 过滤器
 *  过滤器filter，是servlet的一个实用技术，可通过过滤器，对请求进行拦截，比如读取session判断用户是否登录、判断访问的请求URL是否有访问权限（黑白名单）等。主要还是可对请求进行预处理。
 * @WebFilter 是Servlet3.0新增的注解，原先实现过滤器，需要在web.xml中进行配置，而现在通过此注解，启动时会自动扫描自动注册
 * 1.通过Filter类注册filter
 *  注册器名称为customFilter，拦截的url为所有，注册完成后需要在启动类加入@ServletComponentScan注释即可添加过滤器
 *  当注册多个过滤器时，无法指定执行顺序，原来使用web.xml配置过滤器时，是可指定执行顺序的，但使用@WebFilter时。没有这个配置属性的（需要配合@Order进行）
 *
 *  小技巧
 *      1.通过过滤器的Java名称，进行顺序的约定，比如LogFilter和AuthFilter，此时AuthFilter就会比LogFilter先执行，因为首字母A比L在前
 *
 * 2.FilterRegistrationBean方式
 *  FilterRegistrationBean是spring boot提供了，此类提供setOrder方法，可以为filter设置排序值，让spring在注册web filter之前排序后再一次注册
 */
@WebFilter(filterName = "customFilter", urlPatterns = {"/*"})
@Slf4j
public class CustomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("filter：初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("doFilter：请求处理");
        /**
         * 对request、response进行一些预处理
         * 比如设置请求编码
         * request.setCharacterEncoding("UTF-8")
         * response.setCharacterEncoding("UTF-8")
         */
        // 链路，直接传给下一个过滤器
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        log.info("filter：销毁");
    }
}
