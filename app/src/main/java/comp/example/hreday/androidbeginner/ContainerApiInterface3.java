package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ContainerApiInterface3 {



    @GET("62o28")
    Call<ContainerPojo3> getData();
}
