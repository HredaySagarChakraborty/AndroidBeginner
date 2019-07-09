package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WidgetApiInterface5 {


    @GET("11sbtm")
    Call<WidgetPojo5> getData();
}
