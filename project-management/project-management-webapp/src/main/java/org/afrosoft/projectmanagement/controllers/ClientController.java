package org.afrosoft.projectmanagement.controllers;

import javax.faces.event.ActionEvent;

import org.afrosoft.projectmanagement.model.Client;
import org.afrosoft.projectmanagement.service.ClientService;

public class ClientController {
  
  private ClientService clientService;

	//private static final Logger LOG = LoggerFactory.getLogger(ClientController.class);
	
	public void addNewClient(ActionEvent event) {
	  Client newClient = (Client)event.getComponent().getAttributes().get("newClient");
		clientService.addNewClient(newClient);
	}

  public ClientService getClientService() {
    return clientService;
  }

  public void setClientService(ClientService clientService) {
    this.clientService = clientService;
  }

	
}
