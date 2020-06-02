package com.moolng.order.config.start;

public class MQService {

    private boolean openConsumer;

    public MQService(boolean openConsumer) {
        System.out.println(openConsumer);
        this.openConsumer = openConsumer;
    }

}
