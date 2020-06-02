package com.moolng.order.config.start;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("moolng.mq")
public class MQServiceProperties {

    private boolean openConsumer;

    public boolean isOpenConsumer() {
        return openConsumer;
    }

    public void setOpenConsumer(boolean openConsumer) {
        this.openConsumer = openConsumer;
    }
}
