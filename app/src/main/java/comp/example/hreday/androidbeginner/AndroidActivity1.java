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

public class AndroidActivity1 extends AppCompatActivity {
String title,desc1,details;
private TextView textView1,textView2,textView3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android1);
        this.setTitle("AndroidActivity1");

        textView1=findViewById(R.id.textView1id);
        textView2=findViewById(R.id.textView2id);
        textView3=findViewById(R.id.textview3id);


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.myjson.com/bins/")
                .addConverterFactory(GsonConverterFactory.create()).build();


        AndroidApiInterface1 apiInterface=retrofit.create(AndroidApiInterface1.class);
       Call<AndroidPojo1>call=apiInterface.getData();
       call.enqueue(new Callback<AndroidPojo1>() {
           @Override
           public void onResponse(Call<AndroidPojo1> call, Response<AndroidPojo1> response) {
               title=response.body().getTitle();
               desc1=response.body().getDescription();
               details=response.body().getDetails();



               textView1.setText(title);
               textView2.setText(desc1);
               textView3.setText(details);


           }

           @Override
           public void onFailure(Call<AndroidPojo1> call, Throwable t) {
               Toast.makeText(AndroidActivity1.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

           }
       });


    }
}
