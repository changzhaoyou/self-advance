package com.ycz.pattern.state;

/**
 * Created by ycz on  2021/02/22/2:57 下午
 * 播放状态类
 */
public class PlayState extends VideoState{

    @Override
    public void play() {
        System.out.println("正常播放视频");
    }

    @Override
    public void pause() {
        super.videoContext.setVideoState(VideoContext.PAUSE_STATE);
        super.videoContext.pause();
    }

    @Override
    public void speed() {
        super.videoContext.setVideoState(VideoContext.SPEED_STATE);
    }

    @Override
    public void stop() {
        super.videoContext.setVideoState(VideoContext.STOP_STATE);
    }
}
