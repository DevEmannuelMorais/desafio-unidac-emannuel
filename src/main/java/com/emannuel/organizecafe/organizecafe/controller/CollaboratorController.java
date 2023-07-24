package com.emannuel.organizecafe.organizecafe.controller;

import com.emannuel.organizecafe.organizecafe.model.Collaborator;
import com.emannuel.organizecafe.organizecafe.model.dto.CollaboratorDTO;
import com.emannuel.organizecafe.organizecafe.model.dto.CollaboratorUpdateDTO;
import com.emannuel.organizecafe.organizecafe.service.serviceint.CollaboratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/Collaborator")
public class CollaboratorController {

    private final CollaboratorService collaboratorService;

    public CollaboratorController(CollaboratorService collaboratorService) {
        this.collaboratorService = collaboratorService;
    }

    @PostMapping("/create")
    ResponseEntity<List<Collaborator>> create(@RequestBody @Validated CollaboratorDTO form) {
        return ResponseEntity.ok().body(collaboratorService.create(form));
    }

    @GetMapping("/list")
    ResponseEntity<?> list() {
        return ResponseEntity.ok(collaboratorService.getAll());
    }

    @PutMapping("/update/{id}")
    ResponseEntity<?> update(@PathVariable Long id,@RequestBody @Validated CollaboratorUpdateDTO form) {
        return ResponseEntity.ok(collaboratorService.update(id, form));
    }
    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> delete(@PathVariable @Validated Long id) {
        return ResponseEntity.ok(collaboratorService.delete(id));
    }
    @GetMapping("/list/{id}")
    ResponseEntity<?> listById(@PathVariable Long id) {
        return ResponseEntity.ok(collaboratorService.getById(id));
    }
}
