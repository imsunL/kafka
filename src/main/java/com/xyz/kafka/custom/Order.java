package com.xyz.kafka.custom;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import bean.Order;

@EnableBinding(ConsumerSink.class)
public class Consumer {

    @StreamListener(ConsumerSink.INPUT)
    public void listen(Order order) {
        System.out.println("Order Received: " + order);

    }
}
