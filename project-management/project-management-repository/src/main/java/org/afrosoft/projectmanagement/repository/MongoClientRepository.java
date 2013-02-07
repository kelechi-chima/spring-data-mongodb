package org.afrosoft.projectmanagement.repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Update.update;

import java.util.List;

import org.afrosoft.projectmanagement.model.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.WriteResult;

@Repository
public class MongoClientRepository implements ClientRepository {

  private static final Logger LOG = LoggerFactory.getLogger(MongoClientRepository.class);
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
      throw new RepositoryException("I cannot create a null client.");
    }

    if (!mongoTemplate.collectionExists(Client.class)) {
      mongoTemplate.createCollection(Client.class);
    }

    mongoTemplate.insert(newClient);
  }

  @Override
  public Client findClientByClientName(String clientName) throws RepositoryException {
    assertFieldNotEmpty(clientName, "I cannot find a client without a name.");

    return mongoTemplate.findOne(query(where(CLIENT_NAME).is(clientName)), Client.class);
  }

  @Override
  public Client findClientByClientNameAndMainContact(String clientName, String mainContact) throws RepositoryException {
    assertFieldNotEmpty(clientName, "I cannot find a client without a name.");

    if (mainContact == null || mainContact.trim().equals("")) {
      throw new RepositoryException("I cannot find a client without a main contact.");
    }

    Query query = query(where(CLIENT_NAME).is(clientName).and(MAIN_CONTACT).is(mainContact));
    return mongoTemplate.findOne(query, Client.class);
  }

  @Override
  public List<Client> findAllClients() throws RepositoryException {
    return mongoTemplate.findAll(Client.class);
  }

  @Override
  public void updateClientName(String clientName, String newClientName) throws RepositoryException {
    assertFieldNotEmpty(clientName, "I cannot find the client to update without a name.");
    assertFieldNotEmpty(newClientName, "A client cannot have an empty name.");
    
    Query query = query(where(CLIENT_NAME).is(clientName));
    Update update = update(CLIENT_NAME, newClientName);
    
    WriteResult writeResult = mongoTemplate.updateFirst(query, update, Client.class);
    String error = writeResult.getError();
    if (error != null && !error.trim().equals("")) {
      throw new RepositoryException("An error occurred while updating the client's name: " + clientName + ", error = " + error);
    }
  }

  @Override
  public void updateClientMainContact(String clientName, String newMainContact) throws RepositoryException {
    assertFieldNotEmpty(clientName, "I cannot find the client to update without a name.");
    assertFieldNotEmpty(newMainContact, "A client cannot have an empty main contact.");
    
    Query query = query(where(CLIENT_NAME).is(clientName));
    Update update = update(MAIN_CONTACT, newMainContact);
    
    WriteResult writeResult = mongoTemplate.updateFirst(query, update, Client.class);
    String error = writeResult.getError();
    if (error != null && !error.trim().equals("")) {
      throw new RepositoryException("An error occurred while updating the client's main contact: " + clientName + ", error = "+ error);
    }
  }

  @Override
  public void updateClient(String clientName, String newClientName, String newMainContact) throws RepositoryException {
    assertFieldNotEmpty(clientName, "I cannot find the client to update without a name.");
    assertFieldNotEmpty(newClientName, "A client cannot have an empty name.");
    assertFieldNotEmpty(newMainContact, "A client cannot have an empty main contact.");
    
    Query query = query(where(CLIENT_NAME).is(clientName));
    Update update = update(CLIENT_NAME, newClientName).set(MAIN_CONTACT, newMainContact);
    
    WriteResult writeResult = mongoTemplate.updateFirst(query, update, Client.class);
    String error = writeResult.getError();
    if (error != null && !error.trim().equals("")) {
      throw new RepositoryException("An error occurred while updating the client's name and main contact: " + clientName + ", error = "+ error);
    }
  }

  @Override
  public void removeClient(String clientName) throws RepositoryException {
    assertFieldNotEmpty(clientName, "I cannot find the client to remove without a name.");

    Client removedClient = mongoTemplate.findAndRemove(query(where(CLIENT_NAME).is(clientName)), Client.class);
    if (removedClient == null) {
      throw new RepositoryException("I could not remove the client with the given name: " + clientName);
    } else {
      LOG.info("I successfully removed client: ", removedClient);
    }
  }
  
  private void assertFieldNotEmpty(final String fieldValue, String msg) throws RepositoryException {
    if (fieldValue == null || fieldValue.trim().equals("")) {
      throw new RepositoryException(msg);
    }
  }
}
