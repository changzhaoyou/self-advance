package com.ycz.pattern.memento;

/**
 * Created by ycz on  2021/02/24/6:04 下午
 * 备忘录（提供保存发起人内部状态）
 */
public class Snapshot {

    private String text;

    public Snapshot(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
