package rest_assuredApi;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import dto.ContactList;
import dto.Contactdto;
import helpers.Helper;
import okhttp3.MediaType;
import okhttp3.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class GetContactsTest implements Helper {



    String endpoint="/v1/contacts";
ContactList contactList;
    @BeforeMethod
    public void precondition() {
        RestAssured.baseURI = "https://contactapp-telran-backend.herokuapp.com";
    }

    @Test
            public void testGetContacts() {


    ContactList list=given()
            .header("Authorization", token)
            .contentType(ContentType.JSON)
            .when()
            .get(endpoint)
            .then().
            assertThat().statusCode(200).extract().as(ContactList.class);
        for(Contactdto contactdto:list.getContacts()) {
            System.out.println(contactdto.getId());
            System.out.println(contactdto.getEmail());
        }

    }
}
