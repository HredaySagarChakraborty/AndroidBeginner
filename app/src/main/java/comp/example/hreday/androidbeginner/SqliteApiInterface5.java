package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SqliteApiInterface5 {

    @GET("rfg2c")
    Call<SqlitePojo5> getData();
}
