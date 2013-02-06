package org.afrosoft.projectmanagement.repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import org.afrosoft.projectmanagement.model.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.Mongo;

public class MongoApp {

    private static final Logger LOG = LoggerFactory.getLogger(MongoApp.class);
    
    public static void main(String[] args) throws Exception {
        String clientName = "Flight Centre";
        
        MongoOperations mongoOps = new MongoTemplate(new SimpleMongoDbFactory(new Mongo(), "projectmanagement"));
        
        if (mongoOps.collectionExists(Client.class)) {
            mongoOps.dropCollection(Client.class);
        }
        
        mongoOps.insert(new Client(clientName, "Ms. Janet Clarke"));
        
        Client persistedClient = mongoOps.findOne(new Query(where("clientName").is(clientName)), Client.class);
        LOG.info("Found client: {}", persistedClient);
        
        mongoOps.dropCollection(Client.class);
    }

}
