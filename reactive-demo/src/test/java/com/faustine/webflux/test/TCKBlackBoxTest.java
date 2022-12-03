package com.faustine.webflux.test;

import com.faustine.demo.AsyncSubscriber;
import org.reactivestreams.Subscriber;
import org.reactivestreams.tck.SubscriberBlackboxVerification;
import org.reactivestreams.tck.TestEnvironment;

import java.util.concurrent.Executors;

public class TCKBlackBoxTest extends SubscriberBlackboxVerification<Integer> {

    protected TCKBlackBoxTest() {
        super(new TestEnvironment());
    }

    @Override
    public Subscriber<Integer> createSubscriber() {

        AsyncSubscriber subscriber = new AsyncSubscriber(Executors.newFixedThreadPool(2)) {
            @Override
            protected boolean whenNext(Object element) {
                System.out.println("接收到的元素：" + element);
                // 返回true，接着请求下个元素，false表示不再请求了
                return true;
            }
        };

        return subscriber;
    }

    @Override
    public Integer createElement(int element) {
        return element;
    }

//    @Override
////    public void triggerRequest(Subscriber<? super Integer> s) {
////        // 在该方法直接向订阅者发射信号。默认该方法什么都不做。
////        AsyncSubscriber<Integer> subscriber = (AsyncSubscriber<Integer>) s;
////        subscriber.onNext(10000);
////    }

}
