package org.afrosoft.projectmanagement.repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import org.afrosoft.projectmanagement.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class MongoClientRepository implements ClientRepository {

    private static final String CLIENT_NAME = "clientName";
    private static final String MAIN_CONTACT = "mainContact";

    private MongoTemplate mongoTemplate;

    @Autowired
    public MongoClientRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void createClient(Client newClient) throws RepositoryException {
        if (newClient == null) {
            throw new RepositoryException("The new client to be created cannot be null.");
        }

        if (!mongoTemplate.collectionExists(Client.class)) {
            mongoTemplate.createCollection(Client.class);
        }

        mongoTemplate.insert(newClient);
    }

    @Override
    public Client findClientByClientName(String clientName) throws RepositoryException {
        if (clientName == null || clientName.trim().equals("")) {
            throw new RepositoryException("Cannot find a client without a name.");
        }

        return mongoTemplate.findOne(new Query(where(CLIENT_NAME).is(clientName)), Client.class);
    }

    @Override
    public Client findClientByClientNameAndMainContact(String clientName, String mainContact) throws RepositoryException {
        if (clientName == null || clientName.trim().equals("")) {
            throw new RepositoryException("Cannot find a client without a name.");
        }

        if (mainContact == null || mainContact.trim().equals("")) {
            throw new RepositoryException("Cannot find a client without a main contact.");
        }

        return mongoTemplate.findOne(new Query(where(CLIENT_NAME).is(clientName).and(MAIN_CONTACT).is(mainContact)), Client.class);
    }

    @Override
    public void removeClient(String clientName) throws RepositoryException {
        if (clientName == null || clientName.trim().equals("")) {
            throw new RepositoryException("Cannot remove a client without a name.");
        }

        Client removedClient = mongoTemplate.findAndRemove(new Query(where(CLIENT_NAME).is(clientName)), Client.class);
        if (removedClient == null) {
            throw new RepositoryException("Could not remove the client with the given name: " + clientName);
        }
    }

}
