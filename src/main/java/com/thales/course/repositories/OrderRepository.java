package com.thales.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thales.course.entities.Order;

//Indica que esta classe é uma Repository
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
