package okhttp;

import dto.Contactdto;
import dto.contactResponse;
import helpers.Helper;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class UpdateContactTest implements Helper {
    String id;
    Contactdto contactdto;
    String endpoint = "/v1/contacts";

    public UpdateContactTest() throws IOException {
    }

    @BeforeMethod
    public void BEFOREupdate() throws IOException {
        contactdto = Contactdto.builder()
                .name("kiril")
                .lastName("petrov")
                .email("qa37_" + i + "@mail.com")
                .phone("123425678" + i)
                .address("Rehovot")
                .description("Students")
                .build();


        RequestBody requestBody = RequestBody.create(gson.toJson(contactdto), JSON);
        Request request = new Request.Builder().url(baseUrl + endpoint)
                .addHeader("Authorization", token)
                .post(requestBody).build();
        Response response = client.newCall(request).execute();
        contactResponse contactresponse = gson.fromJson(response.body().string(), contactResponse.class);
        String message = contactresponse.getMessage();
        id = message.substring(message.lastIndexOf(" ") + 1);
    }

    @Test
    public void updateContactpositive() throws IOException {
        contactdto.setId(id);
        contactdto.setPhone("12313332312");


        RequestBody requestBody = RequestBody.create(gson.toJson(contactdto), JSON);
        Request request = new Request.Builder()
                .url(baseUrl + endpoint).addHeader("Authorization", token)
                .put(requestBody).build();
        Response response = client.newCall(request).execute();
        contactResponse contactresponse = gson.fromJson(response.body().string(), contactResponse.class);
Assert.assertTrue(response.isSuccessful());
        System.out.println(response.code());
        System.out.println(contactresponse.getMessage());


    }

}

