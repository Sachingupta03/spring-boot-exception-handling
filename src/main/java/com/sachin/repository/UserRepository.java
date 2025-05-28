// File: src/main/java/com/sachin/repository/UserRepository.java
package com.sachin.repository;

import com.sachin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User getByName(String name); //  Matches the actual field in the User class

    User findByEmail(String email);

}
