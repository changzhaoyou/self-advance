package com.ycz.pattern.mediate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ycz on  2021/02/26/5:56 下午
 * 具体中介类
 */
public class ConcreteMediator implements Mediator {

    private List<Colleague> colleagueList = new ArrayList<>();

    @Override
    public void register(Colleague colleague) {
        colleagueList.add(colleague);
        colleague.setMediator(this);
    }

    @Override
    public void relay(Colleague colleague) {
        for (Colleague coll : colleagueList) {
            if (!colleague.equals(coll)) {
                coll.receive();
            }
        }
    }
}
