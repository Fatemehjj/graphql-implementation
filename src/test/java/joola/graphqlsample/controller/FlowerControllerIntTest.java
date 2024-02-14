package joola.graphqlsample.controller;

import joola.graphqlsample.model.Flower;
import joola.graphqlsample.repository.FlowerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.context.annotation.Import;
import org.springframework.graphql.test.tester.GraphQlTester;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Import(FlowerRepository.class)
@GraphQlTest(FlowerController.class)
class FlowerControllerIntTest {
    @Autowired
    GraphQlTester graphQlTester;
    @Test
    void shouldReturnAllFlowers() {
        String testDoc = """
                query {
                   allFlowers {
                      name
                      color
                   }
                }
                """;
        graphQlTester.document(testDoc)
                .execute()
                .path("allFlowers")
                .entityList(Flower.class);
    }

//    @Test
//    void WithValidNameShouldReturnFlowersWithThatName() {
//
//        String testDoc = """
//                    query findByName ($name : String){
//                       findByName(name : $name) {
//                      name
//                      color
//                   }
//                }
//                """;
//        graphQlTester.document(testDoc)
//                .variable("name", "lily")
//
//                .execute()
//                .path("findByName")
//                .entityList(Flower.class);
//    }
}