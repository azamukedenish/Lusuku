package com.example.bifam.lusuku;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

public class SpinnerHandler implements OnItemSelectedListener {
    private boolean isFirst = true;

    @Override
    public void onItemSelected(AdapterView<?> spinner, View selectedView,
                               int selectedIndex, long id) {
        // TODO Auto-generated method stub
        if (isFirst) {
            isFirst = false;
        } else {
            String selection =
                    spinner.getItemAtPosition(selectedIndex).toString();
            //String message =
            //String.format(mItemSelectedMessageTemplate, selection);
        }

    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }
}

