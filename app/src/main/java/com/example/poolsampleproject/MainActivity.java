package com.example.poolsampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //entekhab tajhiz
        Button btn_enterData =(Button)findViewById(R.id.btnEnterData);
        btn_enterData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent=new Intent(MainActivity.this, Entekhabtajhiz.class);
                startActivity(myintent);

            }

        });
    ///////////////////////////////////////////////Tasfiyekhaneh
    Button btn_tasfiyekhaneh=(Button)findViewById(R.id.btnEntakhabTasfiyehkhaneh);

    btn_tasfiyekhaneh.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent Tarahiintent=new Intent(MainActivity.this, Tarahitajhiznew.class);
            startActivity(Tarahiintent);
        }
    });
////////////////////////////////////////////////////////////////////

    }
}

