package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AndroidApiInterface8 {

    @GET("129d66")
    Call<AndroidPojo8> getData();
}
