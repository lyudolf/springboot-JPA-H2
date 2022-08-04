package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Customer {
	@Id
	//자동생성
	@GeneratedValue(strategy=GenerationType.IDENTITY)//sql문 직접 수행할때 자동으로 id생성하기 위함
	private int id;
	private String name;
	@Column(length=1024)
	private String address;
	private String primaryContact;
	

}
