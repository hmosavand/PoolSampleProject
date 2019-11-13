package com.example.poolsampleproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Item> mItem;

    public CustomAdapter(Context mContext, ArrayList<Item> mItem) {
        this.mContext = mContext;
        this.mItem = mItem;



    }





    @Override
    public int getCount() {
        return mItem.size();
    }

    @Override
    public Object getItem(int i) {
        return mItem.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }




    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.list_item, viewGroup, false);
        }
        final View view1;
        view1= LayoutInflater.from(mContext).inflate(R.layout.activity_enterdata_kholaseh_etelaaat, viewGroup, false);

        final Item currentItem = (Item) getItem(i);
String str;
//str=In(i);

        TextView txtDataName = view.findViewById(R.id.enter_data_name);
        TextView txtItemUnit= view.findViewById(R.id.unit_dataname);
        EditText ETdataValue = view.findViewById(R.id.ETdataValue);
       // EditText ETkholASEH=(EditText)view1.findViewById(R.id.ETkholasehMeghdar) ;


        txtDataName.setText(currentItem.getTxtDataName());
        txtItemUnit.setText(currentItem.getTxtDataUnite());
        ETdataValue.setText(currentItem.getEditTxtValue());
       // ETkholASEH.setText(currentItem.getEditTxtValue());




        return view;



    }
}
