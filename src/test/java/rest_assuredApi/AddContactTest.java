package rest_assuredApi;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import dto.Contactdto;
import dto.contactResponse;
import helpers.Helper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class AddContactTest implements Helper {
    String endpoint = "/v1/contacts";


    @BeforeMethod
    public void precondition() {
        RestAssured.baseURI = "https://contactapp-telran-backend.herokuapp.com";
    }
@Test
    public void AddContactTest(){

    Contactdto contactDTO = Contactdto.builder()
            .name("kiril")
            .lastName("petrov")
            .email("qa37_" + i + "@mail.com")
            .phone("123425678" + i)
            .address("Rehovot")
            .description("Students")
            .build();



   contactResponse response= given()
            .header("Authorization", token)
            .body(contactDTO)
            .contentType(ContentType.JSON)
            .when()
            .post(endpoint)
            .then().
            assertThat().statusCode(200).extract().as(contactResponse.class);
    System.out.println(response.getMessage());

}





}






