package com.sharad.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sharad.demo.vo.StudentEntity;

@Repository
public interface StudentDao extends CrudRepository<StudentEntity, Long> {

}
