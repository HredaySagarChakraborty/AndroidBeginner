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

public class AndroidActivity7 extends AppCompatActivity {
    String title,desc1;
    private TextView androidImageActivity7text1,androidImageActivity7text2 ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android7);
        this.setTitle("AndroidActivity7");

        androidImageActivity7text1=findViewById(R.id.androidImageActivity7text1Id);
        androidImageActivity7text2=findViewById(R.id.androidImageActivity7text2Id);



        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.myjson.com/bins/")
                .addConverterFactory(GsonConverterFactory.create()).build();


        AndroidApiInterface7 apiInterface=retrofit.create(AndroidApiInterface7.class);
        Call<AndroidPojo7>call=apiInterface.getData();
        call.enqueue(new Callback<AndroidPojo7>() {
            @Override
            public void onResponse(Call<AndroidPojo7> call, Response<AndroidPojo7> response) {
                title=response.body().getTitle1();
                desc1=response.body().getDescription1();




                androidImageActivity7text1.setText(title);
                androidImageActivity7text2.setText(desc1);



            }

            @Override
            public void onFailure(Call<AndroidPojo7> call, Throwable t) {
                Toast.makeText(AndroidActivity7.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}
