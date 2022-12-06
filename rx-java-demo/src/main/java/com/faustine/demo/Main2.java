package com.faustine.demo;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;

/**
 * RxJava v2写法
 */
public class Main2 {
    public static void main(String[] args) {
        Observable.create((ObservableOnSubscribe<String>) observableEmitter -> {
            for (int i = 0; i < 10; i++) {
                observableEmitter.onNext("rxjava 2 ==> " + i);
            }
            observableEmitter.onComplete();
        }).subscribe(
                System.out::println,
                System.out::println,
                () -> System.out.println("流结束")
        );
    }
}
