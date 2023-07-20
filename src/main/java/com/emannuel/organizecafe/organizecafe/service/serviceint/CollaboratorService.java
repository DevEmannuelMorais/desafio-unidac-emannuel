package com.emannuel.organizecafe.organizecafe.service.serviceint;


import com.emannuel.organizecafe.organizecafe.model.Collaborator;
import com.emannuel.organizecafe.organizecafe.model.dto.CollaboratorDTO;

import java.util.List;

public interface CollaboratorService {
    List<Collaborator> create(CollaboratorDTO form);
    List<Collaborator> getAll();

    List<Collaborator> getById(Long id);

    List<Collaborator> update(Long id,CollaboratorDTO form);

    List<Collaborator> delete(Long cpf);
}
