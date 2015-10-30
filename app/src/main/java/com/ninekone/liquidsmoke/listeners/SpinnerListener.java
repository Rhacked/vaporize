package com.ninekone.liquidsmoke.listeners;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

/**
 * Created by Rubenhag on 16.10.2015.
 */
public class SpinnerListener implements AdapterView.OnItemSelectedListener {

    Spinner otherSpinner;

    public SpinnerListener(Spinner otherSpinner){
        this.otherSpinner = otherSpinner;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        otherSpinner.setSelection(10-position, true);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
