package org.afrosoft.projectmanagement.service;

import java.util.List;

import org.afrosoft.projectmanagement.model.Client;

/**
 * Defines operations to manage {@link Client} instances. 
 */
public interface ClientService {

  /**
   * Persist a new Client instance.
   * 
   * @param newClient - the new client to persist
   * @throws ServiceException if there is a problem creating the client
   */
  void addNewClient(Client newClient) throws ServiceException;
  
  /**
   * Retrieves existing Client instances.
   * @return existing Client instances
   * @throws ServiceException if there is a problem retrieving the clients
   */
  List<Client> findAllClients() throws ServiceException;
  
}
