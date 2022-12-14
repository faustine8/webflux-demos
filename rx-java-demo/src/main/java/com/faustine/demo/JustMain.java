package com.faustine.demo;

import io.reactivex.rxjava3.core.Observable;

public class JustMain {
    public static void main(String[] args) {
        Observable<String> just = Observable.just("1", "2", "3", "4", "5");

        just.subscribe(
                item -> System.out.println("下一个元素:" + item),
                ex -> System.out.println("异常信息:" + ex.getMessage()),
                () -> System.out.println("流结束")
        );
    }
}
