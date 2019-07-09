package comp.example.hreday.androidbeginner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class QuizResultActivity extends AppCompatActivity {
    private TextView text1,text2,text3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);
        this.setTitle("QuizResultActivity");


        text1=findViewById(R.id.myText4);
        text2=findViewById(R.id.myText5);
        text3=findViewById(R.id.myText6);


        Intent i=getIntent();

        String question=i.getStringExtra("total");
        String right=i.getStringExtra("correct");
        String incorrect=i.getStringExtra("wrong");

        text1.setText(question);
        text2.setText(right);
        text3.setText(incorrect);





    }
}
