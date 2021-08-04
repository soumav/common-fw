package com.test.astracassandraapp.repo;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.test.astracassandraapp.model.Student;

@Repository
public interface TestRepository extends CassandraRepository<Student, Integer> {

}