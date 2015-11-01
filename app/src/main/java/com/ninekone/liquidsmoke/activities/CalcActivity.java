package com.ninekone.liquidsmoke.activities;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.ninekone.liquidsmoke.R;
import com.ninekone.liquidsmoke.calculator.Calculator;
import com.ninekone.liquidsmoke.listeners.CheckboxListener;
import com.ninekone.liquidsmoke.listeners.SpinnerListener;

import java.util.ArrayList;

public class CalcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initSpinners();
        initCheckboxes();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calc, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void initCheckboxes(){
        CheckBox flav1Checkbox = (CheckBox)findViewById(R.id.flav1_zero_pgvg_check);


    }


    public void initSpinners(){

        Spinner pg = (Spinner)findViewById(R.id.PG_value);
        Spinner vg = (Spinner)findViewById(R.id.VG_value);
        Spinner pgJuice = (Spinner)findViewById(R.id.juice_PG_value);
        Spinner vgJuice = (Spinner)findViewById(R.id.juice_VG_value);
        Spinner flav1pg = (Spinner)findViewById(R.id.flav1_pg_value);
        Spinner flav1vg = (Spinner)findViewById(R.id.flav1_vg_value);


        /**
         * Add adapter to all spinners
         */
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.percentages, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        pg.setAdapter(spinnerAdapter);
        vg.setAdapter(spinnerAdapter);
        pgJuice.setAdapter(spinnerAdapter);
        vgJuice.setAdapter(spinnerAdapter);
        flav1pg.setAdapter(spinnerAdapter);
        flav1vg.setAdapter(spinnerAdapter);

        /**
         * Add OnItemSelectedListener to all spinners
         */

        pg.setOnItemSelectedListener(new SpinnerListener(vg));
        vg.setOnItemSelectedListener(new SpinnerListener(pg));
        pgJuice.setOnItemSelectedListener(new SpinnerListener(vgJuice));
        vgJuice.setOnItemSelectedListener(new SpinnerListener(pgJuice));
        flav1pg.setOnItemSelectedListener(new SpinnerListener(flav1vg));
        flav1vg.setOnItemSelectedListener(new SpinnerListener(flav1pg));

        /**
         * Set initial selection to 50/50
         */

        pg.setSelection(5);
        pgJuice.setSelection(5);
        flav1pg.setSelection(10);
    }

    public void calculate(View v){
        CheckBox flav1Check = (CheckBox)findViewById(R.id.flav1_zero_pgvg_check);

        int amountInt = 0;
        int tarStrengthInt = 0;
        int tarPG = 0;
        int tarVG = 0;
        int strengthEJuice = 0;
        int eJuicePG = 0;
        int eJuiceVG = 0;
        int wvp = 0;
        int flav1 = 0;
        int flav2 = 0;
        int flav1PG = 0;
        int flav1VG = 0;
        int flav2PG = 0;
        int flav2VG = 0;

        try {
            amountInt = Integer.parseInt(((EditText) findViewById(R.id.amount_value)).getText().toString());
            Log.d("amount", "Amount: "+amountInt);
        } catch (NumberFormatException e){
            Log.e("Calculate", "Amount: "+e.getMessage());
        }

        try{
            tarStrengthInt = Integer.parseInt(((EditText) findViewById(R.id.nico_value)).getText().toString());
            Log.d("Calculate", "Target Nicotine Strength: "+tarStrengthInt);
        } catch (NumberFormatException e){
            Log.e("Calculate", "Target Nicotine Strength: "+e.getMessage());
        }

        try{
            tarPG = Integer.parseInt(((Spinner) findViewById(R.id.PG_value)).getSelectedItem().toString());
            Log.d("Calculate", "Target PG: "+tarPG);
        } catch (NumberFormatException e){

        }

        try{
            tarVG = Integer.parseInt(((Spinner) findViewById(R.id.VG_value)).getSelectedItem().toString());
            Log.d("Calculate", "Target VG: "+tarVG);
        } catch (NumberFormatException e){

        }

        try{
            strengthEJuice = Integer.parseInt(((EditText) findViewById(R.id.nico_strength_value)).getText().toString());
            Log.d("Calculate", "E-Juice Nicotine Strength: "+strengthEJuice);
        } catch (NumberFormatException e){
            Log.e("Calculate", "E-Juice Nicotine Strength: "+e.getMessage());
        }

        try{
            eJuicePG = Integer.parseInt(((Spinner) findViewById(R.id.juice_PG_value)).getSelectedItem().toString());
            Log.d("Calculate", "E-Juice PG: "+eJuicePG);
        } catch (NumberFormatException e){

        }

        try{
            eJuiceVG = Integer.parseInt(((Spinner) findViewById(R.id.juice_VG_value)).getSelectedItem().toString());
            Log.d("Calculate", "E-Juice VG: "+eJuiceVG);
        } catch (NumberFormatException e){

        }

        try{
            wvp = Integer.parseInt(((EditText) findViewById(R.id.wvp_value)).getText().toString());
            Log.d("Calculate", "Water/Vodka/PGA: "+wvp);
        } catch (NumberFormatException e){
            Log.e("Calculate", "Water/Vodka/PGA: "+e.getMessage());
        }

        try{
            flav1 = Integer.parseInt(((EditText)findViewById(R.id.flav1_value)).getText().toString());
            Log.d("Calculate", "Flavor1 %: "+flav1);
        } catch (NumberFormatException e){

        }



        if(!flav1Check.isChecked()){
            try{
                flav1PG = Integer.parseInt(((Spinner)findViewById(R.id.flav1_pg_value)).getSelectedItem().toString());
                Log.d("Calculate", "Flavor1 PG: "+flav1PG);
            } catch (NumberFormatException e){

            }

            try{
                flav1VG = Integer.parseInt(((Spinner)findViewById(R.id.flav1_vg_value)).getSelectedItem().toString());
                Log.d("Calculate", "Flavor1 VG: "+flav1VG);
            } catch (NumberFormatException e){

            }
        }
        


        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("nico", Calculator.getNico(amountInt, tarStrengthInt, strengthEJuice));
        intent.putExtra("pg", Calculator.getPG(amountInt, tarStrengthInt, tarPG, strengthEJuice, eJuicePG, flav1, flav1PG, flav2, flav2PG, Calculator.getMili(amountInt, wvp)));
        intent.putExtra("vg", Calculator.getVG(amountInt, tarStrengthInt, tarVG, strengthEJuice, eJuiceVG, flav1, flav1VG, flav2, flav2VG, Calculator.getMili(amountInt, wvp)));
        intent.putExtra("wvp", Calculator.getMili(amountInt, wvp));
        intent.putExtra("flav1", Calculator.getMili(amountInt, flav1));
        intent.putExtra("flav2", Calculator.getMili(amountInt, flav2));
        startActivity(intent);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void addFlavor(View view){
        RelativeLayout flavorTemplate = (RelativeLayout)findViewById(R.id.flavor_template);
        flavorTemplate.setId(View.generateViewId());
        Log.d("FlavorTemp", "Count children: "+flavorTemplate.getChildCount());
        LinearLayout inputLayout = (LinearLayout)findViewById(R.id.input);
        inputLayout.addView(flavorTemplate);


    }
}
