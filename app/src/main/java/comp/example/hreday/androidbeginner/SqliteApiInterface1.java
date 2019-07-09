package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SqliteApiInterface1 {


    @GET("7m47c")
    Call<SqlitePojo1> getData();
}
