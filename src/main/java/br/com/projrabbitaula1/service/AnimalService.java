package br.com.projrabbitaula1.service;

import br.com.projrabbitaula1.model.Animal;
import br.com.projrabbitaula1.rabbit.Producer;
import br.com.projrabbitaula1.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private Producer producer;

    public Animal save(Animal animal){
      return  animalRepository.save(animal);
    }

    public void send (Animal animal){
        producer.send(animal);
    }

    public List<Animal> findAll(){
        return animalRepository.findAll();
    }

    public void deleteAll(){
        animalRepository.deleteAll();
    }
}
