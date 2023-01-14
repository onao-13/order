package onao.coffee.example.entity;

import lombok.Data;
import lombok.ToString;
import onao.coffee.example.data.CoffeesInOrder;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class OrderRequest {
    private String username;
    private String paymentMethod;
    List<CoffeesInOrder> coffees = new ArrayList<>();
}
