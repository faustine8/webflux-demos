package com.faustine.op;

import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;

public class CountDemo {
    public static void main(String[] args) {
        var list = new ArrayList<Integer>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        Observable.fromIterable(list)
                .filter(item -> item % 3 ==  0)
                .count() // 生成新的响应式流,该流中只有一个元素,就是上个流中的元素个数
                .subscribe(System.out::println);
    }
}
