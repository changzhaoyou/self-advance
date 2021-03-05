package com.ycz.pattern.command;

/**
 * Created by ycz on  2021/02/26/3:31 下午
 * 具体命令类
 */
public class OpenCommand implements Command{

    private CourseVideo courseVideo;

    public OpenCommand(CourseVideo courseVideo) {
        this.courseVideo = courseVideo;
    }

    @Override
    public void execute() {
        courseVideo.open();
    }
}
