package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LayoutApiInterface2 {



    @GET("synse")
    Call<LayoutPojo2> getData();
}
