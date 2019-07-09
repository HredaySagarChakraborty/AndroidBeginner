package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FragmentApiInterface1 {

    @GET("6hnva")
    Call<FragmentPojo1> getData();


}
