package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ContainerApiInterface2 {



    @GET("nmahk")
    Call<ContainerPojo2> getData();
}
