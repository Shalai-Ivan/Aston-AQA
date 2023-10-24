package org.shalai.ivan;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

public class Specification {
    private static final String URL = "https://postman-echo.com";

    public static RequestSpecification request() {
        return new RequestSpecBuilder()
                .setBaseUri(URL)
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification response() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }
}
