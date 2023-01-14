package onao.coffee.example.config;

import io.ebean.DatabaseFactory;
import io.ebean.config.DatabaseConfig;
import io.ebean.datasource.DataSourceConfig;
import onao.coffee.example.data.Coffees;
import onao.coffee.example.data.CoffeesInOrder;
import onao.coffee.example.data.Orders;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class DBConfig {

    @Bean
    void configure() {
        DataSourceConfig sourceConfig = new DataSourceConfig();
        sourceConfig.setUsername("user")
                .setPassword("pass")
                .setUrl("jdbc:postgresql://postgres/test")
                .setDriver("org.postgresql.Driver");

        DatabaseConfig config = new DatabaseConfig();
        config.setDataSourceConfig(sourceConfig);
        config.addClass(Coffees.class);
        config.addClass(CoffeesInOrder.class);
        config.addClass(Orders.class);

        DatabaseFactory.create(config);
    }
}
