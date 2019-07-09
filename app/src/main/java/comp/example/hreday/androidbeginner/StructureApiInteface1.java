package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StructureApiInteface1 {


    @GET("10xtr2")
    Call<StructurePojo1> getData();
}
