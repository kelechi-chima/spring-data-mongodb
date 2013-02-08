package org.afrosoft.projectmanagement.staff.repository;

import org.afrosoft.projectmanagement.model.Staff;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.DbCallback;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mongodb.CommandResult;
import com.mongodb.DB;
import com.mongodb.MongoException;

@Ignore("Come back to this after JSF stuff")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/spring-repository-config.xml")
public class StaffRepositoryTest {

  @Autowired
  private StaffRepository staffRepository;
  
  @Autowired
  private MongoTemplate mongoTemplate;

  @Before
  public void initDB() {
    CommandResult commandResult = mongoTemplate.executeInSession(new DbCallback<CommandResult>() {
      @Override
      public CommandResult doInDB(DB db) throws MongoException, DataAccessException {
        return db.command("db.staff.insert({firstName: 'Kelechi', lastName: 'Chima', role: 'Developer'})");
      }
    });
    
    if (!commandResult.ok()) {
      throw new IllegalStateException("Cannot proceed with the tests as the database could not be initialised. Error: " + commandResult.getErrorMessage());
    }
  }
  
  @After
  public void cleanUpDB() {
    CommandResult commandResult = mongoTemplate.executeInSession(new DbCallback<CommandResult>() {
      @Override
      public CommandResult doInDB(DB db) throws MongoException, DataAccessException {
        return db.command("db.staff.drop()");
      }
    });
    
    if (!commandResult.ok()) {
      String msg = "The database may not be in a consistent state after clean up.";
      msg = commandResult.getErrorMessage() != null ? msg += " Error: " + commandResult.getErrorMessage() : msg; 
      throw new IllegalStateException(msg);
    }
  }
  
  @Test
  public void saveStaff() {
    
  }
  
  @Test
  public void findOneStaff() {
    
  }
  
  @Test
  public void updateOneStaff() {
    
  }
  
  @Test
  public void removeOneStaff() {
    
  }
  
}
