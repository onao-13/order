package onao.coffee.example.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "coffees_in_order")
@Data
@EqualsAndHashCode
public class CoffeesInOrder {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private int coffeeId;
    private int coffeeCount;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Orders orders;
}
