package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StorageApiInterface2 {

    @GET("q8peo")
    Call<StoragePojo2> getData();
}
