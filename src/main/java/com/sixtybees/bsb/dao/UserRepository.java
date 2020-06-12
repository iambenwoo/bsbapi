package com.sixtybees.bsb.dao;

import org.springframework.data.repository.CrudRepository;

import com.sixtybees.bsb.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
