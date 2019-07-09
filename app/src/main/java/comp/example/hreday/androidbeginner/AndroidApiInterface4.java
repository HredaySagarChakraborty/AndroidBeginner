package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AndroidApiInterface4 {



    @GET("17ler2")
    Call<AndroidPojo4> getData();
}
