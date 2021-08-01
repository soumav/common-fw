package com.test.astracassandraapp.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Table(value = "student")
@Data
@AllArgsConstructor
public class Student {

  @PrimaryKey
  private int id;

  @Column(value = "name")
  private String name;

  @Column(value = "age")
  private int age;

}