package onao.coffee.example.service.impl;

import onao.coffee.example.data.CoffeesInOrder;
import onao.coffee.example.repository.CoffeeInOrderRepository;
import onao.coffee.example.service.CoffeesInOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
class CoffeesInOrderServiceImpl implements CoffeesInOrderService {

    @Autowired
    private CoffeeInOrderRepository coffeeInOrderRepository;

    @Override
    public void add(List<CoffeesInOrder> coffees) {
        coffees.forEach(cof -> coffeeInOrderRepository.persist(cof));
    }

    @Override
    public List<CoffeesInOrder> get(long orderId) {
        return coffeeInOrderRepository.find(orderId).orElse(Collections.emptyList());
    }
}
