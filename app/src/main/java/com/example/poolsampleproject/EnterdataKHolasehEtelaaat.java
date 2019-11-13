package com.example.poolsampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.lang.Math.round;

public class EnterdataKHolasehEtelaaat extends AppCompatActivity {
    EditText ETkholasehMeghdar;
    TextView ETkholasehVahed, ETkholasehname;
    public double Velocity = 0;
    public double SurfacePool=0;
    public double JakooziVelocity = 0;
    int savedBUtton;
    ArrayList<Item> arrayItem;
    String[] PoolString = new String[8];
    String[] JakoosiString = new String[8];
    String[] SonaString = new String[8];
    String[] AbsardString = new String[8];
    String[] SakhtemanStirng = new String[8];
    String[] AllNumberString = {"4.7", "26.7", "29", "40", "10", "10", "1.5", "100", "150", "24", "60", "6", "25", "43", ///14
            "40", "1.96", "1.44", "11.8", "11", "3", ".5", "21.92", "13", "385", ".6", "3.6", "200200", "", "", "", "", ""};
    String[] finalAllString = new String[32];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterdata_kholaseh_etelaaat);


        ////////////////////////////////Casting
        Button btnSaveData = findViewById(R.id.btnSaveData);
        Button btnCalculate = findViewById(R.id.btnCalculate);

        final EditText EditTextEntranceWater = findViewById(R.id.EditTextEntranceWater);
        final EditText EditTextPoolWaterTemp = findViewById(R.id.EditTextPoolWaterTemp);
        final EditText EditTextDooshTemp = findViewById(R.id.EditTextDooshTemp);
        final EditText EditTextAmbientTemp = findViewById(R.id.EditTextAmbientTemp);
        final EditText EditTextPoolVelocity = findViewById(R.id.EditTextPoolVelocity);
        final EditText EditTextJDebyFilteration = findViewById(R.id.EditTextJDebyFilteration);
        final EditText EditTextJakooziTemperature = findViewById(R.id.EditTextJakooziTemperature);
        final EditText EditTextLittleRadius = findViewById(R.id.EditTextLittleRadius);
        final EditText EditTextPoolSurface = findViewById(R.id.EditTextPoolSurface);
        final EditText EditTextJakooziDebyFilteration = findViewById(R.id.EditTextJakooziDebyFilteration);
        final EditText EditTextJakooziVelocity = findViewById(R.id.EditTextJakooziVelocity);
        final EditText EditTextSurfaceOfSalon = findViewById(R.id.EditTextSurfaceOfSalon);
        final EditText EditTextEshbaShabnam = findViewById(R.id.EditTextEshbaShabnam);
        final EditText EditTextEshbaShabnamPool = findViewById(R.id.EditTextEshbaShabnamPool);
        //  EditText EditTextEntranceWater=findViewById(R.id.EditTextEntranceWater);


        ////////////////Restor Data
        SharedPreferences shared = getSharedPreferences("Prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();
        for (int x = 1; x < 7; x++) {
            String name = "stringPool_" + String.valueOf(x);
            String namejakoozi = "stringJakoozi_" + String.valueOf(x);
            String namesona = "stringSona_" + String.valueOf(x);
            String nameAbsard = "stringAbsard_" + String.valueOf(x);
            String nameSakhteman = "stringGarmaeeSakhteman_" + String.valueOf(x);

            PoolString[x] = shared.getString(name, "");
            JakoosiString[x] = shared.getString(namejakoozi, "");
            SonaString[x] = shared.getString(namesona, "");
            AbsardString[x] = shared.getString(nameAbsard, "");
            SakhtemanStirng[x] = shared.getString(nameSakhteman, "");


        }


        AllNumberString[9] = PoolString[1];///nerkh taviz ab estakhr
        AllNumberString[11] = PoolString[2];///nerkh taviz ab estakhr
        //    AllNumberString[6] = PoolString[4];

////م مقادید از صفحات را در استرینگگ وارد کنیم
        ////  PoolString[1]   ETPoolHourPreHeating
        ////  PoolString[2]  EtpoolChangWaterRate
        ////  PoolString[3]  PoolPositon 1 public private training childeran
        ////  PoolString[4]   ETpoolDeepAvarage
        ////  PoolString[5]stringPool_5 if nafar =1 agar 2 hajm
        ////  PoolString[6]   ETnumberOfPeople///// sath estakhr
        ////  PoolString[7]
        ////  PoolString[8]
        ///// entekhab hajm estakhr
// double Velocity=0;

///////////////jakooozi


        /// JakoosiString

        //  ETjakooziStartUpTime  1
        //ETjakooziChangWaterRate 2


        //ETjakooziNumberOfNozzel3
        //stringJakoozi_4  1 shoa,2 sathe jakoozi,3 tedada nafarat
        //stringJakoozi_5 meghdar ke gofte shode

//////////////////////////////////////absard

        // stringAbsard_1   ETabsardSurface
        //stringAbsard_2   ETabsardDeep

        ///stringAbsard_3  ETabsardStartUpingTime
        //stringAbsard_4   ETabsardChangingWater

//////////////////////////////////////////////////////sakhteman


        if (JakoosiString[4].equals("1")) {
            JakooziVelocity = round(
                    Double.parseDouble(JakoosiString[5]) * Double.parseDouble(JakoosiString[5]) * 3.14 * .6 +
                            (Double.parseDouble(JakoosiString[5]) - .5) *(Double.parseDouble(JakoosiString[5]) - .5) * 3.14 * .6);
        }


        if (JakoosiString[4].equals("2")) {
            JakooziVelocity = round(
                    Double.parseDouble(JakoosiString[5]) * .6);
        }

        if (JakoosiString[4].equals("3")) {
            JakooziVelocity = round(
                    Double.parseDouble(JakoosiString[5]) * .9 * .6);
        }


        int intJakooziVelocity = (int) JakooziVelocity;
        final String strJakooziVelocity = Integer.toString(intJakooziVelocity);


//////////////////////////////////////////////////////////

        if (PoolString[5].equals("1")) {
            SurfacePool=Double.parseDouble(PoolString[6])*2.32;

            Velocity = round(Double.parseDouble(PoolString[6]) *
                    Double.parseDouble(PoolString[4]) *
                    2.32);
        }


        if (PoolString[5].equals("2")) {
            Velocity = round(Double.parseDouble(PoolString[6]) *
                    Double.parseDouble(PoolString[4]));
            SurfacePool=Double.parseDouble(PoolString[6]);
        }
        int intVelocity = (int) Velocity;
        final String strVelocity = Integer.toString(intVelocity);

        AllNumberString[7]=Integer.toString((int) SurfacePool);////masahat  sath estakhr
        // AllNumberString[0] =PoolString[0];
        //  AllNumberString[1] =PoolString[0];
        //   AllNumberString[2] = PoolString[0];
        //  AllNumberString[3] = PoolString[0];
        //  AllNumberString[4] = PoolString[0];
        // AllNumberString[5] = PoolString[0];
        // AllNumberString[6] = PoolString[0];
        //  AllNumberString[7] = PoolString[0];
        AllNumberString[8] = strVelocity;
        // AllNumberString[9] = PoolString[0];
        //   AllNumberString[10] = PoolString[0];
        //AllNumberString[11] = PoolString[0];
        AllNumberString[12] = Integer.toString(((int) round((Double.parseDouble(AllNumberString[8]) /             ////deby
                Double.parseDouble(AllNumberString[11])))));
        // AllNumberString[13] = PoolString[0]; nafar estakhr
        /////jakoozi
        // AllNumberString[14] = JakoosiString[0];
        AllNumberString[15] = JakoosiString[5];
        AllNumberString[16] = JakoosiString[0];
        // AllNumberString[17] = JakoosiString[0];
        AllNumberString[18] = strJakooziVelocity;
        AllNumberString[19] = JakoosiString[1];
        AllNumberString[20] = JakoosiString[2];


        AllNumberString[21] = Integer.toString(((int) round((Double.parseDouble(AllNumberString[18]) /             ////deby
                Double.parseDouble(AllNumberString[20])))));


        //   AllNumberString[22] = JakoosiString[0];
        //   AllNumberString[23] = JakoosiString[0];
        //   AllNumberString[24] = JakoosiString[0];
        //   AllNumberString[25] = JakoosiString[0];
        AllNumberString[26] = SakhtemanStirng[1];
        AllNumberString[27] = AbsardString[1];   // stringAbsard_1   ETabsardSurface
        AllNumberString[28] = AbsardString[2];   //stringAbsard_2   ETabsardDeep
        AllNumberString[29] = AbsardString[3];     ///stringAbsard_3  ETabsardStartUpingTime
        AllNumberString[29] = AbsardString[4];   //stringAbsard_4   ETabsardChangingWater
/////////////////////////////////////////////////////////////////////////////
        if (savedBUtton == 1) {
            AllNumberString = finalAllString;
        }
        EditTextEntranceWater.setText(AllNumberString[0]);
        EditTextPoolWaterTemp.setText(AllNumberString[1]);
        EditTextDooshTemp.setText(AllNumberString[2]);
        EditTextAmbientTemp.setText(AllNumberString[3]);
        EditTextPoolVelocity.setText(strVelocity);
        EditTextJDebyFilteration.setText(AllNumberString[12]);
        EditTextJakooziTemperature.setText(AllNumberString[14]); ///vared kona ba formool m
        EditTextLittleRadius.setText(AllNumberString[16]);////vared konam
        EditTextPoolSurface.setText(AllNumberString[17]);
        EditTextJakooziDebyFilteration.setText(AllNumberString[21]);
        EditTextJakooziVelocity.setText(AllNumberString[18]);
        EditTextSurfaceOfSalon.setText(AllNumberString[23]);
        EditTextEshbaShabnam.setText(AllNumberString[24]);
        EditTextEshbaShabnamPool.setText(AllNumberString[25]);


//////////////////////////////////////////////////////////////////////////////////

        Log.d(Integer.toString(savedBUtton), "amount of savedmessage");


        btnSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ////change final data from this chart
                AllNumberString[0] = EditTextEntranceWater.getText().toString();
                AllNumberString[1] = EditTextPoolWaterTemp.getText().toString();
                AllNumberString[2] = EditTextDooshTemp.getText().toString();
                AllNumberString[3] = EditTextAmbientTemp.getText().toString();
                AllNumberString[8] = strVelocity;// EditTextPoolVelocity.getText().toString();
                AllNumberString[12] = EditTextJDebyFilteration.getText().toString();
                AllNumberString[14] = EditTextJakooziTemperature.getText().toString();///vared kona ba formool m
                AllNumberString[16] = EditTextLittleRadius.getText().toString();////vared konam
                AllNumberString[17] = EditTextPoolSurface.getText().toString();
                AllNumberString[21] = EditTextJakooziDebyFilteration.getText().toString();
                AllNumberString[18] = EditTextJakooziVelocity.getText().toString();
                AllNumberString[23] = EditTextSurfaceOfSalon.getText().toString();
                AllNumberString[24] = EditTextEshbaShabnam.getText().toString();
                AllNumberString[25] = EditTextEshbaShabnamPool.getText().toString();
                //AllNumberString[9] = EditTextEntranceWater.getText().toString();
                // AllNumberString[9] = EditTextEntranceWater.getText().toString();
                finalAllString = AllNumberString;
                savedBUtton = 1;
                //    SharedPreferences shared = getSharedPreferences("Prefs", MODE_PRIVATE);
                //  SharedPreferences.Editor editor = shared.edit();
                // editor.putInt("savedBUtton","0");
                // editor.apply();
              Toast.makeText(EnterdataKHolasehEtelaaat.this, AllNumberString[15] + "///0000///" + AllNumberString[5]+"////"+AllNumberString[6], Toast.LENGTH_LONG).show();
            }
        });

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /* double qTabkhirSathi = 0;
                double qPishGarmayeshEstakhr = 0;
                double qDooshDasshoooee = 0;
                double qGarmayeshHavayeEstakhr = 0;
                double qBarGarmaeeJakoozi = 0;
                double qTotalBarHarartiEstakhrJakoozi = 0;
                double AmbientAirEstakhr = 0;
                ////////////////////////////////////////////////////////////////////////

                double q1EtlafKafSaghfDivar = 0;
                double q2PishGarmayeshEstakhrRahandazi = 0;
                double q3BarGarmaeeEstakhrHmamDoosh = 0;
                double q4BarGarmayeshiSalon=0;
                double q5BarGarmayeshiJakoozi=0;
                double qTotal=0;
                /*/
                double q1EstakhrSathi=0;
                double q2PishRahandazi=0;
                double qTotalEstakhr=0;
                double q1JakooziSathi=0;
                double q2JakooziRahandzi=0;
                double qTotalJakoozi=0;
                double qTOtalsakhteman=0;
                double qSigma;
                double farenhitedegree=0;
                
              

                //////////////////////////////////////////////////////////////////////////
////                D17 tetad nafarat estakhr
                /////////q1EtlafKafSaghfDivar= F11*105*0.3+D17*300
                farenhitedegree=farenhait(AllNumberString[1])-farenhait(AllNumberString[0]);
                q1EstakhrSathi=10.5*10.76*SurfacePool* (farenhait(AllNumberString[1])-farenhait(AllNumberString[2]) )  *.75;
                q2PishRahandazi=8.33*galon(Velocity)*(farenhait(AllNumberString[1])-farenhait(AllNumberString[0]) )/(Double.parseDouble(AllNumberString[9]));
                qTotalEstakhr=q1EstakhrSathi+q2PishRahandazi;
                //////jakoozi system mohasebat
                double surfaceJakoozi=Double.parseDouble(JakoosiString[5])*Double.parseDouble(JakoosiString[5])*3.14;


                q1JakooziSathi=10.5*10.76*surfaceJakoozi* (farenhait(AllNumberString[14])-farenhait(AllNumberString[2]) )  *.75;
                        ////10.5*f23*(N36-F5)*0.75;
                q2JakooziRahandzi=8.33*galon(JakooziVelocity)*(farenhait(AllNumberString[14])-farenhait(AllNumberString[0]) )/(Double.parseDouble(AllNumberString[19]));
                        //8.33*F24*(F20-F4)/D2
                qTotalJakoozi=q1JakooziSathi+q2JakooziRahandzi;
                qTOtalsakhteman=Double.parseDouble(AllNumberString[19]);
                qSigma=qTotalEstakhr+qTotalJakoozi+qTOtalsakhteman;
                        Toast.makeText(EnterdataKHolasehEtelaaat.this, AllNumberString[19] + "qSigma"+Double.toString(qSigma),
                      Toast.LENGTH_LONG).show();

               // Toast.makeText(EnterdataKHolasehEtelaaat.this, "in progress"+AllNumberString[1], Toast.LENGTH_LONG).show()C;

            }

            private double galon(double v) {//////////////////////american
                return round(v*264.17205236);
            }

            private String Convertstring(double surfacePool) {
              String str=  Integer.toString((int)(round(surfacePool)));
              return  str;
            }

            private double farenhait(String s) {
               double degree= Double.parseDouble(s);
               return round(1.8*degree+32);

            }
        });
    }


}

