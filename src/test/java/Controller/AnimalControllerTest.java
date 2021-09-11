package Controller;

import br.com.projrabbitaula1.Main;
import br.com.projrabbitaula1.model.Animal;
import br.com.projrabbitaula1.service.AnimalService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class)
@WebAppConfiguration
public class AnimalControllerTest {

    @Autowired
    private AnimalService animalService;

    @Test
    public void send() throws InterruptedException {
        long qtde = 200000;

        animalService.deleteAll();

        for (int i = 1; i<= qtde; i++){
            animalService.send(new Animal("Gato"+i));
        }

        Thread.sleep(5000);
        List<Animal> list = animalService.findAll();
        System.out.println("Qtde. " + list.size());
        Assert.assertEquals(list.size(), qtde);

    }


}
