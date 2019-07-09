package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AndroidApiInteface9 {

    @GET("bhql2")
    Call<AndroidPojo9> getData();

}
