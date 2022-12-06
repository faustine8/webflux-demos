package com.faustine.demo;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;

public class Main3 {
    public static void main(String[] args) {
        Observable.create((ObservableOnSubscribe<String>) emitter -> {
            for (int i = 0; i < 10; i++) {
                emitter.onNext("rxjava 3 ==> " + i);
            }
            emitter.onComplete();
        }).subscribe(
                System.out::println,
                System.out::println,
                () -> System.out.println("流结束")
        );
    }
}