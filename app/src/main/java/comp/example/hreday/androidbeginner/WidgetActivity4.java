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

public class WidgetActivity4 extends AppCompatActivity {
    String title,desc1,desc2;
    private TextView textView1,textView2,textView3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget4);
        this.setTitle("WidgetActivity4");


        textView1=findViewById(R.id.widgetImageActivity4text1Id);
        textView2=findViewById(R.id.widgetImageActivity4text2Id);
        textView3=findViewById(R.id.widgetImageActivity4text3Id);


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.myjson.com/bins/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        WidgetApiInterface4 apiInterface=retrofit.create(WidgetApiInterface4.class);
        Call<WidgetPojo4>call=apiInterface.getData();
        call.enqueue(new Callback<WidgetPojo4>() {
            @Override
            public void onResponse(Call<WidgetPojo4> call, Response<WidgetPojo4> response) {
                title=response.body().getTitle1();
                desc1=response.body().getDescription1();
                desc2=response.body().getDescription2();



                textView1.setText(title);
                textView2.setText(desc1);
                textView3.setText(desc2);


            }

            @Override
            public void onFailure(Call<WidgetPojo4> call, Throwable t) {
                Toast.makeText(WidgetActivity4.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}


