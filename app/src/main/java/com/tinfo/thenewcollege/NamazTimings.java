package com.tinfo.thenewcollege;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import android.net.Uri;
import android.app.AlarmManager;
import android.app.Notification;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.content.Intent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import android.app.PendingIntent;


public class NamazTimings extends AppCompatActivity {
   private TextView ffajr,zzohr,aasr,mmaghrib,iisha,jjummah,jjummah2;
//    public static final String NOTIFICATION_CHANNEL_ID = "10001" ;
//    private final static String default_notification_channel_id = "default" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_namaz_timings);
        getSupportActionBar().setTitle("Salah Timings");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF3385")));

        ffajr=(TextView) findViewById(R.id.textView22);
        zzohr=(TextView) findViewById(R.id.textView23);
        aasr=(TextView) findViewById(R.id.textView25);
        mmaghrib=(TextView) findViewById(R.id.textView26);
        iisha=(TextView) findViewById(R.id.textView27);
        jjummah=(TextView) findViewById(R.id.textView28);
        jjummah2=(TextView)findViewById(R.id.textView35);
        DatabaseReference ref1;
        DatabaseReference ref2;
        DatabaseReference ref3;
        DatabaseReference ref4;
                DatabaseReference ref5;
        DatabaseReference ref6;
        FirebaseDatabase mDatabase;



        mDatabase=FirebaseDatabase.getInstance();
        ref1=mDatabase.getReference().child("TimingsInput");
        ref2=mDatabase.getReference().child("TimingsInput");
        ref3=mDatabase.getReference().child("TimingsInput");
        ref4=mDatabase.getReference().child("TimingsInput");
        ref5=mDatabase.getReference().child("TimingsInput");
        ref6=mDatabase.getReference().child("TimingsInput");
        ref1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String faj=snapshot.child("fajr").getValue(String.class);
                ffajr.setText(faj);
//                SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm");
//                Date d = null;
//                try {
//                    d = dateFormat.parse(faj);
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//                long abh=d.getTime();
//                scheduleNotification(getNotification("") , abh) ;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String zoh=snapshot.child("zohar").getValue(String.class);
                zzohr.setText(zoh);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        ref3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String asr=snapshot.child("asar").getValue(String.class);
                aasr.setText(asr);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        ref4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String mag=snapshot.child("maghrib").getValue(String.class);
                mmaghrib.setText(mag);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        ref5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String ish=snapshot.child("isha").getValue(String.class);
                iisha.setText(ish);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        ref6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String jum=snapshot.child("jummah").getValue(String.class);
                jjummah.setText(jum);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        ref1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String jum2=snapshot.child("jummah2").getValue(String.class);
                jjummah2.setText(jum2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


//       AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
//       Intent alarmIntent = new Intent(NamazTimings.this, AlarmReceiver1.class); // AlarmReceiver1 = broadcast receiver
//
//       PendingIntent pendingIntent = PendingIntent.getBroadcast(  NamazTimings.this, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
//        alarmIntent.setData((Uri.parse("custom://"+System.currentTimeMillis())));
//        alarmManager.cancel(pendingIntent);
//
//        Calendar alarmStartTime = Calendar.getInstance();
//        Calendar now = Calendar.getInstance();
//        alarmStartTime.set(Calendar.HOUR, 1);
//        alarmStartTime.set(Calendar.MINUTE, 48);
//        alarmStartTime.set(Calendar.SECOND, 0);
//        alarmStartTime.set(Calendar.AM_PM, 1 < 12 ? Calendar.PM : Calendar.AM);
//        if (now.after(alarmStartTime)) {
//            Log.d("Hey","Added a day");
//            alarmStartTime.add(Calendar.DATE, 1);
//        }
//
//        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, alarmStartTime.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
//        Log.d("Alarm","Alarms set for everyday 8 am.");

    }
//    private void scheduleNotification(Notification notification , long delay) {
//        Intent notificationIntent = new Intent( this, MyNotificationPublisher.class ) ;
//        notificationIntent.putExtra(MyNotificationPublisher. NOTIFICATION_ID , 1 ) ;
//        notificationIntent.putExtra(MyNotificationPublisher. NOTIFICATION , notification) ;
//        PendingIntent pendingIntent = PendingIntent. getBroadcast ( this, 0 , notificationIntent , PendingIntent. FLAG_UPDATE_CURRENT ) ;
//        AlarmManager alarmManager = (AlarmManager) getSystemService(NamazTimings.this. ALARM_SERVICE ) ;
//        assert alarmManager != null;
//        alarmManager.set(AlarmManager. ELAPSED_REALTIME_WAKEUP , delay , pendingIntent) ;
//    }
//    private Notification getNotification (String content) {
//        NotificationCompat.Builder builder = new NotificationCompat.Builder( this, default_notification_channel_id ) ;
//        builder.setContentTitle( "Scheduled Notification" ) ;
//        builder.setContentText(content) ;
//        builder.setSmallIcon(R.drawable. ic_launcher_foreground ) ;
//        builder.setAutoCancel( true ) ;
//        builder.setChannelId( NOTIFICATION_CHANNEL_ID ) ;
//        return builder.build() ;
//    }

}