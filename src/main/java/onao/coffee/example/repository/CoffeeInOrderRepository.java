package onao.coffee.example.repository;

import onao.coffee.example.data.CoffeesInOrder;

import java.util.List;
import java.util.Optional;

public interface CoffeeInOrderRepository {
    void persist(CoffeesInOrder coffees);
    Optional<List<CoffeesInOrder>> find(long orderId);
}
