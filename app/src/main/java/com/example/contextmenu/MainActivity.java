package com.example.contextmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner S;
    Button B;
    EditText ET1;
    EditText ET2;
    String [] choose= {"mathmatical","geometric"};
    int pos1=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        S = findViewById(R.id.spinner);
        ET1 = findViewById(R.id.editTextNumberDecimal1);
        ET2 = findViewById(R.id.editTextNumberDecimal2);


        S.setOnItemSelectedListener(this);

        ArrayAdapter adp = new ArrayAdapter(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,choose);
        S.setAdapter(adp);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        pos1 = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void btn(View view) {
        try{
            String st1 = ET1.getText().toString();
            String st2 = ET2.getText().toString();
            Double ans1 = Double.parseDouble(st1);
            Double ans2 = Double.parseDouble(st2);
            Intent Si = new Intent(this, MC2.class);
            Si.putExtra("FirstNum",ans1);
            Si.putExtra("MoA",ans2);
            Si.putExtra("Mog",pos1);
            startActivity(Si);
        }catch (Exception e){
            Toast.makeText(this, "that isnt a number, please try again", Toast.LENGTH_SHORT).show();
        }
    }
}