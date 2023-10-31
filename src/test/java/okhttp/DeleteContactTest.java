package okhttp;

import dto.Contactdto;
import dto.Errordto;
import dto.contactResponse;
import helpers.Helper;
import lombok.Getter;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class DeleteContactTest implements Helper {
    String endpoint = "/v1/contacts";
    String id1;
    String id;
@BeforeMethod()
        public void precondition() throws IOException {
    Contactdto contactadd = Contactdto.builder()
            .id("12444")
            .phone("121323123231")
            .address("petrovka")
            .email("website123@mail.ru")
            .name("Micha")
            .lastName("Asdsdsd")
            .description("adasdasddas")
            .build();

    RequestBody requestBody = RequestBody.create(gson.toJson(contactadd), JSON);
    Request request = new Request.Builder().url(baseUrl + endpoint)
            .addHeader("Authorization",token)
            .post(requestBody)
            .build();
    Response response=client.newCall(request).execute();

contactResponse contactResponse =gson.fromJson(response.body().string(),contactResponse.class);
String responseMessage=contactResponse.getMessage();
id=responseMessage.substring(responseMessage.lastIndexOf(" ") + 1);

}

@Test

    public void deletecontactpositive() throws IOException {

    Request request = new Request.Builder().url(baseUrl + endpoint + "/" + id)
            .addHeader("Authorization",token)
            .delete().build();
    Response response=client.newCall(request).execute();
    contactResponse contactResponseDTO = gson.fromJson(response.body().string(), contactResponse.class);

    String message = contactResponseDTO.getMessage();

    System.out.println(message);


}
@Test

    public void deletecontactnegative() throws IOException {

    Request request = new Request.Builder().url(baseUrl + endpoint + "/" + id1)
            .addHeader("Authorization",token)
            .delete().build();
    Response response=client.newCall(request).execute();
Errordto errordto = gson.fromJson(response.body().string(),Errordto.class);
    Object message = errordto.getMessage();

    System.out.println(message);
    System.out.println("Code>>>>>>>>>>>>>" + response.code());


}





}



