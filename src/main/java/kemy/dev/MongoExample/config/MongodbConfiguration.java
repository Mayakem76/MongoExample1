package kemy.dev.MongoExample.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.Collection;
import java.util.Collections;

@Configuration
public class MongodbConfiguration extends AbstractMongoClientConfiguration {
    // https://www.baeldung.com/spring-data-mongodb-tutorial
    @Override //nome Database
    protected String getDatabaseName() {
        return "user_db";
    }

    @Override //dati di connessione al client
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Override
    public Collection getMappingBasePackages() {
        return Collections.singleton("kemy.dev");//Radice del pacchetto del progetto
    }
}
