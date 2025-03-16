package by.itacademy.linnik.api;

import by.itacademy.linnik.pagesapi.Activities;
import by.itacademy.linnik.pagesapi.Body;
import io.qameta.allure.Description;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
    @Test
    @Description("Negative login form test.")
    public void testPOST5ElementLogin() {
        Body body1 = new Body("3752565825783");
        Response response = Activities.postDoLogin(body1);
        String body = response.getBody().asString();
        int statusCode = response.getStatusCode();
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(statusCode).isEqualTo(400);
        softAssertions.assertThat(body).isEqualTo("Введён некорректный номер");
        softAssertions.assertAll();
    }

    @Test
    @Description("Positive login form test.")
    public void testPOST5ElementLogin2() {
        Body body1 = new Body("375259987926");
        Response response = Activities.postDoLogin(body1);
        String body = response.getBody().asString();
        int statusCode = response.getStatusCode();
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(statusCode).isEqualTo(200);
        softAssertions.assertThat(body).isEqualTo("OK");
        softAssertions.assertAll();
    }

    @Test
    @Description("Compare the brand of the requested phone")
    public void testFirstProductBrandIsSamsung() {
        String response = Activities.getDoSearch("st=Samsung")
                .then()
                .extract()
                .asString();
        JsonPath jsonPath = new JsonPath(response);
        String firstProductBrand = jsonPath.getString("products[0].brand");
        assertThat(firstProductBrand, equalTo("SAMSUNG"));
    }
}
