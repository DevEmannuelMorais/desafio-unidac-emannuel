package com.emannuel.organizecafe.organizecafe.controller;

import com.emannuel.organizecafe.organizecafe.model.Collaborator;
import com.emannuel.organizecafe.organizecafe.model.dto.CollaboratorUpdateDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CollaboratorControllerTest {
    @Autowired
    private WebTestClient webTestClient;

//    @Autowired
//    private MockMvc mockMvc;

    @Test
    void testCreateCollaboratorSucess() {
        var collab = new Collaborator("69144122004", "Fulano de tal");

        webTestClient
                .post()
                .uri("/Collaborator/create")
                .bodyValue(collab)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$").isArray()
                .jsonPath("$.length()").isEqualTo(1)
                .jsonPath("$[0].cpf").isEqualTo(collab.getCpf())
                .jsonPath("$[0].name").isEqualTo(collab.getName());


    }
    @Test
    void testCreateCollaboratorFailure() {
        var collab = new Collaborator("691441220", "");

        webTestClient
        .post()
                .uri("/Collaborator/create")
                .bodyValue(collab)
                .exchange()
                .expectStatus().isBadRequest();

    }


    @Test
    void testListCollaboratorSucess() {
        var collab = new Collaborator("69144122004", "Fulano de tal");
        webTestClient
                .get().uri("Collaborator/list")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(Collaborator.class)
                .hasSize(0);



        webTestClient
                .post()
                .uri("/Collaborator/create")
                .bodyValue(collab)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON);


        Mono<Long> userIdMono = webTestClient.get().uri("Collaborator/list")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .returnResult(Collaborator.class)
                .getResponseBody()
                .next()
                .map(Collaborator::getId);

        assertThat(userIdMono.block()).isNotNull();

//        webTestClient.get().uri("Collaborator/list/{id}", userIdMono.block())
//                .exchange()
//                .expectStatus().isOk()
//                .expectHeader().contentType(MediaType.APPLICATION_JSON)
//                .expectBodyList(Collaborator.class)
//                .consumeWith(respose -> {
//                    List<Collaborator> retrievedCollaborator = respose.getResponseBody();
//                    assertThat(retrievedCollaborator).isNotNull();
//                    assertThat(retrievedCollaborator.get(0).getName()).isEqualTo(collab.getName());
//                    assertThat(retrievedCollaborator.get(0).getCpf()).isEqualTo(collab.getCpf());
//                });




    }


    @Test
    void testUpdateCollaboratorSucess() {
        var collab = new Collaborator("69144122004", "Fulano de tal");
        Long collabId = 1L;
        collab.setId(collabId);
        webTestClient
                .post()
                .uri("/Collaborator/create")
                .bodyValue(collab)
                .exchange();

        var collabup = new CollaboratorUpdateDTO("93825792064", "Loipu");

        webTestClient.put().uri("/Collaborator/update/{id}",collabId)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(collabup)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(Collaborator.class)
                .consumeWith(respose -> {
                    List<Collaborator> collaborators = respose.getResponseBody();
                    assertThat(collaborators).isNotNull();
                    assertThat(collaborators.get(0).getId()).isEqualTo(collab.getId());
                    assertThat(collaborators.get(0).getCpf()).isEqualTo(collabup.cpf());
                    assertThat(collaborators.get(0).getName()).isEqualTo(collabup.name());
                });


    }
    @Test
    void testUpdateCollaboratorFailure() {
        var collab = new Collaborator("69144122004", "Fulano de tal");
        Long collabId = 1L;
        collab.setId(collabId);
        webTestClient
                .post()
                .uri("/Collaborator/create")
                .bodyValue(collab)
                .exchange();

        var collabup = new CollaboratorUpdateDTO("323232", "");

        webTestClient.put().uri("/Collaborator/update/{id}",collabId)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(collabup)
                .exchange()
                .expectStatus().isBadRequest();

    }



}
