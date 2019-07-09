package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LayoutApiInterface4 {

    @GET("g8ub2")
    Call<LayoutPojo4> getData();
}
