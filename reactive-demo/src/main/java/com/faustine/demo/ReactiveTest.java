package com.faustine.demo;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReactiveTest {
    public static void main(String[] args) {

        // 1.创建 Publisher 对象
        Set<Integer> elements = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            elements.add(i);
        }
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        AsyncIterablePublisher<Integer> publisher = new AsyncIterablePublisher<>(elements, executorService);

        // 2.创建 Subscriber 对象
        AsyncSubscriber<Integer> subscriber = new AsyncSubscriber<>(Executors.newFixedThreadPool(2)) {
            @Override
            protected boolean whenNext(Integer element) {
                System.out.println("接收到的流元素:" + element);
                return true;
            }
        };

        // 3.订阅
        publisher.subscribe(subscriber);
    }

}
