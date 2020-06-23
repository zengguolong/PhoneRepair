package com.project.dragon.rabbitmq;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageMQ {

//    @RabbitListener(queues = "myQueue")
//    @RabbitListener(queuesToDeclare = @Queue("myQueue"))//自动创建队列
//    //自动创建 Exchange 和 Queue绑定
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue("myQueue"),
//            exchange = @Exchange("myExchange")
//    ))
//    public void process(String message){
//        System.out.println(message);
//    }
}
