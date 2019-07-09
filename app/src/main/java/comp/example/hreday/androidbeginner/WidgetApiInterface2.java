package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WidgetApiInterface2 {


    @GET("i9aeq")
    Call<WidgetPojo2> getData();
}
