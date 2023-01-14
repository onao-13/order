package onao.coffee.example.repository;

import onao.coffee.example.data.Orders;

import java.util.List;
import java.util.Optional;

public interface OrdersRepository {
    Optional<Orders> findById(long id);
    Optional<List<Orders>> findAllByUserId(long id);
    void persist(Orders orders);
}
