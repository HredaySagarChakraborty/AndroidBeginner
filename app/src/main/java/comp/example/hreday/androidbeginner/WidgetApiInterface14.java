package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WidgetApiInterface14 {


    @GET("wjea2")
    Call<WidgetPojo14> getData();
}
