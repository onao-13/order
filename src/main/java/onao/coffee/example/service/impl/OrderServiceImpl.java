package onao.coffee.example.service.impl;

import onao.coffee.example.data.Order;
import onao.coffee.example.repository.OrderRepository;
import onao.coffee.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Optional<Order> getById(long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Optional<List<Order>> getAllByUserId(long id) {
        return Optional.empty();
    }

    @Override
    public void buy(Order order) {
        orderRepository.persist(order);
    }
}
