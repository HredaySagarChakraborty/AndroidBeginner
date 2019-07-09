package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LayoutApiInterface3 {


    @GET("xzcf2")
    Call<LayoutPojo3> getData();
}
