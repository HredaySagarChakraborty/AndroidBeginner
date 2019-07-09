package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LayoutApiInterface1 {


    @GET("14qtum")
    Call<LayoutPojo1> getData();
}
