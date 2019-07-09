package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WidgetApiInterface13 {



    @GET("qef16")
    Call<WidgetPojo13> getData();
}
