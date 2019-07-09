package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceApiInterface1 {




    @GET("16jqtg")
    Call<ServicePojo1> getData();
}
