package onao.coffee.example.repository.impl;

import io.ebean.DB;
import onao.coffee.example.data.CoffeesInOrder;
import onao.coffee.example.repository.CoffeeInOrderRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
class CoffeesInOrderRepositoryImpl implements CoffeeInOrderRepository {
    @Override
    public void persist(CoffeesInOrder coffees) {
        DB.save(coffees);
    }

    @Override
    public Optional<List<CoffeesInOrder>> find(long orderId) {
        return Optional.ofNullable(
                DB.find(CoffeesInOrder.class)
                        .where().eq("orders_id", orderId)
                        .findList()
        );
    }
}
