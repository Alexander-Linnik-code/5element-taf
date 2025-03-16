package by.itacademy.linnik.api;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TestApi5Element {
    @Test
    @Description("GET site 5Element")
    public void testGet5Element() {
        String URL = "https://5element.by/";
        given()
                .when()
                .get(URL)
                .then()
                .log().all()
                .statusCode(200);
    }
}
