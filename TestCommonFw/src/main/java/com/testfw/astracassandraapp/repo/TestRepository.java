package com.testfw.astracassandraapp.repo;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.testfw.astracassandraapp.model.Student;

@Repository
public interface TestRepository extends CassandraRepository<Student, Integer> {

}