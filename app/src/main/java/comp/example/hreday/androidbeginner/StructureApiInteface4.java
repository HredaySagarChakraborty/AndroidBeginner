package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StructureApiInteface4 {

    @GET("at40e")
    Call<StructurePojo4> getData();
}
