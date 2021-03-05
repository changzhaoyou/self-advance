package com.ycz.pattern.command;

/**
 * Created by ycz on  2021/02/26/3:36 下午
 */
public class Test {

    public static void main(String[] args) {
        CourseVideo courseVideo = new CourseVideo("视频课程");
        OpenCommand openCommand = new OpenCommand(courseVideo);
        CloseCommand closeCommand=new CloseCommand(courseVideo);
        Staff staff=new Staff();
        staff.addCommand(openCommand);
        staff.addCommand(closeCommand);
        staff.executeCommands();
    }
}
