package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StructureApiInterface2 {

    @GET("10n3y6")
    Call<StructurePojo2> getData();
}
