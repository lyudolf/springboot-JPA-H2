package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	List<Customer> findByName(String name);
	List<Customer> findByNameLike(String name);
	List<Customer> findByNameLikeOrderByAddressDesc(String name);
	List<Customer> findByNameAndAddress(String name, String address);
	//jpql 사용법
	@Query("from Customer where name = ?1 and primaryContact= ?2")//false인 경우에는 jpql:java persistence query language 표준 sql의 일부를 가져다가 편의기능 제공
	List<Customer> findVipList(String value1, String vaue2);
	//nativesql 사용법
	@Query(value= "select * from Customer where name = ?1 and primary_contact= ?2", nativeQuery=true)//false인 경우에는 jpql:java persistence query language 표준 sql의 일부를 가져다가 편의기능 제공
	List<Customer> findVipList2(String value1, String vaue2);
}
