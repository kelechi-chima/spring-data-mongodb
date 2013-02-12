<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <title>Manage Clients</title>
  <style type="text/css">
    div#main {
      position: relative;
    }
    div#existing-clients {
      
    }
    div#new-client {
      
    }
    #add-new-client {
      
    }
    .form-field {
      display: block;
    }
    .error-msg {
      
    }
  </style>
</head>
<body>
  <div id="main">
    <div id="existing-clients">
      
    </div>
    <div id="new-client">
      <f:view>
        <h:form id="add-new-client" prependId="false">
          <h:outputText value="#{messages.newClientHeader}" styleClass="sectionHeader"/>
          <div class="form-field">
	          <h:outputLabel for="clientName" value="#{messages.clientNameLabel}"/>
	          <h:inputText id="clientName" 
	            value="#{newClientBean.client.clientName}" 
	            required="true"
	            requiredMessage="#{messages.clientNameRequired}"
	            />
	          <h:message for="clientName" showSummary="true" showDetail="false" styleClass="error-msg"/>
          </div>
          <div class="form-field">
            <h:outputLabel for="mainContact" value="#{messages.clientMainContactLabel}"/>
            <h:inputText id="mainContact" 
              value="#{newClientBean.client.mainContact}"
              required="true"
              requiredMessage="#{messages.clientMainContactRequired}"/>
            <h:message for="mainContact" showSummary="true" showDetail="false" styleClass="error-msg"/>
          </div>
          <div class="form-field">
            <h:commandButton id="submit"
              action="success"
              actionListener="#{clientController.addNewClient}" 
              value="#{messages.addNewClientButton}">
              <f:attribute name="newClient" value="#{newClientBean.client}"/>
            </h:commandButton>
          </div>
        </h:form>
      </f:view>
    </div>
  </div>
</body>
</html>