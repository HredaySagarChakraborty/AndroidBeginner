package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WidgetApiInterface8 {


    @GET("199epe")
    Call<WidgetPojo8> getData();
}
