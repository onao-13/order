package onao.coffee.example.service.impl;

import onao.coffee.example.data.Coffees;
import onao.coffee.example.repository.CoffeesRepository;
import onao.coffee.example.service.CoffeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class CoffeesServiceImpl implements CoffeesService {

    @Autowired
    CoffeesRepository coffeesRepository;

    @Override
    public Coffees findById(long id) {
        return coffeesRepository.findById(id).orElse(new Coffees());
    }
}
