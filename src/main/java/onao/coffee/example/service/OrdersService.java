package onao.coffee.example.service;

import onao.coffee.example.data.Orders;
import onao.coffee.example.entity.OrderRequest;

import java.util.List;
import java.util.Optional;

public interface OrdersService {
    Optional<Orders> getById(long id);
    Optional<List<Orders>> getAllByUserId(long id);
    void buy(OrderRequest orderRequest);
}
