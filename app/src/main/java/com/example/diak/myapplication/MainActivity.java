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

    private Button ko, papir, ollo;

    private TextView eredmeny;

    private int human_scrore = 0, robot_score = 0;

    private ImageView ember, robot;

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


        ko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ember.setBackgroundResource(R.drawable.rock);
                String result = robotch("rock");
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
                eredmeny.setText("Eredmény Ember: " + Integer.toString(human_scrore) + " Robot: " + Integer.toString(robot_score));
            }
        });

        papir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ember.setBackgroundResource(R.drawable.paper);
                String result = robotch("paper");
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
                eredmeny.setText("Eredmény Ember: " + Integer.toString(human_scrore) + " Robot: " + Integer.toString(robot_score));
            }
        });

        ollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ember.setBackgroundResource(R.drawable.scissors);
                String result = robotch("scissors");
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
                eredmeny.setText("Eredmény Ember: " + Integer.toString(human_scrore) + " Robot: " + Integer.toString(robot_score));
            }
        });

    }

    public String robotch( String jatekos_valaszt) {

        String robot_valaszt = "";
        Random r = new Random();

        int a = r.nextInt(3);

        if (a == 0) {
            robot_valaszt = "rock";
        } else if (a == 1) {
            robot_valaszt = "paper";
        } else if (a == 2) {
            robot_valaszt = "scissors";
        }

        if (robot_valaszt == "rock") {
            robot.setBackgroundResource(R.drawable.rock);
        } else if (robot_valaszt == "paper") {
            robot.setBackgroundResource(R.drawable.paper);
        } else if (robot_valaszt == "scissors") {
            robot.setBackgroundResource(R.drawable.scissors);
        }


        if (robot_valaszt == jatekos_valaszt) {
            return "Döntettlen";
        } else if (jatekos_valaszt == "rock" && robot_valaszt == "scissors") {
            human_scrore++;
            return  "Győztél";
        } else if (jatekos_valaszt == "rock" && robot_valaszt == "paper") {
            robot_score++;
            return "Vesztettél";
        } else if (jatekos_valaszt == "scissors" && robot_valaszt == "rock") {
            robot_score++;
            return "Vesztettél";
        } else if (jatekos_valaszt == "scissors" && robot_valaszt == "paper") {
            human_scrore++;
            return "Győztél";
        } else if (jatekos_valaszt == "paper" && robot_valaszt == "rock") {
            human_scrore++;
            return "Győztél";
        } else if (jatekos_valaszt == "paper" && robot_valaszt == "scissors") {
            robot_score++;
            return "Vesztettél";
        }
        else return "0";

    }

}