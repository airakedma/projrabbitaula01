package br.com.projrabbitaula1.rabbit;

import br.com.projrabbitaula1.model.Animal;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void send(Animal animal){
        rabbitTemplate.convertAndSend(this.queue.getName(), animal);
    }

}
