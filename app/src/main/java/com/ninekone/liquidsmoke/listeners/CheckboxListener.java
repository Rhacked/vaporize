package com.ninekone.liquidsmoke.listeners;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;

import com.ninekone.liquidsmoke.R;

/**
 * Created by Rubenhag on 19.10.2015.
 */
public class CheckboxListener implements CheckBox.OnCheckedChangeListener {

    RelativeLayout hiddenLayout;
    RelativeLayout layoutBelow;
    RelativeLayout layoutAbove;

    public CheckboxListener(RelativeLayout hiddenLayout, RelativeLayout layoutBelow, RelativeLayout layoutAbove){
        this.hiddenLayout = hiddenLayout;
        this.layoutBelow = layoutBelow;
        this.layoutAbove = layoutAbove;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(!isChecked){
            hiddenLayout.setVisibility(View.VISIBLE);
            if(layoutBelow!=null){
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) layoutBelow.getLayoutParams();
                params.addRule(RelativeLayout.BELOW, hiddenLayout.getId());
                layoutBelow.setLayoutParams(params);
            } else if(layoutAbove!=null){
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) hiddenLayout.getLayoutParams();
                params.addRule(RelativeLayout.BELOW, layoutAbove.getId());
                hiddenLayout.setLayoutParams(params);
            }
        } else {
            hiddenLayout.setVisibility(View.INVISIBLE);
            if(layoutBelow!=null && layoutAbove!=null){
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) layoutBelow.getLayoutParams();
                params.addRule(RelativeLayout.BELOW, layoutAbove.getId());
                layoutBelow.setLayoutParams(params);
            } else if(layoutAbove!=null){
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) hiddenLayout.getLayoutParams();
                params.addRule(RelativeLayout.BELOW, layoutAbove.getId());
                hiddenLayout.setLayoutParams(params);
            }
        }
    }
}
