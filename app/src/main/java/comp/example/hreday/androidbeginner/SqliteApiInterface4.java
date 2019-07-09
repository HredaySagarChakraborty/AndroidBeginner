package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SqliteApiInterface4 {


    @GET("azo1w")
    Call<SqlitePojo4> getData();
}
