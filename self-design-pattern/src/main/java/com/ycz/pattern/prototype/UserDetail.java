package com.ycz.pattern.prototype;

import java.util.Date;

/**
 * 引用类型对象
 */
public class UserDetail implements Cloneable {
    private String msg;
    private Date date;

    public UserDetail(String msg, Date date) {
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
     * 重新clone方法
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected UserDetail clone() throws CloneNotSupportedException {
        return (UserDetail) super.clone();
    }
}
