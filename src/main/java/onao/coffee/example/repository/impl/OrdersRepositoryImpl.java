package onao.coffee.example.repository.impl;


import io.ebean.DB;
import io.ebean.annotation.Transactional;
import onao.coffee.example.data.Orders;
import onao.coffee.example.repository.OrdersRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
class OrdersRepositoryImpl implements OrdersRepository {

    @Override
    public Optional<Orders> findById(long id) {
        return Optional.ofNullable(
                DB.find(Orders.class)
                        .where().eq("id", id)
                        .findOne()
        );
    }

    @Override
    public Optional<List<Orders>> findAllByUserId(long id) {
        return Optional.empty();
    }

    @Override
    public void persist(Orders orders) {
        DB.save(orders);
    }
}
