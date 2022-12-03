package com.faustine.webflux.test;

import com.faustine.demo.AsyncSubscriber;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.reactivestreams.tck.SubscriberWhiteboxVerification;
import org.reactivestreams.tck.TestEnvironment;

import java.util.concurrent.Executors;

public class TCKWhiteBoxTest extends SubscriberWhiteboxVerification<Integer> {

    protected TCKWhiteBoxTest() {
        super(new TestEnvironment());
    }

    @Override
    public Subscriber<Integer> createSubscriber(WhiteboxSubscriberProbe<Integer> probe) {
        AsyncSubscriber subscriber = new AsyncSubscriber(Executors.newFixedThreadPool(2)) {
            @Override
            protected boolean whenNext(Object element) {
                System.out.println("接收到的元素：" + element);
                // 返回true，接着请求下个元素，false表示不再请求了
                return true;
            }

            @Override
            public void onSubscribe(Subscription subscription) {
                super.onSubscribe(subscription);
                probe.registerOnSubscribe(new SubscriberPuppet() {
                    @Override
                    public void triggerRequest(long elements) {
                        subscription.request(elements);
                    }

                    @Override
                    public void signalCancel() {
                        subscription.cancel();
                    }
                });
            }

            @Override
            public void onNext(Object element) {
                super.onNext(element);
                // 注册钩子
                probe.registerOnNext((Integer) element);
            }

            @Override
            public void onError(Throwable t) {
                super.onError(t);
                probe.registerOnError(t);
            }

            @Override
            public void onComplete() {
                super.onComplete();
                probe.registerOnComplete();
            }
        };

        return subscriber;
    }

    @Override
    public Integer createElement(int element) {
        return element;
    }
}
