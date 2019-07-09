package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WidgetApiInterface7 {


    @GET("15mdqa")
    Call<WidgetPojo7> getData();

}
