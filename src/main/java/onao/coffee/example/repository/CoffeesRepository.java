package onao.coffee.example.repository;

import onao.coffee.example.data.Coffees;

import java.util.Optional;

public interface CoffeesRepository {
    Optional<Coffees> findById(long id);
}
