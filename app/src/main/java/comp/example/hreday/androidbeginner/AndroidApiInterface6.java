package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AndroidApiInterface6 {

    @GET("12yfy6")
    Call<AndroidPojo6> getData();

}
