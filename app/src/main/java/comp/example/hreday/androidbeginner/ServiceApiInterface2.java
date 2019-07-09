package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceApiInterface2 {

    @GET("tc4wk")
    Call<ServicePojo2> getData();
}
