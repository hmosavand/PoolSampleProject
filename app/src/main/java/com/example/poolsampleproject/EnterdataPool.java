package com.example.poolsampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Trace;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class EnterdataPool extends AppCompatActivity {
    EditText ETPreHeatingHour,
            ETPoolHourPreHeating,
            EtpoolChangWaterRate,
            ETpoolDeepAvarage,
            ETnumberOfPeople,
            ETpoolSurface;
    Button btnSavePool;
    RadioButton RBpublic, RBprivate, RBtraining, RBchilderen;
    RadioGroup RGcondition;

    RadioGroup RGnafarsurface;
    RadioButton RBpoolNumberOfPeole, RBpoolVelocity;
    public double[] BaseValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterdata_pool);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {

            BaseValue = bundle.getDoubleArray("PrefValu");
        }


        ETPoolHourPreHeating = findViewById(R.id.ETPoolHourPreHeating);
        EtpoolChangWaterRate = findViewById(R.id.EtpoolChangWaterRate);
        ETpoolDeepAvarage = findViewById(R.id.ETpoolDeepAvarage);
        ETpoolSurface = findViewById(R.id.ETpoolSurface);
        ETnumberOfPeople = findViewById(R.id.ETnumberOfPeople);


        // مقدار دهی اولیه
        ETPoolHourPreHeating.setText(Double.toString(BaseValue[10]));//زمان راه اندازی

        EtpoolChangWaterRate.setText(Double.toString(BaseValue[12]));//نرخ تعویض آب
        ETpoolDeepAvarage.setText(Double.toString(BaseValue[7]));
        ETpoolSurface.setText(Double.toString(BaseValue[8]));
        ETnumberOfPeople.setText(Double.toString(BaseValue[14]));

        ///cast of Enterance


        RGnafarsurface = findViewById(R.id.RGnumberSurface);
        RBpoolNumberOfPeole = findViewById(R.id.RBpoolNumberOfPeole);
        RBpoolNumberOfPeole.setChecked(false);

        RBpoolVelocity = findViewById(R.id.RBpoolVelocity);
        RBpoolVelocity.setChecked(true);


        ETnumberOfPeople = findViewById(R.id.ETnumberOfPeople);
        ETnumberOfPeople.setEnabled(false);
        ETpoolSurface = findViewById(R.id.ETpoolSurface);
        ETpoolSurface.setEnabled(true);


        ////////////////////////////////////////////////////
        /////////////////set data from base file from PrefValue


        RGnafarsurface.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (RBpoolNumberOfPeole.isChecked()) {
                    ETnumberOfPeople.setEnabled(true);
                    ETpoolSurface.setEnabled(false);
                    /// مقداد کنترل ورودی را از ۲ به ۲.۱ تغییر دهد دفعه بعد چک کند که قبلا وارد شد ه ست را روی این مقدار فیکس کند
                    //مثدار معادل مساحت را نیز محاسبه کند

                } else {

                    ETnumberOfPeople.setEnabled(false);
                    ETpoolSurface.setEnabled(true);
                    //مثدار نفرات معادل رامحاسبه کند و رند کند در مقدار قرار دهد
//کنترل ورودی را از مقدار را به مقدار 2.2 تغییر دهد تا بدانیم که مقدار پیش فرض در اینجا چه بوده است

                }
            }
        });


        //     RGnafarsurface.setOnCheckedChangeListener();

//RBpoolNumberOfPeole.setOnCheckedChangeListener(new View.OnClickListener());


        btnSavePool = findViewById(R.id.btnSavePool);
        btnSavePool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ETPreHeatingHour = (EditText) findViewById(R.id.ETPoolHourPreHeating);
                ETPoolHourPreHeating = findViewById(R.id.ETPoolHourPreHeating);
                EtpoolChangWaterRate = findViewById(R.id.EtpoolChangWaterRate);
                ETpoolDeepAvarage = findViewById(R.id.ETpoolDeepAvarage);
                ETnumberOfPeople = findViewById(R.id.ETnumberOfPeople);
                ETpoolSurface = findViewById(R.id.ETpoolSurface);

                ////radio button casting
                RBpublic = findViewById(R.id.RBpoolPub);
                RBprivate = findViewById(R.id.RBpoolPrivate);
                RBtraining = findViewById(R.id.RBtraining);
                RBchilderen = findViewById(R.id.RBchilderen);

                RGcondition = findViewById(R.id.RGBconditionofpool);


                SharedPreferences shared = getSharedPreferences("Prefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = shared.edit();
                //   editor.putString("stringPool_1", ETPreHeatingHour.getText().toString());
                editor.putString("stringPool_1", ETPoolHourPreHeating.getText().toString());
                editor.putString("stringPool_2", EtpoolChangWaterRate.getText().toString());
////// select radio button
                String PoolPositon = "";
                if (RBpublic.isChecked()) {
                    PoolPositon = "1";
                }
                if (RBprivate.isChecked()) {
                    PoolPositon = "2";
                }
                if (RBtraining.isChecked()) {
                    PoolPositon = "3";
                }
                if (RBchilderen.isChecked()) {
                    PoolPositon = "4";
                }
                editor.putString("stringPool_3", PoolPositon);
                editor.putString("stringPool_4", ETpoolDeepAvarage.getText().toString());
                PoolPositon = "";
                if (RBpoolNumberOfPeole.isChecked()) {
                    PoolPositon = "1";

                    editor.putString("stringPool_5", PoolPositon);
                    editor.putString("stringPool_6", ETnumberOfPeople.getText().toString());
                } else {

                    PoolPositon = "2";

                    editor.putString("stringPool_5", PoolPositon);
                    editor.putString("stringPool_6", ETpoolSurface.getText().toString());


                }


                editor.apply();
                //Toast.makeText(EnterdataPool.this,"be saved",Toast.LENGTH_LONG).show();

                String string_from_sp = shared.getString("stringPool_1", "");


                Toast.makeText(EnterdataPool.this, string_from_sp + "besaved", Toast.LENGTH_LONG).show();
                //  finish();
                Intent myintent = new Intent(EnterdataPool.this, Entekhabtajhiz.class);
                //  Toast.makeText(EnterdataPool.this, Double.toString(BaseValue[10]), Toast.LENGTH_LONG).show();

                BaseValue[7] = Double.parseDouble(ETpoolDeepAvarage.getText().toString());
                BaseValue[8] = Double.parseDouble(ETpoolSurface.getText().toString());
                BaseValue[10] = Double.parseDouble(ETPoolHourPreHeating.getText().toString());
                BaseValue[12] = Double.parseDouble(EtpoolChangWaterRate.getText().toString());
                BaseValue[14] = Double.parseDouble(ETnumberOfPeople.getText().toString());
                BaseValue[0] = 2;
                Toast.makeText(EnterdataPool.this, Double.toString(BaseValue[10]), Toast.LENGTH_LONG).show();
                myintent.putExtra("PrefValu", BaseValue);
                startActivity(myintent);
                finish();

            }
        });


    }
}
