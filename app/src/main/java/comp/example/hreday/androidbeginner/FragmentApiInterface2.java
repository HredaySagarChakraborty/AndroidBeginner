package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FragmentApiInterface2 {



    @GET("14dfwm")
    Call<FragmentPojo2> getData();

}
