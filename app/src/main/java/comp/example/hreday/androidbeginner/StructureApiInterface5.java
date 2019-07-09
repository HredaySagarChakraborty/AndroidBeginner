package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StructureApiInterface5 {

    @GET("rb1ye")
    Call<StructurePojo5> getData();
}
