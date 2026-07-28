package testAutomation.API;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;


public class apiCucumberTest {
    private Response response;
    private String objectId;

    @When("I send a POST request to create an object")
    public void createObject() {
        response = given()
                .contentType("application/json")
                .body("{\"name\":\"Marvin Test Object\",\"data\":{\"year\":2026,\"price\":199}}")
                .when()
                .post("https://api.restful-api.dev/objects")
                .then()
                .extract().response();

        objectId = response.path("id");
    }

    @When("I send a GET request for that object")
    public void readObject() {
        response = given()
                .when()
                .get("https://api.restful-api.dev/objects/" + objectId)
                .then()
                .extract().response();
    }

    @When("I send a PUT request to update the object")
    public void updateObject() {
        response = given()
                .contentType("application/json")
                .body("{\"name\":\"Updated Marvin Object\",\"data\":{\"year\":2027,\"price\":299}}")
                .when()
                .put("https://api.restful-api.dev/objects/" + objectId)
                .then()
                .extract().response();
    }

    @When("I send a DELETE request for that object")
    public void deleteObject() {
        response = given()
                .when()
                .delete("https://api.restful-api.dev/objects/" + objectId)
                .then()
                .extract().response();
    }

    @When("I send a GET request with an invalid object ID")
    public void invalidRead() {
        response = given()
                .when()
                .get("https://api.restful-api.dev/objects/invalid-id-123")
                .then()
                .extract().response();
    }

    @Then("The response status should be {int}")
    public void the_response_status_should_be(Integer expectedStatus) {
        response.then().statusCode(expectedStatus);
    }

    @Then("The response should contain the object ID")
    public void the_response_should_contain_the_object_id() {
        assert objectId != null && !objectId.isEmpty();
    }

    @Then("The response should contain the correct object data")
    public void the_response_should_contain_the_correct_object_data() {
        response.then().body("id", equalTo(objectId));
    }

    @Then("The response should reflect the updated data")
    public void the_response_should_reflect_the_updated_data() {
        response.then().body("name", equalTo("Updated Marvin Object"));
    }
}
