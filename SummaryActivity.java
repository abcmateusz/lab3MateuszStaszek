package com.example.fff;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        TextView klient = findViewById(R.id.textKlient);
        TextView rozmiar = findViewById(R.id.textRozmiar);
        TextView ser = findViewById(R.id.textSer);
        Button przycisk = findViewById(R.id.buttonPowrot);

        String nazwa = getIntent().getStringExtra("klient");
        String wielkosc = getIntent().getStringExtra("rozmiar");
        boolean dodatkowySer = getIntent().getBooleanExtra("ser", false);

        klient.setText("klient: " + nazwa);
        rozmiar.setText("rozmiar: " + wielkosc);

        if (dodatkowySer) {
            ser.setText("dodatkowy ser: tak");
        } else {
            ser.setText("dodatkowy ser: nie");
        }

        przycisk.setOnClickListener(v -> {
            finish();
        });
    }
}
