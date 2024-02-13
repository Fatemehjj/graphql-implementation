package joola.graphqlsample.controller;

import joola.graphqlsample.model.Order;
import joola.graphqlsample.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    OrderRepository orderRepository;
    @QueryMapping
    public List<Order> allOrders(){
        return orderRepository.findAll();
    }
    @QueryMapping
    public List<Order> findByOwnerName(@Argument String owner){
        return orderRepository.findByOwnerName(owner);
    }
}

