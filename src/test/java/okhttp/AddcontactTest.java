package okhttp;

import dto.Contactdto;
import dto.Errordto;
import dto.contactResponse;
import helpers.Helper;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddcontactTest implements Helper {


String endpoint="/v1/contacts";
    @Test


    public void testAddContact() throws IOException {

    Contactdto  contactadd=Contactdto.builder()
                .phone("1213231231"+i)
                .address("petrovka")
                .email("miha1235" + i +"@gmail.com")
                .name("Micha")
                .lastName("Asdsdsd")
                .description("adasdasddas")
                .build();


        RequestBody requestBody=RequestBody.create(gson.toJson(contactadd),JSON);
        Request request= new Request.Builder().url(baseUrl + endpoint )
                .addHeader("Authorization",token)
                .post(requestBody).build();
        Response response=client.newCall(request).execute();
contactResponse contactresponse=gson.fromJson(response.body().string(),contactResponse.class);
        System.out.println(contactresponse.getMessage());
        System.out.println(response.code());







    }







}
