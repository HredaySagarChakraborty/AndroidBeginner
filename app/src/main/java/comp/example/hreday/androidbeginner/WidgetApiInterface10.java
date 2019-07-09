package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WidgetApiInterface10 {


    @GET("1836n6")
    Call<WidgetPojo10> getData();
}
