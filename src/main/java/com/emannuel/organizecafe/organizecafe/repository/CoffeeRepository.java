package com.emannuel.organizecafe.organizecafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.emannuel.organizecafe.organizecafe.model.Coffee;

import java.util.List;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
    List<Coffee> findByRealized(Boolean realized);

//    @Query("from coffee c where c.realized = :realizado")
//    List<Coffee> buscarPorRealizacao(Boolean realizado);


    
}
