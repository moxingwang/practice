package com.mo.websocket.configuration;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;

/**
 * @description:
 * @author: MoXingwang 2018-08-07 09:31
 **/
public class CustomerTaskScheduler implements TaskScheduler {
    @Override
    public ScheduledFuture<?> schedule(Runnable runnable, Trigger trigger) {
        return null;
    }

    @Override
    public ScheduledFuture<?> schedule(Runnable runnable, Date date) {
        return null;
    }

    @Override
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, Date date, long l) {
        return null;
    }

    @Override
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long l) {
        return null;
    }

    @Override
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, Date date, long l) {
        return null;
    }

    @Override
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long l) {
        return null;
    }
}
