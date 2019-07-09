package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FragmentApiInterface3 {



    @GET("fo6se")
    Call<FragmentPojo3> getData();
}
