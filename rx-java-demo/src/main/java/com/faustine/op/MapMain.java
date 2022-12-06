package com.faustine.op;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;

public class MapMain {
    public static void main(String[] args) {
        Observable.just(1,2,3,4,5)
                .map(item -> {
                    var strArr = new String[item];
                    Arrays.fill(strArr, "a");
                    return strArr;
                }).forEach(item -> System.out.println(Arrays.toString(item)));
    }
}
