package rest_assuredApi;

import com.jayway.restassured.http.ContentType;
import dto.Contactdto;
import helpers.Helper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class DeleteContact implements Helper {
    String id;
    String endpoint="/v1/contacts";

    Contactdto contactdto;
    @BeforeMethod
    public void beforeDelete() {
        contactdto = Contactdto.builder()
                .id("12444")
                .phone("1290923123231")
                .address("petrovka")
                .email("website123@mail.ru")
                .name("Micha")
                .lastName("Asdsdsd")
                .description("adasdasddas")
                .build();
String message=given().header("Authorization",token).contentType(ContentType.JSON).body(contactdto)
        .when().post(baseUrl+endpoint).then().extract().path("message");

        id = message.substring(message.lastIndexOf(" ") + 1);

    }

@Test
    public void DeleteContact(){



given().header("Authorization",token).contentType(ContentType.JSON).when()
        .delete(baseUrl+endpoint+"/"+id).then().statusCode(200);




}




}
