package com.faustine;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureMain {
    public static void main(String[] args) {

        Future<String> future = Executors.newCachedThreadPool().submit(() -> "Hello");

        Observable.fromFuture(future).subscribe(System.out::println);
    }
}
