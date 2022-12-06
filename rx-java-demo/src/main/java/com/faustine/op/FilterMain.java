package com.faustine.op;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class FilterMain {
    public static void main(String[] args) throws InterruptedException {
        Observable.interval(100, TimeUnit.MILLISECONDS)
                .filter(item -> item % 3 == 0)
                .forEach(System.out::println);

        Thread.sleep(10_000);

    }
}
