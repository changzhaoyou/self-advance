package com.ycz.pattern.command;

/**
 * Created by ycz on  2021/02/26/3:27 下午
 * 实现者/接收者（Receiver）角色
 */
public class CourseVideo {

    private String name;

    public CourseVideo(String name) {
        this.name = name;
    }

    public void open(){
        System.out.println("打开视频");
    }

    public void close(){
        System.out.println("关闭视频");
    }
}
