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

public class LayoutActivity6 extends AppCompatActivity {
    String title,desc1,desc2;
    private TextView textView1,textView2,textView3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout6);
        this.setTitle("LayoutActivity6");

        textView1=findViewById(R.id.layoutImageActivity6text1Id);
        textView2=findViewById(R.id.layoutImageActivity6text2Id);
        textView3=findViewById(R.id.layoutImageActivity6text3Id);


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.myjson.com/bins/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        LayoutApiInterface6 apiInterface=retrofit.create(LayoutApiInterface6.class);
        Call<LayoutPojo6>call=apiInterface.getData();
        call.enqueue(new Callback<LayoutPojo6>() {
            @Override
            public void onResponse(Call<LayoutPojo6> call, Response<LayoutPojo6> response) {
                title=response.body().getTitle1();
                desc1=response.body().getDescription1();
                desc2=response.body().getDescription2();



                textView1.setText(title);
                textView2.setText(desc1);
                textView3.setText(desc2);


            }

            @Override
            public void onFailure(Call<LayoutPojo6> call, Throwable t) {
                Toast.makeText(LayoutActivity6.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}
