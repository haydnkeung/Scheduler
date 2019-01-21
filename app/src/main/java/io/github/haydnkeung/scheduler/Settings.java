package io.github.haydnkeung.scheduler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Settings extends AppCompatActivity {

    private final String versionNumber = "19.01.20a";//Format is YY/MM/DD[a-z]

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        TextView verText = findViewById(R.id.verText);
        verText.setText(versionNumber);
    }
}
