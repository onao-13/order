package onao.coffee.example.repository;

import onao.coffee.example.data.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    Optional<Order> findById(long id);
    Optional<List<Order>> findAllByUserId(long id);
    void persist(Order order);
}
