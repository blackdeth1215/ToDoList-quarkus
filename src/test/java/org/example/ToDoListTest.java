package org.example;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;

@QuarkusTest
public class ToDoListTest {
    @Test
    public void List() {
        given().when().get("/element").then().statusCode(200).body("$.size()",is(3),"title",containsInAnyOrder("Test1","Test2","Test3"),
                "description",containsInAnyOrder("desc test1","desc test2","desc test3"));
    }
    @Test
    public void Add(){
        given()
                .body("{\"title\": \"test4\", \"description\": \"desc test4\"}")
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                .post("/element")
                .then()
                .statusCode(200)
                .body("$.size()", is(4),
                        "title", containsInAnyOrder("test1", "test2", "test3", "test4"),
                        "description", containsInAnyOrder("desc test1","desc test2","desc test3","desc test4"));
        given()
                .body("{\"title\": \"test4\", \"description\": \"desc test4\"}")
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                .delete("/element")
                .then()
                .statusCode(200)
                .body("$.size()", is(3),
                        "title", containsInAnyOrder("test1", "test2", "test3"),
                        "description", containsInAnyOrder("desc test1","desc test2","desc test3"));
    }
}
