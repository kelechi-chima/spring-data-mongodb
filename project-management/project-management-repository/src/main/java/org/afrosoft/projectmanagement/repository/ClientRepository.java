package org.afrosoft.projectmanagement.repository;

import org.afrosoft.projectmanagement.model.Client;

public interface ClientRepository {

    public void createClient(Client newClient) throws RepositoryException;
    
    public Client findClientByClientName(String clientName) throws RepositoryException;
    
    public Client findClientByClientNameAndMainContact(String clientName, String mainContact) throws RepositoryException;
    
    public void removeClient(String clientName) throws RepositoryException;
    
}
