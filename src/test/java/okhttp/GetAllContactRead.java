package okhttp;

import dto.ContactList;
import dto.Contactdto;
import helpers.Helper;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetAllContactRead implements Helper {

    String endpoint = "/v1/contacts";
    @Test


    public void testGetAllContactRead() throws IOException {

        Request request=new Request.Builder().url(baseUrl + endpoint)
                .addHeader("Authorization", token).
        build();

        Response response=client.newCall(request).execute();

      ContactList  contacts = gson.fromJson(response.body().string(), ContactList.class);

        for(Contactdto contactdto : contacts.getContacts()) {
            System.out.println(contactdto.getId());
            System.out.println(contactdto.getEmail());






        }




    }




}
