package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WidgetApiInterface4 {


    @GET("6futm")
    Call<WidgetPojo4> getData();
}
