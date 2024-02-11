package joola.graphqlsample.repository;

import jakarta.annotation.PostConstruct;
import joola.graphqlsample.model.DeliveryMode;
import joola.graphqlsample.model.Flower;
import joola.graphqlsample.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderRepository {
    private List<Order> orders = new ArrayList<>();
    public List<Order> findAll(){
        return orders;
    }
    public List<Order> findByOwnerName(String name){
        return orders.stream()
                .filter(flower -> flower.owner().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }
    @PostConstruct
    private void init(){
        orders.add(new Order(new Flower("lily", "white"),"fatemeh","black", DeliveryMode.BIKE_DELIVERY));
        orders.add(new Order(new Flower("carnation", "red"),"sara","red", DeliveryMode.BIKE_DELIVERY));
        orders.add(new Order(new Flower("orchid", "white"),"hasty","white", DeliveryMode.CAR_DELIVERY));
        orders.add(new Order(new Flower("hibiscus", "red"),"setayesh","pink", DeliveryMode.NONE));
        orders.add(new Order(new Flower("peony", "pink"),"mia","black", DeliveryMode.NONE));
    }
}
