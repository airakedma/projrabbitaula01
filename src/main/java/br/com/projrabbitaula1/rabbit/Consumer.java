package br.com.projrabbitaula1.rabbit;

import br.com.projrabbitaula1.model.Animal;
import br.com.projrabbitaula1.service.AnimalService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    private AnimalService animalService;

    @RabbitListener(queues = "${queue.animal.name}")
    public void receive(@Payload Animal animal){
        animalService.save(animal);
    }

}
