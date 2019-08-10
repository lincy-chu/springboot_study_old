package com.robinzhu.log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 日志输出
 *  格式化日志
 *     输出内容元素具体如下：
 *        .时间日期 -- 精确到毫秒
 *        .日志级别 -- ERROR，WARN，INFO，DEBUG或TRACE
 *        .进程ID
 *        .分隔符 -- --- 标识实际日志的开始
 *        .线程名 -- 方括号括起来（可能会截断控制台输出）
 *        .Logger名 -- 通常使用源码的类名
 *        .日志内容
 *
 * 控制台输出
 *  在Spring Boot中默认配置了ERROR、WARN和INFO级别的日志输出到控制台
 *  我们可以通过两种方式切换至DEBUG级别：
 *      .在运行命令后加入 --debug 标识，如：$ java -jar app.jar --debug
 *      .在application.yml中配置debug = true，该属性设置为true时，核心Logger（包括嵌入式容器、hibernate、spring）会输出更多内容，但是你自己应用的日志并不会输出为DEBUG级别
 *
 * 多彩输出
 *  如果你的终端支持ANSI，设置彩色输出会让日志更具可读性。通过在application.yml中设置spring.out.ansi.enabled参数来支持
 *      .NEVER：禁用ANSI-colored输出（默认值）
 *      .DETECT：会检查终端是否支持ANSI，是的话就采用彩色输出（推荐项）
 *      .ALWAYS：总是使用ANSI-colored格式输出，若终端不支持的时候，会有很多干扰信息，不推荐使用
 *
 * 文件输出
 *  Spring Boot默认配置只会输出到控制台，并不会记录到文件中，但是我们通常生产环境使用时都需要以文件方式记录
 *  若要增加文件输出，需要在application.yml中配置logging.file或logging.path属性
 *      .logging.file，设置文件，可以是绝对路径，也乐意是相对路径，如：logging.file = my.log
 *      .logging.path，设置目录，会在该目录下创建spring.log文件，并写入日志内容，如：logging.path = /var/log
 *  日志文件会在10MB大小左右的时候被截断，产生新的日志文件，默认级别为：ERROR、WARN、INFO
 *
 *  级别输出
 *   在Spring boot中只需要在application.yml中进行配置完成日志记录的级别控制。
 *   配置格式：logging.level.* = LEVEL
 *      .logging.level：日志级别控制前缀，*为包名或Logger名
 *      .LEVEL：选项TRACE、DEBUG、INFO、WARN、ERROR、FATAL、OFF
 *   举例：logging.level.com.robinzhu.log = DEBUG：com.robinzhu.log包下所有class以DEBUG级别输出
 *        logging.level.root = WARN：root日志以WARN级别输出
 */
@SpringBootApplication
public class LogApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogApplication.class, args);
    }

}
