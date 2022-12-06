package com.faustine.demo;

import io.reactivex.rxjava3.core.Observable;

public class CallableMain {
    public static void main(String[] args) {
        Observable.fromCallable(() -> "hello")
                .subscribe(System.out::println);
    }
}
