package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MenuApiInterface3 {

    @GET("hfq2c")
    Call<MenuPojo3> getData();
}
