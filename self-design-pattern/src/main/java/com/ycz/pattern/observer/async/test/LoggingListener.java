package com.ycz.pattern.observer.async.test;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.ycz.pattern.observer.async.Subscribe;


public class LoggingListener {

    @Subscribe
    @AllowConcurrentEvents
    public void logger(LogEvent logEvent){
        System.out.println("LogEvent通知："+logEvent.getMessage());
    }

    @Subscribe
    @AllowConcurrentEvents
    public void logger(String message){
        System.out.println("字符串事件通知："+message);
    }
}
