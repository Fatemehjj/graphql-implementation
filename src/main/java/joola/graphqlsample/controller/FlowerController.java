package joola.graphqlsample.controller;

import joola.graphqlsample.model.Flower;
import joola.graphqlsample.repository.FlowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class FlowerController {
    @Autowired
  private FlowerRepository flowerRepository;
    @QueryMapping
    public List<Flower> allFlowers(){
        return flowerRepository.findAll();
    }
    @QueryMapping
    public List<Flower> findByName(@Argument String name){
        return flowerRepository.findByName(name);
    }
}
