package com.ycz.pattern.state;

/**
 * Created by ycz on  2021/02/22/3:32 下午
 */
public class SpeedState extends VideoState {
    @Override
    public void play() {
        this.videoContext.setVideoState(VideoContext.PLAY_STATE);
    }

    @Override
    public void pause() {
        this.videoContext.setVideoState(VideoContext.PAUSE_STATE);
    }

    @Override
    public void speed() {
        System.out.println("加速播放视频");
    }

    @Override
    public void stop() {
        this.videoContext.setVideoState(VideoContext.STOP_STATE);
    }
}
