package com.example.quiz_application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> Questions=new ArrayList<String>();
    ArrayList<String> Answers=new ArrayList<String>();
    private RadioGroup Choices;
    private RadioButton ans;
    private Button next;
    TextView Qv;
    int i=0;
    ArrayList<Integer> answers=new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Questions.add("1. C is object oriented language");
        Questions.add("2. Java allows multiple inheritance");
        Questions.add("3. MVC is an architecture");
        Questions.add("4. Pakistan is an independant state");
        Questions.add("5. BUKC has mechanical engineering dept");
        Questions.add("6. Java can be used for only desktop and web application");
        Questions.add("7. Android Studio uses c# as backend language");
        Questions.add("8. Bitbucket and Git are same");
        Questions.add("9. Nagasaki is situated in Japan");
        Questions.add("10.HTML is a programming language ");

        Answers.add("False");
        Answers.add("False");
        Answers.add("False");
        Answers.add("True");
        Answers.add("False");
        Answers.add("True");
        Answers.add("False");
        Answers.add("True");
        Answers.add("True");
        Answers.add("False");
        next=findViewById(R.id.button);
        Choices = (RadioGroup) findViewById(R.id.Options);
        Qv=findViewById(R.id.QuestionView);
        Qv.setText(Questions.get(i));

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedId = Choices.getCheckedRadioButtonId();
                ans= (RadioButton) findViewById(selectedId);
                String anss=ans.getText().toString();
                String CompareAnswer=Answers.get(i);
                if(anss.equalsIgnoreCase(CompareAnswer)){
                    answers.add(1);
                }
                i++;

                if(i<Questions.size()){
                    Qv.setText(Questions.get(i));
                    ans.setChecked(false);
                }else {
                    Toast.makeText(getApplicationContext(),
                            answers.size()+" Are Correct out of 10", Toast.LENGTH_SHORT).show();
                }




            }
        });

    }
}
