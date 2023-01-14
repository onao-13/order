package onao.coffee.example.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@Builder
@EqualsAndHashCode
public class Orders {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String username;
    private String paymentMethod;
    private Float price;

    @OneToMany(mappedBy = "orders")
    private List<CoffeesInOrder> coffees;

    public void addCoffees(List<CoffeesInOrder> coffeeList) {
        coffees = coffeeList;
        coffeeList.forEach(cof -> cof.setOrders(this));
    }
}
