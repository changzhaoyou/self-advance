package com.ycz.pattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ycz on  2021/02/26/3:33 下午
 * 调用者/请求者（Invoker）角色
 */
public class Staff {
    /**
     * 命令集合
     */
    private List<Command> commandList = new ArrayList<>();

    public void addCommand(Command command) {
        commandList.add(command);
    }

    public void executeCommands() {
        for (Command command : commandList) {
            command.execute();
        }
    }
}
