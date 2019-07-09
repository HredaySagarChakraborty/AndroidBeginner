package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SqliteApiInterface2 {


    @GET("ju63o")
    Call<SqlitePojo2> getData();
}
