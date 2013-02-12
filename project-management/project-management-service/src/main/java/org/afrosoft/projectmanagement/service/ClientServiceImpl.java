package org.afrosoft.projectmanagement.service;

import java.util.List;

import org.afrosoft.projectmanagement.client.repository.ClientRepository;
import org.afrosoft.projectmanagement.model.Client;
import org.afrosoft.projectmanagement.repository.RepositoryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientServiceImpl implements ClientService {

  private static final Logger LOG = LoggerFactory.getLogger(ClientServiceImpl.class);
  
  private ClientRepository clientRepository;
  
  public ClientServiceImpl(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  @Override
  public void addNewClient(Client newClient) throws ServiceException {
    LOG.info("new client added: {}", newClient);
    try {
      clientRepository.createClient(newClient);
    } catch (RepositoryException ex) {
      LOG.error("The repository threw an exception while creating the client.", ex);
      throw new ServiceException("Could not create the client");
    }
  }

  @Override
  public List<Client> findAllClients() throws ServiceException {
    try {
      return clientRepository.findAllClients();
    } catch (RepositoryException ex) {
      LOG.error("The repository threw an exception while retrieving existing clients.", ex);
      throw new ServiceException("Could not retrieve existing clients");
    }
  }

}
