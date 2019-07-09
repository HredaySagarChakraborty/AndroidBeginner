package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SqliteApiInterface3 {


    @GET("1cq4dg")
    Call<SqlitePojo3> getData();
}
