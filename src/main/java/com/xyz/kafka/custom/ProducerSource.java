package com.xyz.kafka.custom;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ProducerSource {

    String OUTPUT = "output";

    @Output(ProducerSource.OUTPUT)
    MessageChannel output();

}
