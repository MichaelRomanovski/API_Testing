package rest_assuredApi;

import com.jayway.restassured.http.ContentType;
import dto.AuthRequestdto;
import dto.AuthResponse;
import dto.Errordto;
import helpers.Helper;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class RegistrationTest implements Helper {
    String endpoint="/v1/user/registration/usernamepassword";
    @Test
    public void registrationTestApi(){
        AuthRequestdto authRequestdto = AuthRequestdto.builder().username("michmt@def.com").password("$Romanovski123454").build();
        AuthResponse response  =given().contentType(ContentType.JSON).body(authRequestdto).when().post(baseUrl+endpoint)
                .then().assertThat().statusCode(200).extract().as(AuthResponse.class);
        System.out.println(response.getToken());



    }
   @Test
    public void registrationNegativeTestApi() {
       AuthRequestdto authRequestdto = AuthRequestdto.builder().username("michmtdef.com").password("$Romanovski123454").build();
        given().contentType(ContentType.JSON).body(authRequestdto).when().post(baseUrl + endpoint)
               .then().assertThat().statusCode(400);


   }
   @Test
    public void registrationNegativeTestApi2() {

       AuthRequestdto authRequestdto = AuthRequestdto.builder().username("michmt@def.com").password("$Romanovski123454").build();
       Errordto errordto=given().contentType(ContentType.JSON).body(authRequestdto).when().post(baseUrl + endpoint)
               .then().assertThat().statusCode(409).extract().as(Errordto.class);
       System.out.println(errordto.getMessage());

   }




}
