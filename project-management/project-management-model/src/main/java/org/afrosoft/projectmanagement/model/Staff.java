package org.afrosoft.projectmanagement.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="staff")
public class Staff implements Serializable {

  private static final long serialVersionUID = 8416989044621879608L;
  
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
    int prime = 37;
    int result = 17;
    result = prime * result + (staffId != null ? staffId.hashCode() : 0);
    result = prime * result + (firstName != null ? firstName.hashCode() : 0);
    result = prime * result + (lastName != null ? lastName.hashCode() : 0);
    result = prime * result + (role != null ? role.hashCode() : 0);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Staff)) {
      return false;
    }
    
    if (obj == this) {
      return true;
    }
    
    Staff other = (Staff)obj;
    
    if (staffId == null && other.staffId != null) {
      return false;
    } else if (staffId != null && !staffId.equals(other.staffId)) {
      return false;
    }
    
    if (firstName == null && other.firstName != null) {
      return false;
    } else if (firstName != null && !firstName.equals(other.firstName)) {
      return false;
    }
    
    if (lastName == null && other.lastName != null) {
      return false;
    } else if (lastName != null && !lastName.equals(other.lastName)) {
      return false;
    }
    
    if (role == null && other.role != null) {
      return false;
    } else if (role != null && !role.equals(other.role)) {
      return false;
    }
    
    return true;
  }

  @Override
  public String toString() {
    return super.toString();
  }
  
}
