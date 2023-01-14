package onao.coffee.example.service;

import onao.coffee.example.data.CoffeesInOrder;

import java.util.List;

public interface CoffeesInOrderService {
    void add(List<CoffeesInOrder> coffees);
    List<CoffeesInOrder> get(long orderId);
}
