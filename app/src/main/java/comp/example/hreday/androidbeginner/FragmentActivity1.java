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

public class FragmentActivity1 extends AppCompatActivity {
    String title,desc1,desc2;
    private TextView textView1,textView2,textView3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment1);

        this.setTitle("FragmentActivity1");

        textView1=findViewById(R.id.fragmentImageActivity1text1Id);
        textView2=findViewById(R.id.fragmentImageActivity1text2Id);
        textView3=findViewById(R.id.fragmentImageActivity1text3Id);


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.myjson.com/bins/")
                .addConverterFactory(GsonConverterFactory.create()).build();

  FragmentApiInterface1 apiInterface=retrofit.create(FragmentApiInterface1.class);
        Call<FragmentPojo1>call=apiInterface.getData();
        call.enqueue(new Callback<FragmentPojo1>() {
            @Override
            public void onResponse(Call<FragmentPojo1> call, Response<FragmentPojo1> response) {
                title=response.body().getTitle1();
                desc1=response.body().getDescription1();
                desc2=response.body().getDescription2();



                textView1.setText(title);
                textView2.setText(desc1);
                textView3.setText(desc2);


            }

            @Override
            public void onFailure(Call<FragmentPojo1> call, Throwable t) {
                Toast.makeText(FragmentActivity1.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}
