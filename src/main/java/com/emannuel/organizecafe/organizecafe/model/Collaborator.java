package com.emannuel.organizecafe.organizecafe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "tb_collaborator")
public class Collaborator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, length = 11, unique = true)
    private String cpf;


    @Column(nullable = false, length = 40)
    private String name;



    @OneToMany(mappedBy = "collaborator",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Coffee> coffee = new ArrayList<>();



    public Collaborator(String cpf, String name) {
        this.cpf = cpf;
        this.name = name;
    }
}
