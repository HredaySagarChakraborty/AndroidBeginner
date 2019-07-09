package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WidgetApiInterface3 {

    @GET("dxpbu")
    Call<WidgetPojo3> getData();
}
