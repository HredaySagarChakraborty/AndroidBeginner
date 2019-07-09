package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AndroidApiInterface1 {

@GET("gq1tu")
    Call<AndroidPojo1>getData();


}
