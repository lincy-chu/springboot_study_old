package com.robinzhu.timetasks.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Create by zhudapeng
 * 2019-08-17 19:01
 */
@RestController
@Slf4j
public class IndexController {
    /**
     * 1.Timer相关API简单说明
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
     *
     * ScheduledExecutorService
     *  可以说是Timer的替代类，因为Timer不支持多线程，任务是串行的，而且也不捕获异常，假设某个任务异常了，整个Timer就无法运行了
     */
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

    /**
     * 2.ScheduleAtFixedRate API说明
     *  public ScheduledFuture<?> scheduleAtFixedRate(Runnable command,long initialDelay,long period,TimeUnit unit);
     *      command：执行线程
     *      initialDelay：初始化延时
     *      period：两次开始执行最小间隔时间
     *      unit：计时单位
     * public ScheduleWithFixedDelay API说明
     *  public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command,long initialDelay,long delay,TimeUnit unit);
     *      command：执行线程
     *      initialDelay：初始化延时
     *      delay：前一次执行结束到下一次执行开始的时间间隔（间隔执行延迟时间）
     *      unit：计时单位
     */
    @GetMapping("/executor")
    public String ScheduledExecutorService() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                log.info("ScheduledExecutorService定时任务执行：" + new Date());
            }
        }, 1, 1, TimeUnit.SECONDS); // 首次延迟1秒，之后每1秒执行一次
        log.info("ScheduledExecutorService定时任务启动：" + new Date());
        return "ScheduledExecutorService!";
    }

    /**
     * 3.基于SpringTask实现定时任务
     * 使用SpringTask在SpringBoot是很简单的，使用@Scheduled注释即可轻松搞定
     *  1.启动类，加入@EnableScheduling让注解@Scheduled生效
     *  2.编写一个调度类，系统启动后自动扫描，自动执行（见）
     *      @Scheduled(Long fixedRate, Long fixedDelay, Long cron)参数说明：
     *          fixedRate：定义一个按一定频率执行的定时任务
     *          fixedDelay：定义一个按一定频率指定的定时任务，与上面不同的是，该属性可以配合initialDelay，定义该任务延迟执行时间
     *          cron：通过表达式来配置任务执行时间
     *  Cron表达式详解
     *      一个cron表达式有至少6个（也可能7个）有空格分割的时间元素
     *      依次顺序如下所示：
     *          字段      允许值             允许的特殊符号
     *          秒        0~59              , - * /
     *          分        0~59              , - * /
     *          小时      0~59              , - * /
     *          日期      0~23              , - * / ? L W C
     *          月份      1~12或JAN~DEC     , - * /
     *          星期      1~7或SUN~SAT      , _ * / ? L C #
     *          年（可选） 留空，1970~2099   , - * /
     *      简单举例：
     *          0/1 * * * * ?：每秒执行一次
     *          0 0 2 1 * ?：表示在每个月的1日凌晨2点执行任务
     *          0 0 10,14,16 ?：每天的10点、14点、16点执行任务
     *          0 0 12 * * ?：每天中午12点执行任务
     *          0 15 10 ? * MON-FRI：周一到周五的10点15分执行任务
     *      更多表达式，可访问http://cron.qqe2.com/进行在线表达式编写，简单明了
     *
     */
}
