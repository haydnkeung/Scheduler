package io.github.haydnkeung.scheduler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Calender extends AppCompatActivity {

    public LinearLayout rootView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        rootView = findViewById(R.id.calenderLayout);

        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < 9;i++){
            list.add(new Integer(i).toString());

            TextView element = new TextView(this);
            element.setText(list.get(i));
            rootView.addView(element);
        }



    }



}
