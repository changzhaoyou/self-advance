package com.ycz.pattern.prototype;

import java.util.Date;

/**
 * 引用类型对象
 */
public class Detail implements Cloneable {
    private String msg;
    private Date date;

    public Detail(String msg, Date date) {
        this.msg = msg;
        this.date = date;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 重写clone()方法
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Detail clone() throws CloneNotSupportedException {
        return (Detail) super.clone();
    }

    @Override
    public String toString() {
        return "Detail{" +
                "msg='" + msg + '\'' +
                ", date=" + date +
                '}';
    }
}
