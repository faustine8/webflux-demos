package com.faustine.observe.demo;

public class MyObserver1 implements Observer {
    @Override
    public void observe(String event) {
        System.out.println("观察者1 ==> " + event);
    }
}
