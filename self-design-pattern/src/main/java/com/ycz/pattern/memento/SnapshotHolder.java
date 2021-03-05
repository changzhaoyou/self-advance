package com.ycz.pattern.memento;

import java.util.Stack;

/**
 * Created by ycz on  2021/02/24/6:15 下午
 * 负责人（存储管理，快照对象存储）
 */
public class SnapshotHolder {

    private Stack<Snapshot> stack = new Stack<>();

    public Snapshot popSnapshot() {
        return stack.pop();
    }

    public void pushSnapshot(Snapshot snapshot) {
        stack.push(snapshot);
    }
}
