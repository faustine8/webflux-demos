package com.faustine.async;

import rx.Observable;
import rx.Subscription;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class SubscriptionMain {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);

        // 创建基于时间的异步响应流. 返回订阅票据.
        Subscription subscription = Observable.interval(100, TimeUnit.MILLISECONDS)
                .subscribe(System.out::println);

        new Thread(() -> {
            try {
                Thread.sleep(5_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // 如果订阅者没有取消订阅,则取消订阅
            if (subscription.isUnsubscribed()) {
                subscription.unsubscribe();
            }
            latch.countDown();
        }).start();

        System.out.println("==================");
        latch.await();
        System.out.println("------------------");
    }
}
