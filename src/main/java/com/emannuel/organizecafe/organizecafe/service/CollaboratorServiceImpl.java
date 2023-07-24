package com.emannuel.organizecafe.organizecafe.service;


import java.util.Collections;
import java.util.List;


import com.emannuel.organizecafe.organizecafe.exception.BadRequestException;
import com.emannuel.organizecafe.organizecafe.model.dto.CollaboratorUpdateDTO;
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
    public List<Collaborator> update(Long id, CollaboratorUpdateDTO form) {
        Collaborator com = collaboratorRepository.findById(id).get();

        collaboratorRepository.findById(id).ifPresentOrElse((collaborator) -> {
            com.setCpf(form.cpf());
            com.setName(form.name());
        }, () -> {
            throw new BadRequestException("Collaborator %d não existe!".formatted(id));
        });

        return Collections.singletonList(collaboratorRepository.save(com));
    }

    @Override
    public List<Collaborator> delete(Long id) {
        collaboratorRepository.findById(id).ifPresentOrElse((collaborator) -> collaboratorRepository.deleteById(collaborator.getId()),
                () -> {
            throw new BadRequestException("Collaborator de id %d não exite!".formatted(id));
                });
       return getAll();
    }


    
}
