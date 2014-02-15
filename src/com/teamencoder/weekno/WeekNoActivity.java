package com.teamencoder.weekno;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Shuvankar
 *
 */
public class WeekNoActivity extends Activity {
	private static final int DATE_PICKER_ID = 123;
	private TextView currDate;
	private TextView weekNoVAR;
	private int year;
	private int month;
	private int day;
	
    /** 
     * Called when the activity is first created. 
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        Calendar cal = Calendar.getInstance();
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH);
		day = cal.get(Calendar.DAY_OF_MONTH);
        
        currDate = (TextView)findViewById(R.id.txtdate);
        weekNoVAR = (TextView) findViewById(R.id.weekNo);
                
        SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
        //System.out.println(date_format.format(cal.getTime()));
        
        currDate.setText("Today is " + date_format.format(cal.getTime()));
        //weekNoVAR.setText(Integer.toString(cal.get(Calendar.WEEK_OF_YEAR)));
        weekNoVAR.setText(getWeekFromDate(cal));
        
        //Add Button Listener
        addListenerOnButton();

    }
    
    /**
     * Show current week no on First application launch
     */
    public void currentDateOnView() {
    	//Copy the current data showing code from main to here
		
	}
    
    /**
     * Find week from date
     */
    public String getWeekFromDate(Calendar cal) {
    	return Integer.toString(cal.get(Calendar.WEEK_OF_YEAR));
    }
    
    /**
     * Get Calendar object from day month and year
     */
    public static Calendar getCalendar(int day, int month, int year){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        return cal;
    }
    
    /**
     * Listner on button click.
     */
    public void addListenerOnButton() {
    	Button btnChangeDate = (Button)findViewById(R.id.btnChangeDate);
    	
    	btnChangeDate.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// On button click show datepicker dialog 
                showDialog(DATE_PICKER_ID);
                //Toast toast = Toast.makeText(getApplicationContext(), "Button clicked", Toast.LENGTH_LONG);
		    	//toast.show();
				
			}
		});
    	
    }
    
    @Override
    protected Dialog onCreateDialog(int id) {
    	
        switch (id) {
        case DATE_PICKER_ID:
        	
            // Open datepicker dialog. 
            // Set date picker for current date 
            // Add pickerListener listner to date picker
            return new DatePickerDialog(this, datePickerListener, year, month,day);
        }
        return null;
    }
    
    /**
     * Datepicker listener
     */
    private DatePickerDialog.OnDateSetListener datePickerListener
    	= new DatePickerDialog.OnDateSetListener() {
			
			public void onDateSet(DatePicker view, int year, int month,
					int day) {
				
				currDate.setText("Date: " + day + "/" + (month + 1) +"/" + year);
				weekNoVAR.setText(getWeekFromDate(getCalendar(day, month, year)));
				
			}
		};
}