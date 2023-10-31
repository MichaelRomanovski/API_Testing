package rest_assuredApi;

import com.jayway.restassured.http.ContentType;
import helpers.Helper;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class DeleteAllContacts implements Helper {
    String endpoint="/v1/contacts/clear";
 @Test
    public void testDeleteAllContacts(){

     given().header("Authorization",token).contentType(ContentType.JSON)
             .delete(baseUrl+endpoint).then().assertThat().statusCode(200);



 }







}
