package rest_assuredApi;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import dto.Contactdto;
import helpers.Helper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class UpdateContact implements Helper {
    String id;
Contactdto contactdto;
    String endpoint = "/v1/contacts";
    @BeforeMethod
    public void beforeUpdateContactApi(){
         contactdto = Contactdto.builder()
                .name("kiril")
                .lastName("petrov")
                .email("qa37_" + i + "@mail.com")
                .phone("123425678" + i)
                .address("Rehovot")
                .description("Students")
                .build();
        String message = given()
                .header("Authorization", token)
                .body(contactdto)
                .contentType(ContentType.JSON)
                .when()
                .post(baseUrl+endpoint)
                .then()
                .extract()
                .path("message");

        id = message.substring(message.lastIndexOf(" ") + 1);

    }
@Test
public void updateContact() {

contactdto.setId(id);
contactdto.setPhone("12312312312");
    given().header("Authorization",token)
            .body(contactdto).contentType(ContentType.JSON)
            .when().put(baseUrl+endpoint).then()
            .assertThat().statusCode(200);

}
}
