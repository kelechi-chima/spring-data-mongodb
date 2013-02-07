package org.afrosoft.projectmanagement.repository.converters;

import org.afrosoft.projectmanagement.model.Client;
import org.springframework.core.convert.converter.Converter;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

public class ClientWriteConverter implements Converter<Client, DBObject> {

  @Override
  public DBObject convert(Client source) {
    return new BasicDBObjectBuilder().
        add("_id", source.getClientId()).
        add("clientName", source.getClientName()).
        add("mainContact", source.getMainContact()).
        get();
  }

}
