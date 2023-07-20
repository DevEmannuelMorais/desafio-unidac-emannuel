package com.emannuel.organizecafe.organizecafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emannuel.organizecafe.organizecafe.model.Coffee;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
    
}
