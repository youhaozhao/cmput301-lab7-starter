package com.example.androiduitesting;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class ShowActivity extends AppCompatActivity {
    TextView cityNameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.show_activity);

        Button returnButton = findViewById(R.id.button_returnMain);
        cityNameView = findViewById(R.id.textView_CityName);
        returnButton.setOnClickListener(v -> finish());

        String cityName = Objects.requireNonNull(getIntent().getSerializableExtra("selectedCity")).toString();
        cityNameView.setText(cityName);
    }
}
