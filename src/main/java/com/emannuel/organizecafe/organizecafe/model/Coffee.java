package com.emannuel.organizecafe.organizecafe.model;
import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "coffee")
public class Coffee  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "collaborator_id")
    private Collaborator collaborator;


    private String coffeeItem ;
    @Column(name = "scheduled_date")
    private LocalDate coffeeDate;

    private boolean realized;

    public Coffee(Collaborator collaborator, String coffeeItem, LocalDate coffeeDate, boolean realized) {
        this.collaborator = collaborator;
        this.coffeeItem = coffeeItem;
        this.coffeeDate = coffeeDate;
        this.realized = realized;
    }
}