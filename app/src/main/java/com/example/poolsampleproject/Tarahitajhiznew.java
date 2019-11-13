package com.example.poolsampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tarahitajhiznew extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarahitajhiznew);
        //////////////////// btntarahipool
        Button btntarahipool = (Button) findViewById(R.id.btntarahipool);
        btntarahipool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenttarahipool = new Intent(Tarahitajhiznew.this, tarahiEstakhr.class);
                startActivity(intenttarahipool);
            }
        });

//////////////////////////////////////////////////////////////////jakoozi
        Button btntarahijakoozi = (Button) findViewById(R.id.btntarahiJakoozi);
        btntarahijakoozi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenttarahijakoozi = new Intent(Tarahitajhiznew.this, tarahiJakoozi.class);
                startActivity(intenttarahijakoozi);

            }
        });

//////////////////////////////////////////////////////////////////

        Button btntarahicoolwater = (Button) findViewById(R.id.btntarahiCoolwater2);

        btntarahicoolwater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenttarahicoolwater = new Intent(Tarahitajhiznew.this, entekhabe_hozcheabsard.class);
                startActivity(intenttarahicoolwater);
            }
        });


///////////////////////////////////////////////////////////////sona

        Button btntarahisona = (Button) findViewById(R.id.btntarahisona);
        btntarahisona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenttarahisona = new Intent(Tarahitajhiznew.this, tarahiSona.class);
                startActivity(intenttarahisona);

            }
        });


    }
}
