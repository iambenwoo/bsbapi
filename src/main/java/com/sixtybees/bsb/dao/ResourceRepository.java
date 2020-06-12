package com.sixtybees.bsb.dao;

import org.springframework.data.repository.CrudRepository;
import com.sixtybees.bsb.entity.Resource;

public interface ResourceRepository extends CrudRepository<Resource, Integer> {

}
