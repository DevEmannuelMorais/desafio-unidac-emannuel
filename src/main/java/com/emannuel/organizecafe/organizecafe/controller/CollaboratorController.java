package com.emannuel.organizecafe.organizecafe.controller;

import com.emannuel.organizecafe.organizecafe.model.Collaborator;
import com.emannuel.organizecafe.organizecafe.model.dto.CollaboratorDTO;
import com.emannuel.organizecafe.organizecafe.service.serviceint.CollaboratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Collaborator")
public class CollaboratorController {

    private final CollaboratorService collaboratorService;

    public CollaboratorController(CollaboratorService collaboratorService) {
        this.collaboratorService = collaboratorService;
    }

    @PostMapping("/create")
    ResponseEntity<List<Collaborator>> create(@RequestBody CollaboratorDTO form) {
        return ResponseEntity.ok().body(collaboratorService.create(form));
    }

    @GetMapping("/list")
    ResponseEntity<List<Collaborator>> list() {
        return ResponseEntity.ok(collaboratorService.getAll());
    }

    @PutMapping("/update/{id}")
    ResponseEntity<?> update(@PathVariable Long id,@RequestBody CollaboratorDTO form) {
        return ResponseEntity.ok(collaboratorService.update(id, form));
    }
}
