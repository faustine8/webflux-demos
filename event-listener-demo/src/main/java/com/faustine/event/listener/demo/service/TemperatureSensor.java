package com.faustine.event.listener.demo.service;

import com.faustine.event.listener.demo.entity.Temperature;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class TemperatureSensor {

    private final ApplicationEventPublisher publisher;
    private final Random random = new Random();
    private final ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

    public TemperatureSensor(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @PostConstruct
    public void startProcessing() {
        this.service.schedule(this::probe, 1, TimeUnit.SECONDS);// 延迟 1s 执行
    }

    private void probe() {
        double temperature = 16 + random.nextGaussian() * 10;
        System.err.println("发送事件。。。");
        // 通过ApplicationEventPublisher发布Temperature事件
        publisher.publishEvent(new Temperature(temperature));
        service.schedule(this::probe, random.nextInt(5000), TimeUnit.MILLISECONDS); // 每次执行的间隔时间是随机的
    }
}

