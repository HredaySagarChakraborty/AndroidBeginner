package comp.example.hreday.androidbeginner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StructureActivity3 extends AppCompatActivity {
    String title,desc1,details;
    private TextView textView1,textView2,textView3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_structure3);
        this.setTitle("StructureActivity3");

        textView1=findViewById(R.id.structImageActivity3text1Id);
        textView2=findViewById(R.id.structImageActivity3text2Id);
        textView3=findViewById(R.id.structImageActivity3text3Id);


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.myjson.com/bins/")
                .addConverterFactory(GsonConverterFactory.create()).build();


      StructureApiInteface3 apiInterface=retrofit.create( StructureApiInteface3.class);
        Call<StructurePojo3>call=apiInterface.getData();
        call.enqueue(new Callback<StructurePojo3>() {
            @Override
            public void onResponse(Call<StructurePojo3> call, Response<StructurePojo3> response) {
                title=response.body().getTitle1();
                desc1=response.body().getDescription1();
                details=response.body().getDescription2();



                textView1.setText(title);
                textView2.setText(desc1);
                textView3.setText(details);


            }

            @Override
            public void onFailure(Call<StructurePojo3> call, Throwable t) {
                Toast.makeText(StructureActivity3.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}
