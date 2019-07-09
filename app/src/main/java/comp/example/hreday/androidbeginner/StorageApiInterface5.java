package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StorageApiInterface5 {


    @GET("9jy3c")
    Call<StoragePojo5> getData();
}
