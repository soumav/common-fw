package com.testfw.astracassandraapp.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Table(value = "student")
@Data
@AllArgsConstructor
//@ApiModel(value = "Student", description = "Student class.")
public class Student {

	@PrimaryKey
	//@ApiModelProperty(value = "id", required = true, dataType = "int", example = "1")
	private int id;

	@Column(value = "name")
	//@ApiModelProperty(value = "name", required = true)
	private String name;

	@Column(value = "age")
	//@ApiModelProperty(value = "age", required = true)
	private int age;

}