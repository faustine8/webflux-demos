package com.faustine.async;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // 创建基于时间的异步的响应式流
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(System.out::println);

        // 主线程休眠,等待其他线程执行完成
        Thread.sleep(5_000);
    }
}
