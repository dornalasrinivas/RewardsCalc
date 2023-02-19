package com.org.sales.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.sales.model.Customers;

public interface CustomersRepository extends JpaRepository<Customers, Long>{

}
