package io.github.haydnkeung.scheduler;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        ArrayList<MyEvent> sampleData = generateData(1000);

        //Creates an arrayAdapter to be used with Listview
        MyEventAdapter itemsAdapter = new MyEventAdapter(this, R.layout.list_item, sampleData);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);


        //takes you to new activity when item is clicked
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Gets MyEvent obj from adapter passing in the position in list
                MyEvent curEvent = (MyEvent) parent.getItemAtPosition(position);

                //Create new explicit intent to start call taskDetails activity
                Intent intent = new Intent(TaskList.this,TaskDetails.class);

                //Place task name/details into bundle
                Bundle bundle = new Bundle();
                bundle.putString("TaskName",curEvent.getEventName());
                bundle.putString("Taskdescrip",curEvent.getDescrip());

                //Put bundle into intent
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });


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
