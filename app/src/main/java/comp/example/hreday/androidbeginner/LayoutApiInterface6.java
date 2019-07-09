package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LayoutApiInterface6 {

    @GET("hds2m")
    Call<LayoutPojo6> getData();
}
