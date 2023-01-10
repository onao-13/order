package onao.coffee.example.config;

import io.ebean.Database;
import io.ebean.DatabaseFactory;
import io.ebean.config.DatabaseConfig;
import io.ebean.datasource.DataSourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfiguration {

    @Bean
    Database configure() {
        DataSourceConfig sourceConfig = new DataSourceConfig();
        sourceConfig.setUsername("user");
        sourceConfig.setPassword("pass");
        sourceConfig.setUrl("jdbc:postgresql://postgres:5432/test");

        DatabaseConfig config = new DatabaseConfig();
        config.setDataSourceConfig(sourceConfig);

        return DatabaseFactory.create(config);
    }
}
