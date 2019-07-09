package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AndroidApiInterface2 {

    @GET("dh9fi")
    Call<AndroidPojo2>getData();


}
