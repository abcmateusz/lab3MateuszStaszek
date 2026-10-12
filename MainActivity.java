package com.example.fff;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText klient = findViewById(R.id.editTextText);
        RadioGroup grupa = findViewById(R.id.radioGroup);
        CheckBox ser = findViewById(R.id.checkBox);
        Button przycisk = findViewById(R.id.button);

        przycisk.setOnClickListener(v -> {

            String nazwa = klient.getText().toString();

            if (nazwa.isEmpty()) {
                klient.setError("wpisz nazwe klienta");
                return;
            }

            String rozmiar;

            if (grupa.getCheckedRadioButtonId() == R.id.radioButton) {
                rozmiar = "mala";
            } else if (grupa.getCheckedRadioButtonId() == R.id.radioButton2) {
                rozmiar = "srednia";
            } else if (grupa.getCheckedRadioButtonId() == R.id.radioButton3) {
                rozmiar = "duza";
            } else {
                rozmiar = "nie wybrano";
            }

            Intent intent = new Intent(MainActivity.this, SummaryActivity.class);

            intent.putExtra("klient", nazwa);
            intent.putExtra("rozmiar", rozmiar);
            intent.putExtra("ser", ser.isChecked());

            startActivity(intent);
        });
    }
}

