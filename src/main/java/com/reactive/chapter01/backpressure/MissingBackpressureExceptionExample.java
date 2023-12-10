package com.reactive.chapter01.backpressure;

import com.reactive.util.LogType;
import com.reactive.util.Logger;
import com.reactive.util.TimeUtil;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class MissingBackpressureExceptionExample {
    public static void main(String[] args) throws InterruptedException {
        Flowable.interval(1L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
                .observeOn(Schedulers.computation())
                .subscribe(
                        data -> {
                            Logger.log(LogType.PRINT, "# 소비자 처리 대기 중..");
                            TimeUtil.sleep(1000L);
                            Logger.log(LogType.ON_NEXT, data);
                        },
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.ON_COMPLETE)
                );

        Thread.sleep(2000L);
    }
}
