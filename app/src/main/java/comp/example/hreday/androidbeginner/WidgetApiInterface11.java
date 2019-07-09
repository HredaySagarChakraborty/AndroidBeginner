package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WidgetApiInterface11 {


    @GET("1fm3qa")
    Call<WidgetPojo11> getData();
}
