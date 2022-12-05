package com.faustine.observe.demo;

public class MyObserver2 implements Observer {
    @Override
    public void observe(String event) {
        System.out.println("观察者2 ==> " + event);
    }
}
