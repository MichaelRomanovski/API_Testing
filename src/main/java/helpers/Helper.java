package helpers;

import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;

import java.util.Random;
import java.util.logging.Logger;

public interface Helper {
    int i = new Random().nextInt(1000) + 1000;
    MediaType JSON=MediaType.get("application/json;charset=utf-8");
    String baseUrl="https://contactapp-telran-backend.herokuapp.com";
    Gson gson=new Gson();
    OkHttpClient client=new OkHttpClient();
    String token = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoibWljaGF0QGRlZi5jb20iLCJpc3MiOiJSZWd1bGFpdCIsImV4cCI6MTY5OTMwNTAzMCwiaWF0IjoxNjk4NzA1MDMwfQ.Uza9o0aoKXMtJBzmXDlVKjhWwXLvoeQXj0ywEisJ_Gw";
}

