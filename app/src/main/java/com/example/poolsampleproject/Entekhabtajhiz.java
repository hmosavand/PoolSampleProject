package com.example.poolsampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Array;

//import static com.example.poolsampleproject.EnterdataPool.Name;

public class Entekhabtajhiz extends AppCompatActivity {

    //SharedPreferences shPref;
    //  public static final String MyPref = "MyPrefers";
    @Override
    protected void onResume() {

        super.onResume();
    }

    final double[] PreSelect = {0, 4.7, 26.7, 29, 40, 10, 10, 1.5, 100, 150, 24, 60, 6, 25, 43,
            40, 1.96, 1.44, 11.8, 11, 3, .5, 21.92, 13, 385, .6, 3.6, 200200, 0, 0, 0, 0, 0};

    public double PrefValu[] = new double[30];

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entekhabtajhiz);
//////////////////////////////// Estakhr
        ///Back data fram estakhr
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {

            PrefValu = bundle.getDoubleArray("PrefValu");

        }


        Button btnenterdatapool = (Button) findViewById(R.id.btnenterdataPool);
        if (PrefValu[0] == 2) {
            btnenterdatapool.setTextColor(Color.RED);

        }
        btnenterdatapool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(Entekhabtajhiz.this, EnterdataPool.class);
                if (PrefValu[0] == 0) {
                    PrefValu = PreSelect;
                    PrefValu[0] = 1;
                }
                Toast.makeText(Entekhabtajhiz.this, Double.toString(PrefValu[0]), Toast.LENGTH_LONG).show();
                myintent.putExtra("PrefValu", PrefValu);

                startActivity(myintent);
                finish();
            }
        });
/////////////////////////////////////////////////////  jakooozi
        Button btnenterdatajakoozi = (Button) findViewById(R.id.btnenterdataJakoozi);
        btnenterdatajakoozi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jakooziintent = new Intent(Entekhabtajhiz.this, JakooziEntekhab.class);
                startActivity(jakooziintent);

            }
        });
        //////////////////////////////////////////////////hozche abe sard
        Button btnenterdatahozabsard = (Button) findViewById(R.id.btnenterdataCoolwater);
        btnenterdatahozabsard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intethozcheabesard = new Intent(Entekhabtajhiz.this, EnterdataHozAbSard.class);
                startActivity(intethozcheabesard);
            }
        });

//////////////////////////////////////////////// sona
        Button btnenterdatasona = (Button) findViewById(R.id.btnenterdataSona);
        btnenterdatasona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intetenterdatasona = new Intent(Entekhabtajhiz.this, EnterdataSona.class);
                startActivity(intetenterdatasona);
            }
        });
////////////////////////////////////////////////////////barhararati sakhteman
        Button btnbarhararatisakhteman = (Button) findViewById(R.id.btnbarsakhteman);
        btnbarhararatisakhteman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentbarhararatisakhteman = new Intent(Entekhabtajhiz.this, EnterdataBarSakhteman.class);
                startActivity(intentbarhararatisakhteman);
            }
        });


        ////////////////////////////////btntest
        Button btntest = findViewById(R.id.btnTest);
        btntest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent myintent = new Intent(Entekhabtajhiz.this, EnterdataKHolasehEtelaaat.class);

                startActivity(myintent);
                finish();

            }
        });

    }
}
