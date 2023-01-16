package onao.coffee.example.feign;

import onao.coffee.example.data.Orders;
import onao.coffee.example.entity.OrderRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient("order-service")
public interface OrderApiFeignClient {
    @GetMapping("/{id}/get")
    ResponseEntity<Orders> getById(@PathVariable("id") long id);

    @PostMapping("/buy")
    void buy(@RequestBody OrderRequest order);
}
