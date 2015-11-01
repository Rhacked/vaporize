package com.ninekone.liquidsmoke.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.ninekone.liquidsmoke.R;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        double nico = intent.getDoubleExtra("nico", 0.0);
        double pg = intent.getDoubleExtra("pg", 0.0);
        double vg = intent.getDoubleExtra("vg", 0.0);
        double wvp = intent.getDoubleExtra("wvp", 0.0);
        double flav1 = intent.getDoubleExtra("flav1", 0.0);
        double flav2 = intent.getDoubleExtra("flav2", 0.0);

        TextView nicores = (TextView)findViewById(R.id.nico_result);
        TextView pgres = (TextView)findViewById(R.id.pg_result);
        TextView vgres = (TextView)findViewById(R.id.vg_result);
        TextView wvpres = (TextView)findViewById(R.id.wvp_result);
        TextView flav1res = (TextView)findViewById(R.id.flav1_result);
        TextView flav2res = (TextView)findViewById(R.id.flav2_result);

        nicores.setText(String.valueOf(nico));
        pgres.setText(String.valueOf(pg));
        vgres.setText(String.valueOf(vg));
        wvpres.setText(String.valueOf(wvp));
        flav1res.setText(String.valueOf(flav1));
        flav2res.setText(String.valueOf(flav2));

    }

}
