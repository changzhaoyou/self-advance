package com.ycz.pattern.observer.async.simple;

/**
 * @author zhangzhaoyou
 * 订阅消息体
 */
public class Message {

    private String msg;

    private String identify;

    public Message(String msg, String identify) {
        this.msg = msg;
        this.identify = identify;
    }

    @Override
    public String toString() {
        return "Message{" +
                "msg='" + msg + '\'' +
                ", identify='" + identify + '\'' +
                '}';
    }
}
