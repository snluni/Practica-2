package es.urjc.code.daw.library.rest;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class TestApiREST {
	@LocalServerPort
	int port;
	@BeforeEach
	public void setUp() {
		RestAssured.port = port;
	}
	
	@Test
	void checkIfAnAddedBookCanBeRetrieve() {
		int id;
		Response response;
		response = given()
			.body("{\"title\" : \"A wolf in the sky\", \"description\" : \"...\"}")
			.contentType(ContentType.JSON).
		when()
			.post("/api/books/");
		id = from(response.getBody().asString()).get("id");
		when().get("/api/books/{id}", id).
		then().statusCode(200).
			body("title", equalTo("A wolf in the sky")).
			body("description", equalTo("...")).
			body("id", equalTo(id));
	}
	
	@Test
	void checkIfADeletedBookCanNotBeRetrieved() {
		int id;
		Response response;
		response = given()
			.body("{\"title\" : \"The mysterious murder\", \"description \" : \"...\"}")
			.contentType(ContentType.JSON).
		when()
			.post("/api/books/");
		id = from(response.getBody().asString()).get("id");
		when()
			.delete("api/books/{id}", id);
		when()
			.get("api/book/{id}", id).
		then().
			statusCode(404);
		
	}
	

}
