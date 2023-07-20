package com.emannuel.organizecafe.organizecafe.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.emannuel.organizecafe.organizecafe.model.Collaborator;
import com.emannuel.organizecafe.organizecafe.model.dto.CollaboratorDTO;
import com.emannuel.organizecafe.organizecafe.repository.CollaboratorRepository;
import com.emannuel.organizecafe.organizecafe.service.serviceint.CollaboratorService;

@Service
public class CollaboratorServiceImpl implements CollaboratorService{

    private final CollaboratorRepository collaboratorRepository;

    public CollaboratorServiceImpl(CollaboratorRepository collaboratorRepository) {
        this.collaboratorRepository = collaboratorRepository;
    }

    @Override
    public List<Collaborator> create(CollaboratorDTO form) {
        Collaborator collaborator = new Collaborator(form.cpf(), form.name());
        return Collections.singletonList(collaboratorRepository.save(collaborator));
        
    }

    @Override
    public List<Collaborator> getAll() {
        Sort sort = Sort.by("name").ascending();
        return collaboratorRepository.findAll(sort);
    }

    @Override
    public List<Collaborator> getById(Long id) {
        return Collections.singletonList(collaboratorRepository.findById(id).get());
    }

    @Override
    public List<Collaborator> update(Long id, CollaboratorDTO form) {
        Collaborator com = collaboratorRepository.findById(id).get();
        com.setCpf(form.cpf());
        com.setName(form.name());
        collaboratorRepository.save(com);

        return getAll();
    }

    @Override
    public List<Collaborator> delete(Long id) {
        collaboratorRepository.deleteById(id);
       return getAll();
    }


    
}
