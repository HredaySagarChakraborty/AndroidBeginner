package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StructureApiInteface3 {

    @GET("uxcji")
    Call<StructurePojo3> getData();
}
