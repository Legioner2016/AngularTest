package com.test.angular.rest.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("users")
public class UserModel {
	@Id @Column("id_user")
	Integer	id;
	String	login;
	String	password;
	String	lastname;
	String	firstname;
	@Transient
	String 	oldPassword;
	
}
