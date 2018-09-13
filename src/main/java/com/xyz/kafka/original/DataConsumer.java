package com.xyz.kafka.original;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import bean.SinkTimeInfo;

    @EnableBinding(Sink.class)
    public class DataConsumer {

        @StreamListener(Sink.INPUT)
        public void loggerSink(SinkTimeInfo sinkTimeInfo) {
            System.out.println("Received: " + sinkTimeInfo.toString());
        }

    }
}
