package com.sp.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sp.ecommerce.entity.Customer;

public interface CustomerRepository  extends JpaRepository<Customer, Long>{

}
