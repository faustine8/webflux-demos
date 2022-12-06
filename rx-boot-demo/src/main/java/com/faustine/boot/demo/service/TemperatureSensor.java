package com.faustine.boot.demo.service;

import com.faustine.boot.demo.entity.Temperature;
import org.springframework.stereotype.Component;
import rx.Observable;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
public class TemperatureSensor {

    private final Random random = new Random();

    private final Observable<Temperature> dataStream =
            Observable.range(0, Integer.MAX_VALUE)
                    .concatMap(tick ->
                            Observable.just(tick)
                                    .delay(random.nextInt(5_000), TimeUnit.MILLISECONDS)
                                    .map(tick1 -> this.probe())
                                    .publish()
                                    .refCount()
                    );

    private Temperature probe() {
        return new Temperature(16 + random.nextGaussian() * 10);
    }

    public Observable<Temperature> temperatureStream() {
        return dataStream;
    }


}
