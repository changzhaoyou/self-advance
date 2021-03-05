package com.ycz.pattern.state;

/**
 * Created by ycz on  2021/02/22/2:34 下午
 * 抽象状态类
 */
public abstract class VideoState {

    protected VideoContext videoContext;

    public void setVideoContext(VideoContext videoContext) {
        this.videoContext = videoContext;
    }

    /**
     * 播放
     */
    public abstract void play();

    /**
     * 暂停
     */
    public abstract void pause();

    /**
     * 快进
     */
    public abstract void speed();

    /**
     * 停止
     */
    public abstract void stop();
}
