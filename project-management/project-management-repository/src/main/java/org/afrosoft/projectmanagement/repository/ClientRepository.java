package org.afrosoft.projectmanagement.repository;

import java.util.List;

import org.afrosoft.projectmanagement.model.Client;

public interface ClientRepository {

  void createClient(Client newClient) throws RepositoryException;

  Client findClientByClientName(String clientName) throws RepositoryException;

  Client findClientByClientNameAndMainContact(String clientName, String mainContact) throws RepositoryException;

  List<Client> findAllClients() throws RepositoryException;

  void updateClientName(String clientName, String newClientName) throws RepositoryException;

  void updateClientMainContact(String clientName, String newMainContact) throws RepositoryException;

  void updateClient(String clientName, String newClientName, String newMainContact) throws RepositoryException;

  void removeClient(String clientName) throws RepositoryException;

}
