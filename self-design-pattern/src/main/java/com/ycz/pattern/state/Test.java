package com.ycz.pattern.state;

/**
 * Created by ycz on  2021/02/22/3:37 下午
 */
public class Test {

    public static void main(String[] args) {
        VideoContext context=new VideoContext();
        context.setVideoState(new PlayState());
        context.play();
        System.out.println("当前类："+context.getVideoState().getClass().getSimpleName());
        context.pause();
        System.out.println("当前类："+context.getVideoState().getClass().getSimpleName());
        context.speed();
        System.out.println("当前类："+context.getVideoState().getClass().getSimpleName());
        context.stop();
        System.out.println("当前类："+context.getVideoState().getClass().getSimpleName());
        context.speed();
        System.out.println("当前类："+context.getVideoState().getClass().getSimpleName());
        context.play();
        System.out.println("当前类："+context.getVideoState().getClass().getSimpleName());
    }
}
