package co.ke.proaktivio.configs.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix="mongo_db")
@Data
public class MongoProperties {
    private String db;
    private Integer port;
    private String host;
    private String username;
    private String password;
}
