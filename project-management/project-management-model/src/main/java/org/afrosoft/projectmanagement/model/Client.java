package org.afrosoft.projectmanagement.model;

public class Client {

    private String id;
    private String clientName;
    private String mainContact;
    
    public Client(String clientName, String mainContact) {
        this.clientName = clientName;
        this.mainContact = mainContact;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "Client [id=" + id + ", name=" + clientName + ", contact=" + mainContact +"]";
    }
}
