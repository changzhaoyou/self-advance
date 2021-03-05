package com.ycz.pattern.observer.async.test;

/**
 * 事件实体
 */
public class LogEvent {

    private String message;

    public LogEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "LogEvent{" +
                "message='" + message + '\'' +
                '}';
    }
}
