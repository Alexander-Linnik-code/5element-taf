package by.itacademy.linnik.pagesapi;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Activities {
    private static final String BASE_URL_SEARCH = "https://sort.diginetica.net/search?";

    private static final String ENDPOINT_SEARCH = "&apiKey=08IE0509XQ&strategy=advanced_xname,zero_queries&fullData=true&withCorrection=true&withFacets=true&treeFacets=true&regionId=global&useCategoryPrediction=false&size=20&offset=0&showUnavailable=true&unavailableMultiplier=0.002&preview=false&withSku=false&sort=DEFAULT";

    @Step
    public static Response getDoSearch(String phone) {
        Response response = given()
                .when()
                .get(BASE_URL_SEARCH + phone + ENDPOINT_SEARCH);
        return response;
    }

    @Step
    public static Response postDoLogin(Body body) {
        String URL = "https://5element.by/rest/v2/code/phone";
        Response response =
                given()
                        .body(body)
                .when()
                        .post(URL);
        return response;
    }
}
