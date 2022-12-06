package com.faustine.demo;

import rx.Observable;

/**
 * RxJava V1 写法
 */
public class Main1 {
    public static void main(String[] args) {
        // 生成响应式流
        Observable.create(
                subscriber -> {
                    for (int i = 0; i < 10; i++) {
                        // 传输响应式流中的元素
                        subscriber.onNext("rx 1  ==> " + i);
                    }
                    // 通知订阅者,响应式流结束
                    subscriber.onCompleted();
                }
        ).subscribe(
                item -> System.out.println("下一个元素是:" + item),
                ex -> System.out.println("响应式流异常:" + ex.getMessage()),
                () -> System.out.println("响应式流结束")
        );

    }
}

// 原始写法
//public class Main1 {
//    public static void main(String[] args) {
//        // 生成响应式流
//        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                for (int i = 0; i < 10; i++) {
//                    // 传输响应式流中的元素
//                    subscriber.onNext("rx 1  ==> " + i);
//                }
//                // 通知订阅者,响应式流结束
//                subscriber.onCompleted();
//            }
//        });
//
//        observable.subscribe(new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//                System.out.println("响应式流结束");
//            }
//
//            @Override
//            public void onError(Throwable throwable) {
//                System.out.println("响应式流异常:" + throwable.getMessage());
//            }
//
//            @Override
//            public void onNext(String s) {
//                System.out.println("下一个响应式流元素:" + s);
//            }
//        });
//
//    }
//}