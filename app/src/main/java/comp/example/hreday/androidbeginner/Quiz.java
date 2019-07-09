package comp.example.hreday.androidbeginner;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class Quiz extends Fragment {
    private TextView t1, t2;
    private Button b1, b2, b3, b4;
    int total = 0;
    int correct = 0;
    int wrong = 0;
    DatabaseReference reference;


    public Quiz() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_quiz2, container, false);
        b1 = v.findViewById(R.id.optionButton1Id);
        b2 = v.findViewById(R.id.optionButton2Id);
        b3 = v.findViewById(R.id.optionButton3Id);
        b4 = v.findViewById(R.id.optionButton4Id);


        t1 = v.findViewById(R.id.questionsId);
        t2 = v.findViewById(R.id.timerId);


        updateQuestion();
        reverseTimer(60, t2);


        return v;

    }

    private void updateQuestion() {
        total++;

        if (total > 10) {

            Intent intent = new Intent(getActivity().getApplication(), QuizResultActivity.class);
            intent.putExtra("total", String.valueOf(total));
            intent.putExtra("correct", String.valueOf(correct));
            intent.putExtra("wrong", String.valueOf(wrong));

            startActivity(intent);


        } else {
            reference = FirebaseDatabase.getInstance().getReference().child("Questions").child(String.valueOf(total));

            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    final Question questions = dataSnapshot.getValue(Question.class);
                    t1.setText(questions.getQuestion());
                    b1.setText(questions.getOption1());
                    b2.setText(questions.getOption2());
                    b3.setText(questions.getOption3());
                    b4.setText(questions.getOption4());


                    b1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (b1.getText().toString().equals(questions.getAnswer())) {
                                b1.setBackgroundColor(Color.GREEN);

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                }, 1500);
                            } else {
                                wrong++;

                                b1.setBackgroundColor(Color.RED);

                                if (b2.getText().toString().equals(questions.getAnswer())) {

                                    b2.setBackgroundColor(Color.GREEN);
                                } else if (b3.getText().toString().equals(questions.getAnswer())) {

                                    b3.setBackgroundColor(Color.GREEN);
                                } else if (b4.getText().toString().equals(questions.getAnswer())) {

                                    b4.setBackgroundColor(Color.GREEN);
                                }


                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));

                                        updateQuestion();

                                    }
                                }, 1500);

                            }


                        }
                    });


                    b2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (b2.getText().toString().equals(questions.getAnswer())) {
                                b2.setBackgroundColor(Color.GREEN);

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                }, 1500);
                            } else {
                                wrong++;

                                b2.setBackgroundColor(Color.RED);

                                if (b1.getText().toString().equals(questions.getAnswer())) {

                                    b1.setBackgroundColor(Color.GREEN);
                                } else if (b3.getText().toString().equals(questions.getAnswer())) {

                                    b3.setBackgroundColor(Color.GREEN);
                                } else if (b4.getText().toString().equals(questions.getAnswer())) {

                                    b4.setBackgroundColor(Color.GREEN);
                                }


                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));

                                        updateQuestion();

                                    }
                                }, 1500);

                            }
                        }
                    });

                    b3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (b3.getText().toString().equals(questions.getAnswer())) {
                                b3.setBackgroundColor(Color.GREEN);

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                }, 1500);
                            } else {
                                wrong++;

                                b3.setBackgroundColor(Color.RED);

                                if (b1.getText().toString().equals(questions.getAnswer())) {

                                    b1.setBackgroundColor(Color.GREEN);
                                } else if (b2.getText().toString().equals(questions.getAnswer())) {

                                    b2.setBackgroundColor(Color.GREEN);
                                } else if (b4.getText().toString().equals(questions.getAnswer())) {

                                    b4.setBackgroundColor(Color.GREEN);
                                }


                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));

                                        updateQuestion();

                                    }
                                }, 1500);

                            }
                        }
                    });

                    b4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (b4.getText().toString().equals(questions.getAnswer())) {
                                b4.setBackgroundColor(Color.GREEN);

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                }, 1500);
                            } else {
                                wrong++;

                                b4.setBackgroundColor(Color.RED);

                                if (b1.getText().toString().equals(questions.getAnswer())) {

                                    b1.setBackgroundColor(Color.GREEN);
                                } else if (b2.getText().toString().equals(questions.getAnswer())) {

                                    b2.setBackgroundColor(Color.GREEN);
                                } else if (b3.getText().toString().equals(questions.getAnswer())) {

                                    b3.setBackgroundColor(Color.GREEN);
                                }


                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));

                                        updateQuestion();

                                    }
                                }, 1500);

                            }
                        }
                    });


                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }

            });


        }

    }


                public void reverseTimer(int seconds, final TextView tv) {
                    new CountDownTimer(seconds * 1000 + 1000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            int seconds = (int) (millisUntilFinished / 1000);
                            int minutes = seconds / 60;
                            seconds = seconds % 60;
                            tv.setText(String.format("%02d", minutes)
                                    + ":" + String.format("%02d", seconds));
                        }

                        @Override
                        public void onFinish() {
                            tv.setText("Completed");


                        }
                    }.start();
                }

            }










