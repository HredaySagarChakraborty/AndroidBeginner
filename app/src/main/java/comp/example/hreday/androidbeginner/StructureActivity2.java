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

public class StructureActivity2 extends AppCompatActivity {
    String title,desc1,details;
    private TextView textView1,textView2,textView3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_structure2);
        this.setTitle("StructureActivity2");

        textView1=findViewById(R.id.structImageActivity2text1Id);
        textView2=findViewById(R.id.structImageActivity2text2Id);
        textView3=findViewById(R.id.structImageActivity2text3Id);


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.myjson.com/bins/")
                .addConverterFactory(GsonConverterFactory.create()).build();


        StructureApiInterface2 apiInterface=retrofit.create(StructureApiInterface2.class);
        Call<StructurePojo2>call=apiInterface.getData();
        call.enqueue(new Callback<StructurePojo2>() {
            @Override
            public void onResponse(Call<StructurePojo2> call, Response<StructurePojo2> response) {
                title=response.body().getTitle1();
                desc1=response.body().getDescription1();
                details=response.body().getDescription2();



                textView1.setText(title);
                textView2.setText(desc1);
                textView3.setText(details);


            }

            @Override
            public void onFailure(Call<StructurePojo2> call, Throwable t) {
                Toast.makeText(StructureActivity2.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}
