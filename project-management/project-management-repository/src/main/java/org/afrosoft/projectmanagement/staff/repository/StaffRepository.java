package org.afrosoft.projectmanagement.staff.repository;

import org.afrosoft.projectmanagement.model.Staff;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StaffRepository extends MongoRepository<Staff, String> {

}
