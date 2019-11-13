package com.example.poolsampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnterdataHozAbSard extends AppCompatActivity {
    EditText
            ETabsardSurface,
            ETabsardDeep,
            ETabsardStartUpingTime,
            ETabsardChangingWater;
    Button btnAbsardSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterdata_hoz_ab_sard);

        /////////////casting
        ETabsardSurface = findViewById(R.id.ETabsardSurface);
        ETabsardDeep = findViewById(R.id.ETabsardDeep);
        ETabsardStartUpingTime = findViewById(R.id.ETabsardStartUpingTime);
        ETabsardChangingWater = findViewById(R.id.ETabsardChangingWater);
        btnAbsardSave = findViewById(R.id.btnAbsardSave);

/////////////////////////////////////interdata
        btnAbsardSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                SharedPreferences shared = getSharedPreferences("Prefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = shared.edit();
                //   editor.putString("stringPool_1", ETPreHeatingHour.getText().toString());
                editor.putString("stringAbsard_1", ETabsardSurface.getText().toString());
                editor.putString("stringAbsard_2", ETabsardDeep.getText().toString());
                editor.putString("stringAbsard_3", ETabsardStartUpingTime.getText().toString());
                editor.putString("stringAbsard_4", ETabsardChangingWater.getText().toString());

                editor.apply();

                Toast.makeText(EnterdataHozAbSard.this,  "Absard saved", Toast.LENGTH_LONG).show();
                finish();



            }
        });



    }
}
