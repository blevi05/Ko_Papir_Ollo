package com.example.diak.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button ko,papir,ollo;

    private TextView eredmeny;

    private int human_scrore = 0, robot_score = 0;

    private ImageView ember,robot;

    Random r;

    private String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ko = (Button) findViewById(R.id.button_rock);
        papir = (Button) findViewById(R.id.button_paper);
        ollo = (Button) findViewById(R.id.button_scissors);

        eredmeny = (TextView) findViewById(R.id.textView_score);
        ember = (ImageView) findViewById(R.id.imageView_human);
        robot = (ImageView) findViewById(R.id.imageView_robot);

        r = new Random();

        ko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ember.setBackgroundResource(R.drawable.rock);
                //eredmeny.setText("Eredmény Ember: " + human_scrore + " Gép: " + robot_score);
                robotch();

            }
        });

        papir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ember.setBackgroundResource(R.drawable.paper);
                //eredmeny.setText("Eredmény Ember: " + human_scrore + " Gép: " + robot_score);
                robotch();

            }
        });

        ollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ember.setBackgroundResource(R.drawable.scissors);
                //eredmeny.setText("Eredmény Ember: " + human_scrore + " Gép: " + robot_score);
                robotch();

            }
        });

    }

        public void robotch() {

            int a = r.nextInt(3);

            if (a == 0) {

                        robot.setBackgroundResource(R.drawable.rock);

            } else if (a == 1){

                        robot.setBackgroundResource(R.drawable.paper);

            } else if (a == 2){

                        robot.setBackgroundResource(R.drawable.scissors);

                    }

            if (ember.equals("rock") && robot.equals("paper")) {
                result = "Vesztettél";
                robot_score++;
            } else if (ember.equals("rock") && robot.equals("scissors")) {
                result = "Győztél";
                human_scrore++;
            } else if (ember.equals("paper") && robot.equals("rock")) {
                result = "Győztél";
                human_scrore++;
            } else if (ember.equals("paper") && robot.equals("scissors")) {
                result = "Vesztettél";
                robot_score++;
            } else if (ember.equals("scissors") && robot.equals("paper")) {
                result = "Győztél";
                human_scrore++;
            } else if (ember.equals("scissors") && robot.equals("rock")) {
                result = "Vesztettél";
                robot_score++;
            } else if (ember.equals("rock") && robot.equals("rock")) {
                result = "Döntetlen";
            } else if (ember.equals("paper") && robot.equals("paper")) {
                result = "Döntetlen";
            } else if (ember.equals("scissors") && robot.equals("scissors")) {
                result = "Döntetlen";
            }

            Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();

            }

    }

