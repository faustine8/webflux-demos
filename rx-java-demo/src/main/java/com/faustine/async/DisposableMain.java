package com.faustine.async;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class DisposableMain {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(1);

        // 返回订阅票据
        Disposable subscribe = Observable.interval(100, TimeUnit.MILLISECONDS)
                .subscribe(System.out::println);

        new Thread(() -> {
            try {
                // 等待3s
                Thread.sleep(3_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 如果没有取消订阅，则取消订阅
            if (!subscribe.isDisposed()) subscribe.dispose();
            latch.countDown();
        }).start();

        System.out.println("++++++++++++++++");
        // 主线程阻塞等待
        latch.await();
        System.out.println("----------------");
    }
}
