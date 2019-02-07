package io.github.haydnkeung.scheduler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Adapter;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class Calender extends AppCompatActivity {

    private LinearLayout rootView;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        rootView = findViewById(R.id.calenderLayout);
        listView = findViewById(R.id.calenderlistview);


        CalendarView calendarView = findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
               //To be implemented
            }
        });

        MyEventAdapter itemAdapter = new MyEventAdapter(this,R.layout.list_item,generateData(10));
        listView.setAdapter(itemAdapter);

    }

    //Generates a list of length x to populate sample data
    private ArrayList<MyEvent> generateData(int x) {
        ArrayList<MyEvent> data = new ArrayList<>();
        for (int i = 1; i <= x; i++) {
            MyEvent element = new MyEvent(this, "Task " + i, i / 365, (i / 30) + 1, i % 30);
            element.setDescrip("       Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
            data.add(element);
        }
        return data;

    }



}
