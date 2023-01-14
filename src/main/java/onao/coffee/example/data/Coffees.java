package onao.coffee.example.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "coffees")
@Data
@EqualsAndHashCode
public class Coffees {

    @JsonIgnore
    @Id
    private long id;
    private String name;
    private Float price;
}
