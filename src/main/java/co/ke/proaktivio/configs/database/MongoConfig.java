package co.ke.proaktivio.configs.database;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import co.ke.proaktivio.configs.properties.MongoProperties;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration{
	
	@Autowired
	private MongoProperties properties;
	
	@Override
	public MongoClient mongoClient() {
        final MongoClientOptions options = new MongoClientOptions.Builder().connectionsPerHost(10).build();
        
        final MongoClient client = new MongoClient(
        		Collections.singletonList(new ServerAddress(properties.getHost(), properties.getPort())), //host, port
        		MongoCredential.createCredential(properties.getUsername(), properties.getDb(), properties.getPassword().toCharArray()), //username, db, password
        		options);
        return client;
	}

	@Override
	protected String getDatabaseName() {
		return properties.getDb();
	}

}
