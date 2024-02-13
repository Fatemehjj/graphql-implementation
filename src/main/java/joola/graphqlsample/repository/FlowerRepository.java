package joola.graphqlsample.repository;

import jakarta.annotation.PostConstruct;
import joola.graphqlsample.model.Flower;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FlowerRepository {
    private final List<Flower> flowers = new ArrayList<>();
    public List<Flower> findAll(){
       return flowers;
    }
    public List<Flower> findByName(String name){
        return flowers.stream()
                .filter(flower -> flower.name().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }
    @PostConstruct
   private void init(){
        flowers.add(new Flower("daisy", "white"));
        flowers.add(new Flower("rose", "yellow"));
        flowers.add(new Flower("rose", "red"));
        flowers.add(new Flower("lily", "white"));
        flowers.add(new Flower("lavender", "purple"));
        flowers.add(new Flower("peony", "pink"));
        flowers.add(new Flower("carnation", "red"));
        flowers.add(new Flower("orchid", "white"));
        flowers.add(new Flower("orchid", "red"));
        flowers.add(new Flower("orchid", "pink"));
        flowers.add(new Flower("hibiscus", "red"));

   }
}
