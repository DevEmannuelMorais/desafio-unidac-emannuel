package com.emannuel.organizecafe.organizecafe.service.serviceint;


import com.emannuel.organizecafe.organizecafe.model.Collaborator;
import com.emannuel.organizecafe.organizecafe.model.dto.CollaboratorDTO;
import com.emannuel.organizecafe.organizecafe.model.dto.CollaboratorUpdateDTO;

import java.util.List;

public interface CollaboratorService {
    List<Collaborator> create(CollaboratorDTO form);
    List<Collaborator> getAll();

    List<Collaborator> getById(Long id);

    List<Collaborator> update(Long id, CollaboratorUpdateDTO form);

    List<Collaborator> delete(Long cpf);
}
