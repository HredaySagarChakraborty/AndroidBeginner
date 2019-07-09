package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WidgetApiInterface9 {


    @GET("c5x6q")
    Call<WidgetPojo9> getData();
}
