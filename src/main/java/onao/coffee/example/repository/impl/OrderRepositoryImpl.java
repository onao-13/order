package onao.coffee.example.repository.impl;


import io.ebean.DB;
import onao.coffee.example.data.Order;
import onao.coffee.example.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
class OrderRepositoryImpl implements OrderRepository {

    @Override
    public Optional<Order> findById(long id) {
        return Optional.ofNullable(
                DB.find(Order.class)
                        .where().eq("id", id)
                        .findOne()
        );
    }

    @Override
    public Optional<List<Order>> findAllByUserId(long id) {
        return Optional.empty();
    }

    @Override
    public void persist(Order order) {
        DB.save(order);
    }
}
