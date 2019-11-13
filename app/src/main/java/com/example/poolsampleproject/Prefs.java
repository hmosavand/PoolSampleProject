package com.example.poolsampleproject;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

public class Prefs extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String [] all_poolstrings = new String [7];
        String[] all_jakooziString=new String[7];
        String[] all_SonaString=new String[7];
        String[] all_AbsardString=new String[7];
        String[] all_GarmaeeSakhtemanString=new String[7];



        Boolean [] all_Poolbooleans = new Boolean [7];

        for(int x = 1; x < 7; x++){
            String name = "stringPool_" + String.valueOf(x);
            String nameJakoozi = "stringJakoozi_" + String.valueOf(x);
            String nameSona = "stringSona_" + String.valueOf(x);
            String nameAbsard="stringAbsard_"+String.valueOf(x);

            String nameGarmaeeSakhtemnaString="stringGarmaeeSakhteman_"+String.valueOf(x);



            all_poolstrings [x] = prefs.getString(name, "");
            all_jakooziString[x]=prefs.getString(nameJakoozi,"");
            all_SonaString[x]=prefs.getString(nameSona,"");
            all_AbsardString[x]=prefs.getString(nameAbsard,"");
            all_GarmaeeSakhtemanString[x]=prefs.getString(nameGarmaeeSakhtemnaString,"");

            String boolPooolname = "boolean_" + String.valueOf(x);
            all_Poolbooleans [x] = prefs.getBoolean(boolPooolname, false);



        }
    }
}



