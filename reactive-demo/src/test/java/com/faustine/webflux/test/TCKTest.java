package com.faustine.webflux.test;

import com.faustine.demo.AsyncIterablePublisher;
import org.reactivestreams.Publisher;
import org.reactivestreams.tck.PublisherVerification;
import org.reactivestreams.tck.TestEnvironment;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * String 表示要测试的发布者的流元素类型是 String 类型的
 */
public class TCKTest extends PublisherVerification<String> {

    public TCKTest() {
        super(new TestEnvironment());
    }

    @Override
    public Publisher createPublisher(long elements) {

        Set<String> set = new HashSet<>();
        for (long i = 0; i < elements; i++) {
            set.add("hello-" + i);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        AsyncIterablePublisher publisher = new AsyncIterablePublisher(set, executorService);

        return publisher;
    }

    @Override
    public Publisher createFailedPublisher() {
        Set set = new HashSet<>();
        set.add(new RuntimeException("手动异常"));
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        return new AsyncIterablePublisher(set, executorService);
    }

    /**
     * 用于指定测试的响应式流中有几个元素需要测试。默认是 Long.MAX_VALUE - 1
     * @return
     */
    @Override
    public long maxElementsFromPublisher() {
//        return super.maxElementsFromPublisher();
        return 10;
    }
}
