package com.emannuel.organizecafe.organizecafe.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.emannuel.organizecafe.organizecafe.model.dto.CollaboratorDTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "coffee")
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Collaborator collaborator;
    private String coffeeItem;
    @Column(name = "scheduled_date")
    private LocalDate coffeeDate;
    private boolean realized;

    


}