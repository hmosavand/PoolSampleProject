package com.example.poolsampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static java.lang.Math.round;

public class EnterdataBarSakhteman extends AppCompatActivity {
    EditText ETsakhtemnatotalBuildingEnergy,
            ETsakhtemanVahedMasraf,
            ETsakhtemanSurface;
    RadioButton RBsakhtemanTOtal,RBsakhtemnaMetri;
    LinearLayout Linearlayeremain;
    RadioGroup RGsakhteman;
    Button btnSakhtemnaSave;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterdata_bar_sakhteman);
        ETsakhtemnatotalBuildingEnergy=findViewById(R.id.ETsakhtemnatotalBuildingEnergy);
        ETsakhtemanVahedMasraf=findViewById(R.id.ETsakhtemanVahedMasraf);
        ETsakhtemanSurface=findViewById(R.id.ETsakhtemanSurface);
        RBsakhtemanTOtal=findViewById(R.id.RBsakhtemanTOtal);
        RGsakhteman=findViewById(R.id.RGsakhteman);
        RBsakhtemnaMetri=findViewById(R.id.RBsakhtemnaMetri);

        btnSakhtemnaSave=findViewById(R.id.btnSakhtemnaSave);



        RGsakhteman.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(RBsakhtemanTOtal.isChecked()){
                    ETsakhtemnatotalBuildingEnergy.setEnabled(true);
                    ETsakhtemanVahedMasraf.setEnabled(false);
                    ETsakhtemanSurface.setEnabled(false);
                }
                else{
                    ETsakhtemnatotalBuildingEnergy.setEnabled(false);
                    ETsakhtemanVahedMasraf.setEnabled(true);
                    ETsakhtemanSurface.setEnabled(true);


                }
            }
        });





        btnSakhtemnaSave.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences shared = getSharedPreferences("Prefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = shared.edit();
              if (ETsakhtemnatotalBuildingEnergy.isEnabled()) {

                    editor.putString("stringGarmaeeSakhteman_1", ETsakhtemnatotalBuildingEnergy.getText().toString());
                    editor.putString("stringGarmaeeSakhteman_2", "1");
                    editor.putString("stringGarmaeeSakhteman_3", "1");
                }
                else {

                  Integer.toString     (((int) round((Double.parseDouble(ETsakhtemanVahedMasraf.getText().toString())*             ////deby
                          Double.parseDouble(ETsakhtemanSurface.getText().toString())))));
                                      editor.putString("stringGarmaeeSakhteman_1", ETsakhtemnatotalBuildingEnergy.getText().toString());
                  editor.putString("stringGarmaeeSakhteman_2", "1");
                  editor.putString("stringGarmaeeSakhteman_3", "1");




              }
                editor.apply();
                Toast.makeText(EnterdataBarSakhteman.this,  "  Sakhteman besaved", Toast.LENGTH_LONG).show();
                finish();





            }
        });




    }
}
