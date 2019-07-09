package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WidgetApiInterface6 {

    @GET("d7jyy")
    Call<WidgetPojo6> getData();


}
