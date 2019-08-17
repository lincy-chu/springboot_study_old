package com.robinzhu.timetasks.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Create by zhudapeng
 * 2019-08-17 19:01
 *
 * 相关API简单说明
 *  1.在特定时间执行任务，只执行一次
 *      public void schedule(TimerTask task, Date time)
 *  2.在特定时间之后执行任务，只执行一次
 *      public void schedule(TimerTask task, long delay)
 *  3.指定第一次执行的时间，然后按照间隔时间重复执行
 *      public void schedule(TimerTask task, Date firstTime, long period)
 *  4.在特定延迟之后第一次执行，然后按间隔时间重复执行
 *      public void schedule(TimerTask task, long delay, long period)
 *  5.第一次执行后，特定频率执行
 *      public void scheduleAtFixedRate(TimerTask task, Date firstTime, long period)
 *  6.在delay毫秒之后第一次执行，后按照特定频率执行
 *      public void scheduleAtFixedRate(TimerTask task, long delay, long period)
 *  参数：
 *      .delay：延迟执行的毫秒数，即在delay毫秒之后第一次执行
 *      .period：重复执行的时间间隔
 *  取消任务使用：timer.cancel()方法即可注销任务
 */
@RestController
@Slf4j
public class IndexController {
    @GetMapping("/timer")
    public String doTimer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.info("Timer定时任务启动：" + new Date());
            }
        }, 1000, 1000);//延迟1秒启动，每1秒执行一次
        return "timer";
    }
}
