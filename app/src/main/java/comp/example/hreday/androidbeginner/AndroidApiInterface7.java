package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AndroidApiInterface7 {


    @GET("ba7r2")
    Call<AndroidPojo7> getData();
}
