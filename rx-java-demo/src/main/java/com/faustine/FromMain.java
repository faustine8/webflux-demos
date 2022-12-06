package com.faustine;

import io.reactivex.rxjava3.core.Observable;

public class FromMain {
    public static void main(String[] args) {
        Observable<Integer> integerObservable = Observable.fromArray(new Integer[]{1, 2, 3, 4, 5});

        integerObservable.subscribe(
                System.out::println,
                System.out::println,
                () -> System.out.println("流结束")
        );
    }
}
