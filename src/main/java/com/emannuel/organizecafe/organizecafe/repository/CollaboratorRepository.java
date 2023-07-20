package com.emannuel.organizecafe.organizecafe.repository;

import com.emannuel.organizecafe.organizecafe.model.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollaboratorRepository  extends JpaRepository<Collaborator, Long> {

}
