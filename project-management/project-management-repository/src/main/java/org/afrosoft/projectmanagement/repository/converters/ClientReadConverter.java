package org.afrosoft.projectmanagement.repository.converters;

import org.afrosoft.projectmanagement.model.Client;
import org.springframework.core.convert.converter.Converter;

import com.mongodb.DBObject;

public class ClientReadConverter implements Converter<DBObject, Client> {

  @Override
  public Client convert(DBObject source) {
    Client client = new Client(source.get("_id").toString());
    client.setClientName((String)source.get("clientName"));
    client.setMainContact((String)source.get("mainContact"));
    return client;
  }

}
