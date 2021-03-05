package com.ycz.pattern.observer.async;

import java.util.concurrent.Executor;

/**
 * 自定义线程池
 */
public final class ObserverExecutors {
    /**
     * 线程
     * @return
     */
    public static Executor directExecutor(){
        return DirectExecutor.INSTANCE;
    }

    /**
     * 枚举Executor
     */
    public enum DirectExecutor implements Executor {
        INSTANCE;

        @Override
        public void execute(Runnable command) {
            command.run();
        }

        @Override
        public String toString() {
            return "DirectExecutor.directExecutor{}";
        }
    }
}
