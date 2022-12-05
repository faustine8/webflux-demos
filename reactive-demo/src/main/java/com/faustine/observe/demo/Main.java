package com.faustine.observe.demo;

public class Main {
    public static void main(String[] args) {
        MySubject subject = new MySubject();
        MyObserver1 o1 = new MyObserver1();
        MyObserver2 o2 = new MyObserver2();

        subject.registerObserver(o1);
        subject.registerObserver(o2);

        subject.notifyObservers("事件1");
        subject.notifyObservers("事件2");

        System.out.println("-------------------");
        subject.unregisterObserver(o1);

        subject.notifyObservers("事件3");

    }
}
