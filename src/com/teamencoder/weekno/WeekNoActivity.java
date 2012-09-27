package com.teamencoder.weekno;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class WeekNoActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Calendar cal = Calendar.getInstance();
        
        TextView currDate = (TextView)findViewById(R.id.txtdate);
        TextView weekNoVAR = (TextView) findViewById(R.id.weekNo);
                
        SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
        //System.out.println(date_format.format(cal.getTime()));
        
        currDate.setText("Today is " + date_format.format(cal.getTime()));
        weekNoVAR.setText(Integer.toString(cal.get(Calendar.WEEK_OF_YEAR)));

    }
}