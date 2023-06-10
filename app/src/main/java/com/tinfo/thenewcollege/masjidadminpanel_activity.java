package com.tinfo.thenewcollege;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class masjidadminpanel_activity extends AppCompatActivity {
        private EditText etdate1picker;
        private TextView etfajrpicker,etzuhrpicker,etasarpicker,etmaghribpicker,etishapicker,etjummahpicker,etjummah2picker;
        private int t1Hour,t1Minute,t2Hour,t2Minute,t3Hour,t3Minute,t4Hour,t4Minute,t5Hour,t5Minute,t6Hour,t6Minute,t7Hour,t7Minute;
        private Button Apply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_masjidadminpanel);

        getWindow().setStatusBarColor(Color.parseColor("#EEDBDB"));
        etdate1picker =(EditText) findViewById(R.id.etdate1);
        etfajrpicker =(TextView) findViewById(R.id.tvfajrtime);
        etzuhrpicker =(TextView) findViewById(R.id.tvzuhrtime);
        etasarpicker =(TextView) findViewById(R.id.tvasartime);
        etmaghribpicker =(TextView) findViewById(R.id.tvmaghribtime);
        etishapicker =(TextView) findViewById(R.id.tvishatime);
        etjummahpicker =(TextView) findViewById(R.id.tvjummahtime);
        etjummah2picker=(TextView)findViewById(R.id.tvjummahtime2);
        Apply=(Button) findViewById(R.id.buttonmapply);




        Calendar calender = Calendar.getInstance();
        final int year =calender.get(Calendar.YEAR);
        final int month =calender.get(Calendar.MONTH);
        final int day =calender.get(Calendar.DAY_OF_MONTH);


        etfajrpicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        masjidadminpanel_activity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int hourofDay, int minute) {
                                t1Hour = hourofDay;
                                t1Minute = minute;
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(0,0,0,t1Hour,t1Minute);
                                etfajrpicker.setText(DateFormat.format("hh:mm aa",calendar));

                            }
                        },12,0,false
                );

                timePickerDialog.updateTime(t1Hour,t1Minute);

                timePickerDialog.show();

            }


            ;
        });

        etzuhrpicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        masjidadminpanel_activity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int hourofDay, int minute) {
                                t2Hour = hourofDay;
                                t2Minute = minute;
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(0,0,0,t2Hour,t2Minute);
                                etzuhrpicker.setText(DateFormat.format("hh:mm aa",calendar));

                            }
                        },12,0,false
                );

                timePickerDialog.updateTime(t2Hour,t2Minute);

                timePickerDialog.show();

            }


            ;
        });


        etasarpicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        masjidadminpanel_activity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int hourofDay, int minute) {
                                t3Hour = hourofDay;
                                t3Minute = minute;
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(0,0,0,t3Hour,t3Minute);
                                etasarpicker.setText(DateFormat.format("hh:mm aa",calendar));

                            }
                        },12,0,false
                );

                timePickerDialog.updateTime(t3Hour,t3Minute);

                timePickerDialog.show();

            }


            ;
        });

        etmaghribpicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        masjidadminpanel_activity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int hourofDay, int minute) {
                                t4Hour = hourofDay;
                                t4Minute = minute;
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(0,0,0,t4Hour,t4Minute);
                                etmaghribpicker.setText(DateFormat.format("hh:mm aa",calendar));

                            }
                        },12,0,false
                );

                timePickerDialog.updateTime(t4Hour,t4Minute);

                timePickerDialog.show();

            }


            ;
        });

        etishapicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        masjidadminpanel_activity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int hourofDay, int minute) {
                                t5Hour = hourofDay;
                                t5Minute = minute;
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(0,0,0,t5Hour,t5Minute);
                                etishapicker.setText(DateFormat.format("hh:mm aa",calendar));

                            }
                        },12,0,false
                );

                timePickerDialog.updateTime(t5Hour,t5Minute);

                timePickerDialog.show();

            }


            ;
        });

        etjummahpicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        masjidadminpanel_activity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int hourofDay, int minute) {
                                t6Hour = hourofDay;
                                t6Minute = minute;
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(0,0,0,t6Hour,t6Minute);
                                etjummahpicker.setText(DateFormat.format("hh:mm aa",calendar));

                            }
                        },12,0,false
                );

                timePickerDialog.updateTime(t6Hour,t6Minute);

                timePickerDialog.show();

            }


            ;
        });



        etjummah2picker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        masjidadminpanel_activity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int hourofDay, int minute) {
                                t7Hour = hourofDay;
                                t7Minute = minute;
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(0,0,0,t7Hour,t7Minute);
                                etjummah2picker.setText(DateFormat.format("hh:mm aa",calendar));

                            }
                        },12,0,false
                );

                timePickerDialog.updateTime(t7Hour,t7Minute);

                timePickerDialog.show();

            }


            ;
        });





        etdate1picker.setOnClickListener(view -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    masjidadminpanel_activity.this, (datePicker, year12, month12, day1) -> {
                month12 = month12 +1;
                String date = day1 +"/"+ month12 +"/"+ year12;
                etdate1picker.setText(date);

            },year,month,day);
            datePickerDialog.show();

        });

        Apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storeTimings();

            }
        });
    }
    private void storeTimings(){
        String todaydate=etdate1picker.getText().toString();
        String fajr=etfajrpicker.getText().toString();
        String zohar=etzuhrpicker.getText().toString();
        String asar=etasarpicker.getText().toString();
        String maghrib=etmaghribpicker.getText().toString();
        String isha=etishapicker.getText().toString();
        String jummah=etjummahpicker.getText().toString();
        String jummah2=etjummah2picker.getText().toString();

        TimingsInput ab1=new TimingsInput(todaydate,fajr,zohar,asar,maghrib,isha,jummah,jummah2);
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference myref=database.getReference("TimingsInput");
        myref.setValue(ab1);
        Toast.makeText(masjidadminpanel_activity.this, "Data Transfer Successful", Toast.LENGTH_LONG).show();


    }

}



