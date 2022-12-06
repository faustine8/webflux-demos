package com.faustine.demo;

import io.reactivex.rxjava3.core.Observable;

public class ConcatMain {
    public static void main(String[] args) {

        // concat 拼接流

//        Observable.concat(
//                Observable.just(1, 2, 3, 4, 5),
//                Observable.fromArray(new Integer[]{11, 12, 13, 14, 15}),
//                Observable.create(sub -> {
//                    for (int i = 0; i < 5; i++) {
//                        sub.onNext(100 + i);
//                    }
//                    sub.onComplete();
//                })
//        ).subscribe(
//                System.out::println,
//                System.out::println,
//                () -> System.out.println("流结束")
//        );

        Observable.concat(
                Observable.just(1, 2, 3, 4, 5),
                Observable.fromArray(new Integer[]{11, 12, 13, 14, 15}),
                Observable.create(sub -> {
                    for (int i = 0; i < 5; i++) {
                        sub.onNext(100 + i);
                    }
                    sub.onComplete();
                })
        ).forEach(System.out::println);
    }
}
