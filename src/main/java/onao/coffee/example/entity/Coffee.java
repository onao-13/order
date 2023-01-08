package onao.coffee.example.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import onao.coffee.example.data.Order;

import javax.persistence.*;

@Entity
@Table(name = "coffees")
@ToString(exclude = {"order"})
@EqualsAndHashCode
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private Float price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    public void setOrder(Order order) {
        this.order = order;
    }
}
