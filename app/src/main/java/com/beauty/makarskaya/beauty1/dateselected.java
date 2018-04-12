package com.beauty.makarskaya.beauty1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by admin on 11.02.2018.
 */
////test
public class dateselected extends AppCompatActivity{
    TextView tv1;
    int year1, month1,day1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testact);
        tv1 = (TextView)findViewById(R.id.textView1);
        Intent intent = getIntent();

        int year = intent.getIntExtra("year",year1);
        int month = intent.getIntExtra("month",month1);
        int day = intent.getIntExtra("day",day1);

        tv1.setText("Выбранная дата: "+ year + " " + month + " "+ day);
    }
}
