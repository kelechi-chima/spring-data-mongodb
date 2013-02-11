package org.afrosoft.projectmanagement.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="clients")
public class Client implements Serializable {

  private static final long serialVersionUID = -2466818414295330468L;
  
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
  public int hashCode() {
    int prime = 37;
    int result = 17;
    result = prime * result + (clientId != null ? clientId.hashCode() : 0);
    result = prime * result + (clientName != null ? clientName.hashCode() : 0);
    result = prime * result + (mainContact != null ? mainContact.hashCode() : 0);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Client)) {
      return false;
    }
    
    if (obj == this) {
      return true;
    }
    
    Client other = (Client)obj;
    
    if (clientId == null && other.clientId != null) {
      return false;
    } else if (clientId != null && !clientId.equals(other.clientId)) {
      return false;
    }
    
    if (clientName == null && other.clientName != null) {
      return false;
    } else if (clientName != null && !clientName.equals(other.clientName)) {
      return false;
    }
    
    if (mainContact == null && other.mainContact != null) {
      return false;
    } else if (mainContact != null && !mainContact.equals(other.mainContact)) {
      return false;
    }
    
    return true;
  }

  @Override
  public String toString() {
    return "Client [client id=" + clientId + ", name=" + clientName + ", contact=" + mainContact +"]";
  }
}
