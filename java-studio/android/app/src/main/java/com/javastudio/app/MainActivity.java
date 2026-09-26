package com.javastudio.app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    // Change this to your deployed Render backend URL, ending with /api/health for the test below.
    private static final String BASE_URL = "http://10.0.2.2:8080";
    private TextView status;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        status = findViewById(R.id.status);
        Button button = findViewById(R.id.healthButton);
        button.setOnClickListener(v -> new Thread(this::checkBackend).start());
    }

    private void checkBackend() {
        try {
            HttpURLConnection c = (HttpURLConnection) new URL(BASE_URL + "/api/health").openConnection();
            c.setRequestMethod("GET");
            int code = c.getResponseCode();
            runOnUiThread(() -> status.setText("Backend HTTP status: " + code));
            c.disconnect();
        } catch (IOException e) {
            runOnUiThread(() -> status.setText("Backend connection failed: " + e.getMessage()));
        }
    }
}
