package comp.example.hreday.androidbeginner;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StructureApiInterface6 {

    @GET("pae7q")
    Call<StructurePojo6> getData();
}
