package com.ycz.pattern.prototype;

import java.io.Serializable;

/**
 * 引用类型对象
 */
public class DeepCloneDetail implements Serializable {
    private String desc;

    public DeepCloneDetail(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "DeepCloneDetail{" +
                "desc='" + desc + '\'' +
                '}';
    }
}
