package org.afrosoft.projectmanagement.managedbeans;

import java.io.Serializable;

import org.afrosoft.projectmanagement.model.Client;

public class NewClientBean implements Serializable {

  private static final long serialVersionUID = 7204514611935631166L;
  
  private Client client;

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  @Override
  public String toString() {
    return "NewClientBean [client=" + client + "]";
  }
  
}
