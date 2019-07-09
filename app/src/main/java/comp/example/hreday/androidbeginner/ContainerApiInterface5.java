package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ContainerApiInterface5 {



    @GET("v6zm8")
    Call<ContainerPojo5> getData();
}
