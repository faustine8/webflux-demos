package com.faustine;

import io.reactivex.rxjava3.core.Observable;

public class Main3 {
    public static void main(String[] args) {
        Observable<String> observable = Observable.create(emitter -> {
            for (int i = 0; i < 10; i++) {
                emitter.onNext();
            }
        });
    }
}