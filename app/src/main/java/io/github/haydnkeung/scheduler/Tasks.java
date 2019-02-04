package io.github.haydnkeung.scheduler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Tasks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        ArrayList<String> sampleData = generateData(100);

        //Creates an arrayAdapter to be used with Listview
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sampleData);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);


    }

    //Generates a list of length x to populate sample data
    private ArrayList<String> generateData(int x) {
        ArrayList<String> data = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            data.add("Task " + i);
        }
        return data;

    }
}
