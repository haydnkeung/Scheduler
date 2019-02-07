package io.github.haydnkeung.scheduler;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private long timeInMilisec = 64*1000;//used for timer
    private CountDownTimer timer;//used for timer
    private TextView timerView;//used for timer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startTimer();

        //Calender Button
        Button startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Calender.class));
            }
        });

        //Settings Button
        Button settingsButton = findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Settings.class));
            }
        });

        Button tasksButton = findViewById(R.id.tasksButton);
        tasksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TaskList.class));
            }
        });

    }

    private long toSec(long timeInMilisec){
        return timeInMilisec/1000;
    }

    private void startTimer(){
        //Timer
        timerView = findViewById(R.id.countDown);
        timer = new CountDownTimer(timeInMilisec,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeInMilisec = millisUntilFinished;
                updateTime();
            }

            @Override
            public void onFinish() {
                timeInMilisec = 1000*10;//10 seconds
                this.start();
            }
        }.start();
    }

    private void updateTime(){
        int hour = (int) toSec(timeInMilisec) /3600;
        int min = (int)(toSec(timeInMilisec) -3600*hour)/60;
        int sec = (int) toSec(timeInMilisec) %60;

        String stringhr = String.format("%02d",hour);
        String stringmin = String.format("%02d",min);
        String stringsec = String.format("%02d",sec);

        String display = stringhr+":"+stringmin+":"+stringsec;

        timerView.setText(display);
    }

}
