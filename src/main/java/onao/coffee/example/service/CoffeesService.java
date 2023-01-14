package onao.coffee.example.service;

import onao.coffee.example.data.Coffees;

public interface CoffeesService {
    Coffees findById(long id);
}
