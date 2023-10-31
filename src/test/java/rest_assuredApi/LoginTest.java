package rest_assuredApi;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import dto.AuthRequestdto;
import dto.AuthResponse;
import helpers.Helper;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class LoginTest implements Helper {
    String endpoint="/v1/user/login/usernamepassword";


    @Test
            public void Login_positive() {
        AuthRequestdto requestdto = AuthRequestdto.builder().username("michat@def.com")
                .password("$Romanovski123454").build();

        AuthResponse response=given().body(requestdto).contentType(ContentType.JSON)
                .when()
                .post(baseUrl+endpoint)
                .then().assertThat()
                .statusCode(200)
                .extract().as(AuthResponse.class);


        System.out.println(response.getToken());

    }

@Test
            public void Login_negative() {
        AuthRequestdto requestdto = AuthRequestdto.builder().username("michat@def.")
                .password("$Romanovski123454").build();

        AuthResponse response=given().body(requestdto).contentType(ContentType.JSON)
                .when()
                .post(baseUrl+endpoint)
                .then().assertThat()
                .statusCode(200)
                .extract().as(AuthResponse.class);




    }
}
