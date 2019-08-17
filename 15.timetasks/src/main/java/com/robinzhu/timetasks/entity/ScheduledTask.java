package com.robinzhu.timetasks.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Create by zhudapeng
 * 2019-08-17 22:28
 */
@Component
@Slf4j
public class ScheduledTask {
    /**
     * 自动扫描，启动时间点之后5秒执行一次
     */
    @Scheduled(fixedRate = 5000)
    public void getCurrentDate() {
        log.info("Scheduled定时任务执行：" + new Date());
    }

}
