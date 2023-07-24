package com.emannuel.organizecafe.organizecafe.controller;



import com.emannuel.organizecafe.organizecafe.model.Coffee;
import com.emannuel.organizecafe.organizecafe.model.Collaborator;
import com.emannuel.organizecafe.organizecafe.model.dto.CoffeeDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import java.time.format.DateTimeFormatter;

import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CoffeControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    Collaborator collaborator;

    Coffee coffee;


    @BeforeEach
    public void setUp() {
        collaborator = new Collaborator(1L ,"69144122004", "Fulano de tal");
//        coffee = new Coffee(collaborator, "pao", LocalDate.now(), true);
    }

    @Test
    void testCreateCoffeeSucess() {
//        var collab = new Collaborator("69144122004", "Fulano de tal");
//
//
//        webTestClient
//                .post()
//                .uri("/Collaborator/create")
//                .bodyValue(collab)
//                .exchange();
//



//        Long collaboratorId = 1L;

//        Collaborator simulatedCollab = new Collaborator();
//        simulatedCollab.setId(collaboratorId);
//        simulatedCollab.setName("Fulano de tal");
//        simulatedCollab.setCpf("69144122004");
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        CoffeeDTO newCoffee = new CoffeeDTO(LocalDate.now(), "pao", 1L, false);




        webTestClient
                .post()
                .uri("/coffee/create")
                .bodyValue(newCoffee)
                .exchange()
                .expectStatus().isOk();
                //.expectBody();
                //.jsonPath("$").isArray();
//                .jsonPath("$.length()").isEqualTo(1)
//                .jsonPath("$[0].coffeeDate").isEqualTo(cooffe.coffeeDate())
//                .jsonPath("$[0].coffeitem").isEqualTo(cooffe.coffeeItem())
//                .jsonPath("$[0].collaborator_id").isEqualTo(1L)
//                .jsonPath("$[0].realized").isEqualTo(cooffe.realized())
//                .jsonPath("$[0].realized").isBoolean();


    }




}
