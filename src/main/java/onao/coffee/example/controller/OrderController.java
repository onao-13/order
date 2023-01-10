package onao.coffee.example.controller;

import onao.coffee.example.data.Order;
import onao.coffee.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/v1/api/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/{id}/get")
    ResponseEntity<Order> getById(@PathVariable("id") long id) {
        return orderService.getById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/buy")
    @ResponseStatus(HttpStatus.CREATED)
    void buy(@RequestBody Order order) {
        orderService.buy(order);
    }
}
