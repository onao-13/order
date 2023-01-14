package onao.coffee.example.controller.v1;

import onao.coffee.example.data.Orders;
import onao.coffee.example.entity.OrderRequest;
import onao.coffee.example.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    OrdersService ordersService;

    @GetMapping("/{id}/get")
    ResponseEntity<Orders> getById(@PathVariable("id") long id) {
        return ordersService.getById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/buy")
    @ResponseStatus(HttpStatus.CREATED)
    void buy(@RequestBody OrderRequest order) {
        ordersService.buy(order);
    }
}
