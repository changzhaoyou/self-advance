package com.ycz.pattern.command;

/**
 * Created by ycz on  2021/02/26/3:32 下午
 * 具体命令类
 */
public class CloseCommand implements Command{

    private CourseVideo courseVideo;

    public CloseCommand(CourseVideo courseVideo) {
        this.courseVideo = courseVideo;
    }

    @Override
    public void execute() {
        courseVideo.close();
    }
}
