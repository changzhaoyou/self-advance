package com.ycz.pattern.observer.sync;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体目标类
 */
public class ConcreteSubject implements Subject {
    /**
     * 观察者集合
     */
    private List<Observer> observerList = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observerList) {
            observer.update(message);
        }
    }
}
