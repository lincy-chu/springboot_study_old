package com.robinzhu.exceptionhandle_valid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 异常处理和数据校验处理
 *    在web应用中，请求处理时，出现异常是常见的。所以当应用出现各类异常时，进行异常的捕获或者二次处理(比如sql异常正常情况下是不能外抛)是非常必要的，比如在开发对外api服务时，约定了响应的参数格式，如code、msg，调用方根据错误码进行自己的业务逻辑
 *    spring boot中，默认在发送异常时，会跳转至/error请求进行错误展示，根据不同的content-type展现不同的错误结果，如json请求时，直接返回json格式参数
 */

@SpringBootApplication
public class ExceptionHandleValidApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExceptionHandleValidApplication.class, args);
    }

}
