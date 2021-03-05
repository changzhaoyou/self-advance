package com.ycz.pattern.expression;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ycz on  2021/02/26/5:01 下午
 */
public class TerminalExpression implements Expression{

    private Set<String> set = new HashSet<>();

    public TerminalExpression(String[] data) {
        for (int i = 0; i < data.length; i++) set.add(data[i]);
    }

    public boolean interpret(String info) {
        if (set.contains(info)) {
            return true;
        }
        return false;
    }
}
