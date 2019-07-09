package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WidgetApiInterface1 {

    @GET("7azyq")
    Call<WidgetPojo1> getData();
}
