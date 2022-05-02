package com.fgrapp.learn.atomic;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author fan guangrui 2022年05月02日 16:34
 */
public class AtomicIntegerFieldUpdaterTest {
    class DemoData{
        public volatile int value1 = 1;
        volatile int value2 = 2;
        protected volatile int value3 = 3;
        private volatile int value4 = 4;
    }
    AtomicIntegerFieldUpdater<DemoData> getUpdater(String fieldName) {
        return AtomicIntegerFieldUpdater.newUpdater(DemoData.class, fieldName);
    }
    @Test
    void doit() {
        DemoData demoData = new DemoData();
        System.out.println("1===> "+ getUpdater("value1").getAndSet(demoData,10));
        System.out.println("after 1===> " + getUpdater("value1").get(demoData));
        System.out.println("2===> " + getUpdater("value2").incrementAndGet(demoData));
        System.out.println("3===> "+ getUpdater("value3").decrementAndGet(demoData));
        System.out.println("4===> " + getUpdater("value4").compareAndSet(demoData, 4, 5));
    }

}
