package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WidgetApiInterface12 {


    @GET("1fr1yy")
    Call<WidgetPojo12> getData();
}
