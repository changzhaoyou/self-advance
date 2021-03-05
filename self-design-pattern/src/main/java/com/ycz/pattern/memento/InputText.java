package com.ycz.pattern.memento;

/**
 * Created by ycz on  2021/02/24/6:03 下午
 * 原发器(发起人提供创建备忘录和恢复备忘录数据)
 */
public class InputText {

    private StringBuilder text = new StringBuilder();

    public Snapshot createSnapshot() {
        return new Snapshot(text.toString());
    }

    public void restoreSnapshot(Snapshot snapshot) {
        this.text.replace(0, text.length(), snapshot.getText());
    }

    public void append(String input) {
        text.append(input);
    }

    public StringBuilder getText() {
        return text;
    }

    public void setText(StringBuilder text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "InputText{" +
                "text=" + text +
                '}';
    }
}
