package com.reactive;

import io.reactivex.Observable;

public class HelloRxJava {
    public static void main(String[] args) {
        Observable<String> observable = Observable.just("Hello", "World");
        observable.subscribe(System.out::println);
    }
}
