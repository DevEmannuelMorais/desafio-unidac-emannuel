package com.emannuel.organizecafe.organizecafe.repository;

import com.emannuel.organizecafe.organizecafe.model.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollaboratorRepository  extends JpaRepository<Collaborator, Long> {
    List<Collaborator> findByCpf(String cpf);


}
