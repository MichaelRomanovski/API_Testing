package okhttp;

import dto.contactResponse;
import helpers.Helper;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class deleteAllContacts implements Helper {
    String endpoint="/v1/contacts/clear";


    @Test
            public void testDeleteAllContacts() throws IOException {


        Request request = new Request.Builder().url(baseUrl + endpoint).addHeader("Authorization", token)
                .delete().build();
        Response response = client.newCall(request).execute();
        contactResponse contactResponse=gson.fromJson(response.body().string(), dto.contactResponse.class);
        System.out.println(response.code());
        String message=contactResponse.getMessage();
        Assert.assertTrue(message.contains("All contacts was deleted!"));
    }


}
