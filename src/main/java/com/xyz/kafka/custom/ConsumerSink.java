package com.xyz.kafka.custom;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ConsumerSink {

    String INPUT = "input";
    @Input(ConsumerSink.INPUT)
    SubscribableChannel input();
}