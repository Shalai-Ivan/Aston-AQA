package org.shalai.ivan;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostmanTest {
    @BeforeAll
    public static void setup() {
        RestAssured.requestSpecification = Specification.request();
        RestAssured.responseSpecification = Specification.response();
    }

    @Test
    @DisplayName("GET")
    public void getTest() {
        given()
                .when().get("/get")
                .then()
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.content-type", equalTo("application/json"))
                .body("headers.accept", equalTo("application/json, " +
                        "application/javascript, text/javascript, text/json"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("url", equalTo("https://postman-echo.com/get"));
    }

    @Test
    @DisplayName("POST")
    public void postTest() {
        given()
                .when().post("/post")
                .then()
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.content-type", equalTo("application/json"))
                .body("headers.accept", equalTo("application/json, " +
                        "application/javascript, text/javascript, text/json"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    @DisplayName("PUT")
    public void putTest() {
        given()
                .when().put("/put")
                .then()
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.content-type", equalTo("application/json"))
                .body("headers.accept", equalTo("application/json, " +
                        "application/javascript, text/javascript, text/json"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("url", equalTo("https://postman-echo.com/put"));
    }

    @Test
    @DisplayName("PATCH")
    public void patchTest() {
        given()
                .when().patch("/patch")
                .then()
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.content-type", equalTo("application/json"))
                .body("headers.accept", equalTo("application/json, " +
                        "application/javascript, text/javascript, text/json"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("url", equalTo("https://postman-echo.com/patch"));
    }

    @Test
    @DisplayName("DELETE")
    public void deleteTest() {
        given()
                .when().delete("/delete")
                .then()
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.content-type", equalTo("application/json"))
                .body("headers.accept", equalTo("application/json, " +
                        "application/javascript, text/javascript, text/json"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("url", equalTo("https://postman-echo.com/delete"));
    }
}