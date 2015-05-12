package com.saurabh.springboot.repository;

import com.saurabh.springboot.domain.UserForm;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<UserForm, String> {

    public UserForm findByFirstName(String firstName);
    public List<UserForm> findByLastName(String lastName);

}