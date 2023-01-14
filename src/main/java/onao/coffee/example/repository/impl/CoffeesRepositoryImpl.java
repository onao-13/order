package onao.coffee.example.repository.impl;

import io.ebean.DB;
import io.ebean.annotation.Transactional;
import onao.coffee.example.data.Coffees;
import onao.coffee.example.repository.CoffeesRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
class CoffeesRepositoryImpl implements CoffeesRepository {

    @Override
    public Optional<Coffees> findById(long id) {
        Coffees coffee = DB.find(Coffees.class)
                .where().eq("id", id)
                .findOne();
        return Optional.ofNullable(coffee);
    }
}
