package org.afrosoft.projectmanagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="clients")
public class Client {

  @Id
  private String clientId;
  private String clientName;
  private String mainContact;

  public Client(String clientId) {
    this.clientId = clientId;
  }
  
  public Client(String clientName, String mainContact) {
    this.clientName = clientName;
    this.mainContact = mainContact;
  }

  public String getClientId() {
    return clientId;
  }

  public String getClientName() {
    return clientName;
  }

  public void setClientName(String clientName) {
    this.clientName = clientName;
  }

  public String getMainContact() {
    return mainContact;
  }

  public void setMainContact(String mainContact) {
    this.mainContact = mainContact;
  }

  @Override
  public String toString() {
    return "Client [client id=" + clientId + ", name=" + clientName + ", contact=" + mainContact +"]";
  }
}
