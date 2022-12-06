package com.faustine.op;

import io.reactivex.rxjava3.core.Observable;

public class ZipDemo {
    public static void main(String[] args) {
        Observable.zip(
                Observable.just(1, 2, 3, 4, 5), // 响应式流1
                Observable.just("a", "b", "c", "d", "e"), // 响应式流2
                (item1, item2) -> item1 + "_" + item2 // 合并算子
        ).forEach(System.out::println);
    }
}
