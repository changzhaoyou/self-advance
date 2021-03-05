package com.ycz.pattern.state;

/**
 * Created by ycz on  2021/02/22/2:51 下午
 * 环境类
 */
public class VideoContext {

    protected VideoState videoState;
    public final static VideoState PLAY_STATE = new PlayState();
    public final static VideoState PAUSE_STATE = new PauseState();
    public final static VideoState SPEED_STATE = new SpeedState();
    public final static VideoState STOP_STATE = new StopState();

    public VideoState getVideoState() {
        return videoState;
    }

    public void setVideoState(VideoState videoState) {
        this.videoState = videoState;
        this.videoState.setVideoContext(this);
    }

    public void play() {
        this.videoState.play();
    }

    public void pause() {
        this.videoState.pause();
    }

    public void speed() {
        this.videoState.speed();
    }

    public void stop() {
        this.videoState.stop();
    }
}
