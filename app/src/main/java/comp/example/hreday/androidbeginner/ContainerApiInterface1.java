package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ContainerApiInterface1 {


    @GET("pvoys")
    Call<ContainerPojo1> getData();

}
