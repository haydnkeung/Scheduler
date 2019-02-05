package io.github.haydnkeung.scheduler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class Tasks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        ArrayList<MyEvent> sampleData = generateData(1000);

        //Creates an arrayAdapter to be used with Listview
        MyEventAdapter itemsAdapter = new MyEventAdapter(this, R.layout.list_item, sampleData);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);


    }

    //Generates a list of length x to populate sample data
    private ArrayList<MyEvent> generateData(int x) {
        ArrayList<MyEvent> data = new ArrayList<>();
        for (int i = 1; i <= x; i++) {
            data.add(new MyEvent(this, "Task " + i, i / 365, (i / 30) + 1, i % 30));
        }
        return data;

    }
}
