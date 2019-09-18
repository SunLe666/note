package com.sunle.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.2")
public class FanoutReceiver2 {

    @RabbitHandler
    public void process(String message) {
        System.out.println("fanout Receiver 2  : " + message);
    }

}