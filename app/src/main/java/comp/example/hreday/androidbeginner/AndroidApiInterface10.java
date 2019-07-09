package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AndroidApiInterface10 {
    @GET("d3tmu")
    Call<AndroidPojo10> getData();

}
