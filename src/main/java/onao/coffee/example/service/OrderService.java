package onao.coffee.example.service;

import onao.coffee.example.data.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Optional<Order> getById(long id);
    Optional<List<Order>> getAllByUserId(long id);
    void buy(Order order);
}
