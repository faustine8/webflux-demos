package com.faustine;

import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;

public class CollectionMain {
    public static void main(String[] args) {

        var list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        Observable<Object> objectObservable = Observable.fromIterable(list);

        objectObservable.subscribe(
                System.out::println,
                System.out::println
        );

    }
}
