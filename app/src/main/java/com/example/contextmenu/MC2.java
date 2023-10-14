package com.example.contextmenu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
public class MC2 extends AppCompatActivity implements AdapterView.OnItemLongClickListener {
    TextView TV2;
    ListView LV;
    Double first;
    Double [] arr = new Double[20];
    AlertDialog.Builder adb;
    Double sum = 0.0;
     int pos=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mc2);
        TV2 = findViewById(R.id.textView);
        LV = findViewById(R.id.ListV);

        Intent Fi = getIntent();
        int Mog =Fi.getIntExtra("Mog",1);
        first = Fi.getDoubleExtra("FirstNum",2);
        Double MoA = Fi.getDoubleExtra("MoA",3);
        arr[0]= first;


        for (int i=1;i<20;i++){
            if (Mog==1){
                arr[i]=arr[i-1]*MoA;
            }else {
                arr[i]=arr[i-1]+MoA;
            }
        }
        LV.setOnItemLongClickListener(this);

        ArrayAdapter adp = new ArrayAdapter(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,arr);
        LV.setAdapter(adp);

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        pos = position+1;
        adb = new AlertDialog.Builder(this);
        adb.setTitle("choose");
        adb.setMessage("choose one of the options");
        adb.setPositiveButton("position", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                TV2.setText(""+pos);
            }
        });
        adb.setNegativeButton("sum", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                sum = 0.0;
                for (int g = 0;g<position;g++){
                    sum = (Double) (sum+arr[g]);
                }
                TV2.setText(""+sum);
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
        return false;
    }
}