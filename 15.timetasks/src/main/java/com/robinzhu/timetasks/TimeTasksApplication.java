package com.robinzhu.timetasks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 定时任务
 *    在开发过程中经常会碰见定时任务，比如每天定时清理无效数据、定时发送短信、定时发送邮件、支付系统中的定时对账等等，往往都会一些定时器，进行此业务的开发。
 * 一点知识
 *    在Java开发领域，目前可以通过以下几种方法进行定时任务：
 *      .Timer：jdk中自带的一个定时调度类，可以简单的实现按某一频度进行任务执行。提供的功能比较单一，无法实现复杂的调度任务。
 *      .ScheduledExecutorService：也是jdk自带的一种基于线程池设计的定时任务类。其每个调度任务都会分配到线程池中的一个线程执行，所以其任务是并发执行的，互不影响。
 *      .Spring Task：Spring提供的一种任务调度工具，支持注解和配置文件形式，支持Cron表达式，使用简单但功能强大。
 *      Quartz：一款功能强大的任务调度器，可以实现较为复杂的调度功能，如每个月一号执行、每天凌晨执行、每周五执行等等，还支持分布式调度，就是配置稍显复杂。
 */
@SpringBootApplication
@EnableScheduling
@Slf4j
public class TimeTasksApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimeTasksApplication.class, args);
        log.info("TimeTask启动!");
    }

}
