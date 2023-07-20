package com.emannuel.organizecafe.organizecafe.model;

import java.time.LocalDate;

import com.emannuel.organizecafe.organizecafe.model.dto.CollaboratorDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Coffee")
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private CollaboratorDTO collaborator;

    @Column()
    private String coffeeItem;

    private LocalDate coffeeDate = LocalDate.now();

    private boolean realized;
    


}