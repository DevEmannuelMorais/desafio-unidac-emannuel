package com.emannuel.organizecafe.organizecafe.controller;

import com.emannuel.organizecafe.organizecafe.model.dto.CoffeeDTO;
import com.emannuel.organizecafe.organizecafe.model.dto.CoffeeUpdateDTO;
import com.emannuel.organizecafe.organizecafe.service.serviceint.CoffeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/coffee")
public class CoffeeController {

    private final CoffeeService coffeeService;
    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;

    }
    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody @Validated CoffeeDTO form) {

        return ResponseEntity.ok().body(coffeeService.create(form));
    }
    @PutMapping("/update/{id}")
    ResponseEntity<?> update(@RequestBody CoffeeUpdateDTO form, @PathVariable Long id) {
        return ResponseEntity.ok(coffeeService.update(form, id));
    }
    @GetMapping("")
    ResponseEntity<?> list() {
        return ResponseEntity.ok(coffeeService.list());
    }
    @GetMapping("/{id}")
    ResponseEntity<?> listById(@PathVariable Long id) {
        return ResponseEntity.ok(coffeeService.getById(id));
    }
    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.ok(coffeeService.delete(id));
    }

    @GetMapping("/realized/{realized}")
    ResponseEntity<?> findByRealized(@PathVariable Boolean realized) {
        return ResponseEntity.ok(coffeeService.findByRealized(realized));

    }
}
