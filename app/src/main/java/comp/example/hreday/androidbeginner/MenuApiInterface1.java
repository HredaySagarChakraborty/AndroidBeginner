package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MenuApiInterface1 {

    @GET("ad3ec")
    Call<MenuPojo1> getData();

}
