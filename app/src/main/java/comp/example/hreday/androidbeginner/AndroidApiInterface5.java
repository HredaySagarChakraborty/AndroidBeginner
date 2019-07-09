package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AndroidApiInterface5 {



    @GET("j2kce")
    Call<AndroidPojo5> getData();
}
