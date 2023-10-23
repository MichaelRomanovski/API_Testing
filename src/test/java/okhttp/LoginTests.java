package okhttp;

import com.google.gson.Gson;
import dto.AuthRequestdto;
import dto.AuthResponse;
import dto.Errordto;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTests {

    public static final MediaType JSON=MediaType.get("application/json;charset=utf-8");
String baseUrl="https://contactapp-telran-backend.herokuapp.com";
    Gson gson=new Gson();
    OkHttpClient client=new OkHttpClient();
@Test
    public void loginPositive() throws IOException {
    AuthRequestdto requestdto=AuthRequestdto.builder().username
                    ("michat@def.com")
            .password("$Romanovski123454")
            .build();

    RequestBody requestBody=RequestBody.create(gson.toJson(requestdto),JSON);
    Request request=new Request.Builder().url(baseUrl+"/v1/user/login/usernamepassword")
            .post(requestBody)
            .build();
    Response response=client.newCall(request).execute();
    if(response.isSuccessful()){
        String responseJson=response.body().string();
        AuthResponse responsedto=gson.fromJson(responseJson,AuthResponse.class);
        System.out.println(response.code());
        System.out.println(responsedto.getToken());
        System.out.println(response.isSuccessful());

    }
    else {

        Errordto errordto=gson.fromJson(response.body().string(), Errordto.class);

        System.out.println("Response code is>>>>>>>>>" + response.code());
        System.out.println(errordto.getStatus() + "==========" +errordto
                .getMessage() + "=========" +errordto.getError());
       // Assert.assertFalse(response.);


    }

}





}
