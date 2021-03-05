package com.ycz.pattern.state;

/**
 * Created by ycz on  2021/02/22/3:32 下午
 */
public class StopState extends VideoState {
    @Override
    public void play() {
        super.videoContext.setVideoState(VideoContext.PLAY_STATE);
    }

    @Override
    public void pause() {
        System.out.println("视频已停止无法暂停");
    }

    @Override
    public void speed() {
        System.out.println("视频已停止无法加速");
    }

    @Override
    public void stop() {
        System.out.println("视频播放停止");
    }
}
