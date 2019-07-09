package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StorageApiInterface3 {

    @GET("14sk7c")
    Call<StoragePojo3> getData();
}
