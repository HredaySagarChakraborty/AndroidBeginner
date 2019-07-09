package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LayoutApiInterface5 {

    @GET("606pa")
    Call<LayoutPojo5> getData();
}
