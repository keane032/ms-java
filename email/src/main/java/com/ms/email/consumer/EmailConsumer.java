package com.ms.email.consumer;

import com.ms.email.dtos.EmailRecorderDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailRecorderDto  email){
        System.out.println(email.emailTo());
    }

}
