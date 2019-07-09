package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StorageApiInterface4 {


    @GET("qeaso")
    Call<StoragePojo4> getData();
}
