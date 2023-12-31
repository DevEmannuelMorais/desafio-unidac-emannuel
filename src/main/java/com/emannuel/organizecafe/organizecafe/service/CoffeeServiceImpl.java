package com.emannuel.organizecafe.organizecafe.service;

import com.emannuel.organizecafe.organizecafe.exception.BadRequestException;
import com.emannuel.organizecafe.organizecafe.model.Coffee;
import com.emannuel.organizecafe.organizecafe.model.dto.CoffeeDTO;
import com.emannuel.organizecafe.organizecafe.model.dto.CoffeeUpdateDTO;
import com.emannuel.organizecafe.organizecafe.repository.CoffeeRepository;
import com.emannuel.organizecafe.organizecafe.repository.CollaboratorRepository;
import com.emannuel.organizecafe.organizecafe.service.serviceint.CoffeeService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class CoffeeServiceImpl implements CoffeeService {

    private final CollaboratorRepository collaboratorRepository;
    private final CoffeeRepository coffeeRepository;

    public CoffeeServiceImpl(CollaboratorRepository collaboratorRepository, CoffeeRepository coffeeRepository) {
        this.collaboratorRepository = collaboratorRepository;
        this.coffeeRepository = coffeeRepository;
    }

    @Override
    public List<Coffee> create(CoffeeDTO form) {
        Coffee coffee = new Coffee();
        coffee.setCollaborator(collaboratorRepository.getReferenceById(form.collaborator_id()));
        coffee.setCoffeeItem(form.coffeeItem());
        coffee.setCoffeeDate(form.coffeeDate());
        coffee.setRealized(form.realized());
        coffeeRepository.save(coffee);

        return list();
    }
    @Override
    public List<Coffee> list(){
        Sort sort = Sort.by("id").descending()
                .and(
                Sort.by("collaborator_id").ascending()
        );
        return coffeeRepository.findAll(sort);
    }

    @Override
    public List<Coffee> getById(Long id) {
        return Collections.singletonList(coffeeRepository.findById(id).get());
    }
    public Coffee getbyRealized(Boolean boo) {
        return (Coffee) coffeeRepository.findByRealized(boo);
    }

    @Override
    public List<Coffee> update(CoffeeUpdateDTO form, Long id) {
        Coffee coffee = coffeeRepository.findById(id).get();
        coffeeRepository.findById(id).ifPresentOrElse((existingCoffee) -> {
            coffee.setCoffeeDate(form.coffeeDate());
            coffee.setCoffeeItem(form.coffeeItem());
            coffee.setRealized(form.realized());
            coffeeRepository.save(coffee);
        }, () -> {
            throw new BadRequestException("Coffe %d não exite! ".formatted(id));
        });
        return list();
    }

    @Override
    public List<Coffee> delete(Long id) {
        coffeeRepository.findById(id).ifPresentOrElse((existingCoffee) -> coffeeRepository.deleteById(existingCoffee.getId()), () -> {
            throw new BadRequestException("Coffe %d não exite! ".formatted(id));
        });

        return list();
    }

    public List<Coffee> findByRealized(Boolean read) {
        return coffeeRepository.findByRealized(read);
    }


}
