package com.xyz.kafka.custom;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import bean.Order;

@EnableBinding(ProducerSource.class)
@Component
public class Producer {

    @Autowired
    private ProducerSource source;

    @Scheduled(fixedRate = 3000)
    public void produceHotDrinks() {
        try {
            source.output().send(MessageBuilder.withPayload(Order.builder().flag("Hot").num(new Random().nextInt(100)).build()).build());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Scheduled(fixedRate = 3000)
    public void produceColdDrinks() {
        source.output().send(MessageBuilder.withPayload(Order.builder().flag("Cold").num(new Random().nextInt(100)).build()).build());
    }
}
