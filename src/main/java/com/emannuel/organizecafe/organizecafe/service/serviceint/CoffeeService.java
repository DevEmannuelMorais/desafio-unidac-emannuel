package com.emannuel.organizecafe.organizecafe.service.serviceint;

import com.emannuel.organizecafe.organizecafe.model.Coffee;
import com.emannuel.organizecafe.organizecafe.model.dto.CoffeeDTO;
import com.emannuel.organizecafe.organizecafe.model.dto.CoffeeUpdateDTO;

import java.util.List;

public interface CoffeeService {
    List<Coffee> create(CoffeeDTO form);

    List<Coffee> list();

    List<Coffee> getById(Long id);

    List<Coffee> update(CoffeeUpdateDTO form, Long id);

    List<Coffee> delete(Long id);
    List<Coffee> findByRealized(Boolean read);
    
}
