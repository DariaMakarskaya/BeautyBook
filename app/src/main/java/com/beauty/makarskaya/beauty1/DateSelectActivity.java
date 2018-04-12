package com.beauty.makarskaya.beauty1;


import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by admin on 14.12.17.
 */

public class DateSelectActivity extends AppCompatActivity{

    public int year;
    int month;
    int day;
    int hour;
    int minute;

    TimePicker timePicker1;
    DatePicker datePicker1;
    Calendar today;
    TextView textView1;
    TextView textView2;

    @Override
    protected void onStart() {
        super.onStart();

        today = Calendar.getInstance();
        timePicker1=(TimePicker)findViewById(R.id.timePicker1);
        datePicker1 = (DatePicker)findViewById(R.id.datePicker1);
        textView1 = (TextView) findViewById(R.id.dateView);
        textView2 = (TextView)findViewById(R.id.timeView);
        Calendar now = Calendar.getInstance();
        timePicker1.setCurrentHour(now.get(Calendar.HOUR_OF_DAY));
        timePicker1.setCurrentMinute(now.get(Calendar.MINUTE));
        datePicker1.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker1, int i, int i1, int i2) {
                datePicker1.init(i,i1,i2,null);
                year = i;
                month = i1+1;
                day = i2;
                textView1.setText("выбранная дата: "+year+" "+month+" "+day);
                onStart();
                Intent intent1 = new Intent(DateSelectActivity.this,dateselected.class);
                intent1.putExtra("year",year);
                intent1.putExtra("month",month);
                intent1.putExtra("day",day);
          //      startActivity(intent1);
                timePicker1.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                    @Override
                    public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                        hour = i;
                        minute = i1;
                        textView2.setText("выбранное время: "+i+" "+i1);
                    }
                });
            }
        });

    }

    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datepick_act);

        }


}
