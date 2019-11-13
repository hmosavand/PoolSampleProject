package com.example.poolsampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnterdataSona extends AppCompatActivity {


    EditText ETsonaKoshkSurface,
            ETsonaKHoshkHigh,
            ETsonaWetSurface,
            ETsonaWetHigh;

    Button btnSonaSave;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterdata_sona);
////////////////////casting
        ETsonaKoshkSurface = findViewById(R.id.ETsonaKoshkSurface);
        ETsonaKHoshkHigh = findViewById(R.id.ETsonaKHoshkHigh);
        ETsonaWetSurface = findViewById(R.id.ETsonaWetSurface);
        ETsonaWetHigh = findViewById(R.id.ETsonaWetHigh);
        btnSonaSave = findViewById(R.id.btnSonaSave);
//////////////////////////////////////////////////////////////
        /////////saving
        btnSonaSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences shared = getSharedPreferences("Prefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = shared.edit();
                editor.putString("stringSona_1", ETsonaKoshkSurface.getText().toString());
                editor.putString("stringSona_2", ETsonaKHoshkHigh.getText().toString());
                editor.putString("stringSona_3", ETsonaWetSurface.getText().toString());
                editor.putString("stringSona_4", ETsonaWetHigh.getText().toString());
                editor.apply();


                Toast.makeText(EnterdataSona.this, "besaved", Toast.LENGTH_LONG).show();
                finish();

            }
        });








    }
}
