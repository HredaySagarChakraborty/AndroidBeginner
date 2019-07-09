package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AndroidApiInterface3 {

    @GET("e23fi")
    Call<AndroidPojo3>getData();


}
