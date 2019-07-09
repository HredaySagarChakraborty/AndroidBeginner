package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AndroidApiInterface11 {

    @GET("w5wpi")
    Call<AndroidPojo11> getData();
}
