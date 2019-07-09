package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MenuApiInterface4 {

    @GET("apqn8")
    Call<MenuPojo4> getData();
}
