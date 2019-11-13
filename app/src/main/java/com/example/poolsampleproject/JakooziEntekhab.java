package com.example.poolsampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class JakooziEntekhab extends AppCompatActivity {
    EditText ETjakooziRadious, ETjakooziSurface,
            ETjakooziNumberOfPeople,

            ETjakooziStartUpTime,
            ETjakooziChangWaterRate,
            ETjakooziNumberOfNozzel;
    RadioButton RBjakooziRadius,
            RBJakooziSurface,
            RBjakooziNumberOfPeople;
    RadioGroup
            RGforSelection, RGforselectionitem;
    Button btnJakooziSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jakoozi_entekhab);

        ETjakooziRadious = findViewById(R.id.ETjakooziRadious);
        ETjakooziSurface = findViewById(R.id.ETjakooziSurface);
        ETjakooziNumberOfPeople = findViewById(R.id.ETjakooziNumberOfPeople);
        ETjakooziStartUpTime = findViewById(R.id.ETjakooziStartUpTime);
        ETjakooziChangWaterRate = findViewById(R.id.ETjakooziChangWaterRate);
        ETjakooziNumberOfNozzel = findViewById(R.id.ETjakooziNumberOfNozzel);
        RBjakooziRadius = findViewById(R.id.RBjakooziRadius);
        RBJakooziSurface = findViewById(R.id.RBJakooziSurface);
        RBjakooziNumberOfPeople = findViewById(R.id.RBjakooziNumberOfPeople);
        RGforselectionitem = findViewById(R.id.RGforselectionitem);
        btnJakooziSave = findViewById(R.id.btnJakooziSave);

        RGforselectionitem.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                                          @Override
                                                          public void onCheckedChanged(RadioGroup radioGroup, int i) {
                                                              if (RBjakooziRadius.isChecked()) {
                                                                  ETjakooziRadious.setEnabled(true);
                                                                  ETjakooziSurface.setEnabled(false);
                                                                  ETjakooziNumberOfPeople.setEnabled(false);
                                                              }
                                                              if (RBJakooziSurface.isChecked()) {
                                                                  ETjakooziRadious.setEnabled(false);
                                                                  ETjakooziSurface.setEnabled(true);
                                                                  ETjakooziNumberOfPeople.setEnabled(false);
                                                              }
                                                              if (RBjakooziNumberOfPeople.isChecked()) {
                                                                  ETjakooziRadious.setEnabled(false);
                                                                  ETjakooziSurface.setEnabled(false);
                                                                  ETjakooziNumberOfPeople.setEnabled(true);
                                                              }

                                                          }
                                                      }
        );

        ////////////////////////////////////////////////////////////////////////get data
        btnJakooziSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences shared = getSharedPreferences("Prefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = shared.edit();

                editor.putString("stringJakoozi_1", ETjakooziStartUpTime.getText().toString());
                editor.putString("stringJakoozi_2", ETjakooziChangWaterRate.getText().toString());
                editor.putString("stringJakoozi_3", ETjakooziNumberOfNozzel.getText().toString());
                    if (ETjakooziRadious.isEnabled()){
                        editor.putString("stringJakoozi_4", "1");
                        editor.putString("stringJakoozi_5", ETjakooziRadious.getText().toString());

                        }
                    if (ETjakooziSurface.isEnabled()){
                    editor.putString("stringJakoozi_4", "2");
                    editor.putString("stringJakoozi_5", ETjakooziSurface.getText().toString());

                }
                    if (ETjakooziNumberOfPeople.isEnabled()){
                    editor.putString("stringJakoozi_4", "3");
                    editor.putString("stringJakoozi_5", ETjakooziNumberOfPeople.getText().toString());

                }

                editor.apply();
                Toast.makeText(JakooziEntekhab.this,  "be saved", Toast.LENGTH_LONG).show();
                finish();
            }
        });





    }


}