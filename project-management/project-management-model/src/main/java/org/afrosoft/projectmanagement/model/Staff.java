package org.afrosoft.projectmanagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="staff")
public class Staff {

  @Id
  private String staffId;
  private String firstName;
  private String lastName;
  private String role;
  
  public Staff(String staffId) {
    this.staffId = staffId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getStaffId() {
    return staffId;
  }

  @Override
  public int hashCode() {
    // TODO override properly
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    // TODO override properly
    return super.equals(obj);
  }

  @Override
  public String toString() {
    return super.toString();
  }
  
}
