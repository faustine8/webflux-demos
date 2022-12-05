package com.faustine.observe.demo;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class MySubject implements Subject{

    /**
     * 用于封装订阅了该主题的观察者 (CopyOnWriteArraySet线程安全)
     */
    private final Set<Observer> observers = new CopyOnWriteArraySet<>();

    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers(String event) {
        observers.forEach(o -> o.observe(event));
    }
}
