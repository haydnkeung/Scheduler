package io.github.haydnkeung.scheduler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TaskDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        init();
    }

    private void init(){
        Bundle bundle = getIntent().getExtras();
        String title = (String)bundle.get("TaskName");
        String details = (String)bundle.get("Taskdescrip");

        TextView titleText = findViewById(R.id.details_title);
        titleText.setText(title);

        TextView detailsText = findViewById(R.id.details_descrip);
        detailsText.setText(details);

    }
}
