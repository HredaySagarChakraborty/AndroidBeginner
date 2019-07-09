package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FragmentApiInterface5 {

    @GET("q6x1q")
    Call<FragmentPojo5> getData();
}
