package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ContainerApiInterface4 {


    @GET("9j734")
    Call<ContainerPojo4> getData();
}
