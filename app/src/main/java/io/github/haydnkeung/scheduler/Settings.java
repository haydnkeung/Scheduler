package io.github.haydnkeung.scheduler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Settings extends AppCompatActivity {

    private final String versionNumber = "19.02.06a";//Format is YY/MM/DD[a-z]

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        TextView verText = findViewById(R.id.verText);
        verText.setText("Version: " + versionNumber);
    }
}
