package me.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import me.practice.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>, JpaSpecificationExecutor<Customer> {
	 
}