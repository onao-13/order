package onao.coffee.example.data;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import onao.coffee.example.entity.Coffee;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@ToString(exclude = {"coffees"})
@EqualsAndHashCode
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "payment_method")
    private String paymentMethod;

    private Float price;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Coffee> coffees = new ArrayList<>();

    public void addCoffee(Coffee coffee) {
        coffees.add(coffee);
        coffee.setOrder(this);
    }
}
