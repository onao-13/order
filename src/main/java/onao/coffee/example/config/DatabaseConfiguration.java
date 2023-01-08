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
    void configure() {
        DataSourceConfig sourceConfig = new DataSourceConfig();
        sourceConfig.setUsername("user");
        sourceConfig.setPassword("pass");
        sourceConfig.setUrl("postgres://user:pass@postgres/test");

        DatabaseConfig config = new DatabaseConfig();
        config.setDataSourceConfig(sourceConfig);

        Database database = DatabaseFactory.create(config);
    }
}
