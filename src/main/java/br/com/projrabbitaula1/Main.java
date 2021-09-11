package br.com.projrabbitaula1;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    @Value("${queue.animal.name}")
    private String animalQueue;

    public static void main(String[] args) {SpringApplication.run(Main.class, args);}

    @Bean
    public Queue queue(){
        return new Queue(animalQueue, true);
    }

}
