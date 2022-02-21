package com.pocosoft.csvImport.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.opencsv.bean.CsvBindAndJoinByName;
import com.opencsv.bean.CsvBindByName;


@Entity
public class EmployeeDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@CsvBindByName
	private String name;
	@CsvBindByName
	private String email;
	@CsvBindByName
	private String address;
	@CsvBindByName
	private String telephone;
	
	public EmployeeDetails() {
		
	}

	public EmployeeDetails(String name, String email, String address, String telephone) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.telephone = telephone;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
	
	

}
