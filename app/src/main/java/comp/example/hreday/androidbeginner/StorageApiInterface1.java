package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StorageApiInterface1 {

    @GET("14pbow")
    Call<StoragePojo1> getData();
}
