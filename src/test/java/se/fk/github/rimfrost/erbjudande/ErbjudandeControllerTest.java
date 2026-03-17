package se.fk.github.rimfrost.erbjudande;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.UUID;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.GetErbjudandeResponse;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Erbjudande;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class ErbjudandeControllerTest
{
   private static final ObjectMapper mapper = new ObjectMapper();

   @Test
   void testErbjudandeController() throws JsonProcessingException
   {
      var expectedErbjudande = new Erbjudande();
      expectedErbjudande.setId(UUID.fromString("a60a67d6-cfb6-41ad-9718-49e2f9e6b9ba"));
      expectedErbjudande.setNamn("Ansöka om tillfällig vård av husdjur");
      expectedErbjudande.setVersion("1.0");
      expectedErbjudande.setProduktId(UUID.fromString("f2ecbb24-b492-4eab-84b8-e11f751a854c"));

      var expectedResponse = new GetErbjudandeResponse();
      expectedResponse.setErbjudande(expectedErbjudande);

      String actualResponse = given()
            .when().get("/erbjudande/a60a67d6-cfb6-41ad-9718-49e2f9e6b9ba")
            .then()
            .statusCode(200)
            .extract()
            .body()
            .asString();

      var response = mapper.readValue(actualResponse, GetErbjudandeResponse.class);
      assertEquals(expectedResponse, response);
   }

   @Test
   void testErbjudandeWithDifferentId() throws JsonProcessingException
   {
      var expectedErbjudande = new Erbjudande();
      expectedErbjudande.setId(UUID.fromString("235520e4-8715-43ad-b902-fa684cf63a18"));
      expectedErbjudande.setNamn("Ansöka om tillfällig vård av husdjur");
      expectedErbjudande.setVersion("1.0");
      expectedErbjudande.setProduktId(UUID.fromString("f2ecbb24-b492-4eab-84b8-e11f751a854c"));

      var expectedResponse = new GetErbjudandeResponse();
      expectedResponse.setErbjudande(expectedErbjudande);

      String actualResponse = given()
            .when().get("/erbjudande/235520e4-8715-43ad-b902-fa684cf63a18")
            .then()
            .statusCode(200)
            .extract()
            .body()
            .asString();

      var response = mapper.readValue(actualResponse, GetErbjudandeResponse.class);
      assertEquals(expectedResponse, response);
   }
}
