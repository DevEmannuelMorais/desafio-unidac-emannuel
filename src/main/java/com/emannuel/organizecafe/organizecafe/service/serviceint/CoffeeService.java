package com.emannuel.organizecafe.organizecafe.service.serviceint;

import com.emannuel.organizecafe.organizecafe.model.Coffee;
import java.util.List;

public interface CoffeeService {
    List<Coffee> create();

    List<Coffee> getAll();

    List<Coffee> getById();

    List<Coffee> update();

    List<Coffee> delete();
    
}
