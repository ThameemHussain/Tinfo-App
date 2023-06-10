package com.tinfo.thenewcollege;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


import java.text.SimpleDateFormat;


import java.util.Calendar;
import java.util.Date;
import java.util.Objects;


public class exampleactivity extends AppCompatActivity {
    private String userID;

      private FloatingActionButton nxtact;
      private ImageButton signout,edit;
      private TextView namedis;
      private TextView dorder;
      private TextView period,fetch,period2;
      private TextView impoannn,quotes;
      private ProgressBar progressBar;
    private FirebaseAuth mAuth;
   private String a,b,c,d,e,f;
   private String Sect1,Yea,DayOrder;
   private ImageView Iv;
   private ImageView IV1;
    FirebaseStorage storage;
    StorageReference storageReference;




    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();


        Objects.requireNonNull(getSupportActionBar()).hide();

        setContentView(R.layout.activity_exampleactivity);
        FirebaseAuth mauth = FirebaseAuth.getInstance();
        signout = (ImageButton) findViewById(R.id.imageButton);
        edit = (ImageButton) findViewById(R.id.editbutton);
        namedis = (TextView) findViewById(R.id.Studname);
        dorder = (TextView) findViewById(R.id.dodb);
        period = (TextView) findViewById(R.id.perioddb);
        period2 = (TextView) findViewById(R.id.perioddb2);
        impoannn = (TextView) findViewById(R.id.announceout);
        quotes = (TextView) findViewById(R.id.quotesout);
        nxtact = (FloatingActionButton) findViewById(R.id.nxtactbtn);
        Iv = (ImageView) findViewById(R.id.imageView);
        IV1 = (ImageView) findViewById(R.id.imageView4);
        progressBar = (ProgressBar) findViewById(R.id.progressBar4);
        fetch=(TextView)findViewById(R.id.textView16);

edit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(exampleactivity.this,editdetails.class);
        startActivity(intent);
    }
});

        nxtact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(exampleactivity.this, NamazTimings.class);
                startActivity(intent);
            }
        });

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(exampleactivity.this, Studentauthactivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(exampleactivity.this, "Logged out successfully!", Toast.LENGTH_SHORT).show();

            }
        });

        DatabaseReference ref1;
        DatabaseReference ref2;
        DatabaseReference ref3;
        FirebaseDatabase mDatabase;


        mDatabase = FirebaseDatabase.getInstance();
        ref1 = mDatabase.getReference().child("Users").child(userID);
        ref1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name = dataSnapshot.child("n").getValue(String.class);

                namedis.setText(name + "!");

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ref2 = mDatabase.getReference().child("AdminInput");
        ref3 = mDatabase.getReference().child("Users").child(FirebaseAuth.getInstance().getUid());

        StorageReference PathReference = storageReference.child("images/");

        mDatabase.getReference().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String image = snapshot.child("imageUrl").getValue(String.class);
                Glide.with(exampleactivity.this).load(image).into(IV1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        IV1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(exampleactivity.this, DisplayImage.class);
                startActivity(intent);
            }
        });



        ref2.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String dayor = dataSnapshot.child("dayorder").getValue(String.class);

                String tq = dataSnapshot.child("quotes").getValue(String.class);


                quotes.setText('"' + tq + '"');
                dorder.setText(dayor);
                NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(exampleactivity.this,"My Noti");

                notificationBuilder
                        .setColor(ContextCompat.getColor(exampleactivity.this, R.color.purple_700))
                        .setContentTitle("Today's Day Order!!")
                        .setContentText(dayor)

                        .setSmallIcon(R.drawable.tinfo_text_1)
                        .setAutoCancel(true);

                NotificationManagerCompat ManagerCom=NotificationManagerCompat.from(exampleactivity.this);
                ManagerCom.notify(1, notificationBuilder.build());


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
ref2.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        String ia = dataSnapshot.child("ImportantAnnouncements").getValue(String.class);
        impoannn.setText(ia);
        fetch.setText("Details Found!");
        progressBar.setVisibility(View.INVISIBLE);
        fetch.setVisibility(View.INVISIBLE);
        edit.setVisibility(View.VISIBLE);

    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }
});
        ref1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String Year1 = dataSnapshot.child("YearofStudying").getValue(String.class);

                String sec = dataSnapshot.child("Section").getValue(String.class);
                ref2.addValueEventListener(new ValueEventListener() {
                                               @Override
                                               public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                   String dayor = snapshot.child("dayorder").getValue(String.class);
                switch (Year1) {
                    case "1st Year":

                        if (sec.equals("A Section")) {

                            switch (dayor) {
                                case "1st":
                                    a = "C(AIK)";
                                    b = "Math";
                                    c = "SS";
                                    d = "C(SUF)";
                                    e = "Lang";
                                    f = "Break";
                                    break;
                                case "2nd":
                                    a = "Eng";
                                    b = "Math";
                                    c = "Lang";
                                    d = "C(AIK))";
                                    e = "OD(NZA)";
                                    f = "Break";
                                    break;
                                case "3rd":
                                    a = "Lab";
                                    b = "Lab";
                                    c = "VBE";
                                    d = "Math";
                                    e = "SS";
                                    f = "Break";
                                    break;
                                case "4th":
                                    a = "Lab";
                                    b = "Eng";
                                    c = "Lang";
                                    d = "C(AIK))";
                                    e = "Math";
                                    f = "Break";
                                    break;
                                case "5th":
                                    a = "C(AIK)";
                                    b = "Lang";
                                    c = "Math";
                                    d = "C(SUF)";
                                    e = "Eng";
                                    f = "Break";
                                    break;
                                case "6th":
                                    a = "Lang";
                                    b = "Lab";
                                    c = "Lab";
                                    d = "Eng";
                                    e = "Math";
                                    f = "Break";
                                    break;
                                default:
                                    a = "No Data ";
                                    b = "No Data ";
                                    c = "No Data ";
                                    d = "No Data ";
                                    e = "No Data ";
                                    f = "No Data ";
                                    break;
                            }




                        } else if (sec.equals("B Section")) {

                                    switch (dayor) {

                                        case "1st":
                                            a = "C(JM))";
                                            b = "Math";
                                            c = "C(JM)";
                                            d = "SS";
                                            e = "Lang";
                                            f = "Break";
                                            break;
                                        case "2nd":
                                            a = "Math";
                                            b = "Eng";
                                            c = "Lang";
                                            d = "Lab";
                                            e = "Lab";
                                            f = "Break";
                                            break;
                                        case "3rd":
                                            a = "C(JM)";
                                            b = "C(SUF)";
                                            c = "VBE";
                                            d = "Math";
                                            e = "SS";
                                            f = "Break";
                                            break;
                                        case "4th":
                                            a = "Math";
                                            b = "C(SUF)";
                                            c = "Lang";
                                            d = "Lab";
                                            e = "Eng";
                                            f = "Break";
                                            break;
                                        case "5th":
                                            a = "Math";
                                            b = "Lang";
                                            c = "Eng";
                                            d = "Lab";
                                            e = "Lab";
                                            f = "Break";
                                            break;
                                        case "6th":
                                            a = "Lang";
                                            b = "Math";
                                            c = "Eng";
                                            d = "C(JM)";
                                            e = "OD(NZA)";
                                            f = "Break";
                                            break;
                                        default:
                                            a = "No Data ";
                                            b = "No Data ";
                                            c = "No Data ";
                                            d = "No Data ";
                                            e = "No Data ";
                                            f = "No Data ";

                                    }

                        } else {

                                    switch (dayor) {

                                        case "1st":
                                            a = "Math";
                                            b = "SS";
                                            c = "C(SUF)";
                                            d = "C(MAK)";
                                            e = "Lang";
                                            f = "Break";
                                            break;
                                        case "2nd":
                                            a = "C(MAK)";
                                            b = "C(SUF)";
                                            c = "Lang";
                                            d = "Eng";
                                            e = "Math";
                                            f = "Break";
                                            break;
                                        case "3rd":
                                            a = "Lab";
                                            b = "Lab";
                                            c = "VBE";
                                            d = "Math";
                                            e = "SS";
                                            f = "Break";
                                            break;
                                        case "4th":
                                            a = "Lab";
                                            b = "Eng";
                                            c = "Lang";
                                            d = "C(MAK)";
                                            e = "Math";
                                            f = "Break";
                                            break;
                                        case "5th":
                                            a = "Math";
                                            b = "Lang";
                                            c = "C(MAK)";
                                            d = "Eng";
                                            e = "OD(ASM)";
                                            f = "Break";
                                            break;
                                        case "6th":
                                            a = "Lang";
                                            b = "Eng";
                                            c = "Lab";
                                            d = "Lab";
                                            e = "Math";
                                            f = "Break";
                                            break;
                                        default:
                                            a = "No Data ";
                                            b = "No Data ";
                                            c = "No Data ";
                                            d = "No Data ";
                                            e = "No Data ";
                                            f = "No Data ";

                                    }



                        }


                        break;
                    case "2nd Year":

                        if (sec.equals("A Section")) {

                                    switch (dayor) {

                                        case "1st":
                                            a = "Lab";
                                            b = "Lab";
                                            c = "Java";
                                            d = "OS";
                                            e = "Math";
                                            f = "Break";
                                            break;
                                        case "2nd":
                                            a = "OOAD";
                                            b = "Lab";
                                            c = "Lab";
                                            d = "Accounts";
                                            e = "Maths";
                                            f = "Break";
                                            break;
                                        case "3rd":
                                            a = "Math";
                                            b = "OOAD";
                                            c = "Java";
                                            d = "Accounts";
                                            e = "OS";
                                            f = "Break";
                                            break;
                                        case "4th":
                                            a = "Math";
                                            b = "OOAD";
                                            c = "OS";
                                            d = "Accounts";
                                            e = "Java";
                                            f = "Break";
                                            break;
                                        case "5th":
                                            a = "Lab";
                                            b = "Lab";
                                            c = "Accounts";
                                            d = "Math";
                                            e = "Java";
                                            f = "Break";
                                            break;
                                        case "6th":
                                            a = "OOAd";
                                            b = "Accounts";
                                            c = "OS";
                                            d = "NME";
                                            e = "Math";
                                            f = "Break";
                                            break;
                                        default:
                                            a = "No Data ";
                                            b = "No Data ";
                                            c = "No Data ";
                                            d = "No Data ";
                                            e = "No Data ";
                                            f = "No Data ";

                                    }


                        } else if (sec.equals("B Section")) {

                                    switch (dayor) {
                                        case "1st":
                                            a = "Math";
                                            b = "OOAD";
                                            c = "Lab";
                                            d = "Lab";
                                            e = "Accounts";
                                            f = "Break";
                                            break;
                                        case "2nd":
                                            a = "Math";
                                            b = "OOAD";
                                            c = "Accounts";
                                            d = "OS";
                                            e = "Java";
                                            f = "Break";
                                            break;
                                        case "3rd":
                                            a = "Java";
                                            b = "Accounts";
                                            c = "Math";
                                            d = "Lab";
                                            e = "Lab";
                                            f = "Break";
                                            break;
                                        case "4th":
                                            a = "Java";
                                            b = "Lab";
                                            c = "Lab";
                                            d = "OS";
                                            e = "Math";
                                            f = "Break";
                                            break;
                                        case "5th":
                                            a = "Accounts";
                                            b = "OOAD";
                                            c = "Java";
                                            d = "Math";
                                            e = "OS";
                                            f = "Break";
                                            break;
                                        case "6th":
                                            a = "Accounts";
                                            b = "OOAD";
                                            c = "OS";
                                            d = "NME";
                                            e = "Math";
                                            f = "Break";
                                            break;
                                        default:
                                            a = "No Data ";
                                            b = "No Data ";
                                            c = "No Data ";
                                            d = "No Data ";
                                            e = "No Data ";
                                            f = "No Data ";
                                            break;
                                    }

                        } else {

                                    switch (dayor) {

                                        case "1st":
                                            a = "Lab";
                                            b = "Lab";
                                            c = "Math";
                                            d = "OS";
                                            e = "Accounts";
                                            f = "Break";
                                            break;
                                        case "2nd":
                                            a = "OOAD";
                                            b = "Java";
                                            c = "Lab";
                                            d = "Lab";
                                            e = "Math";
                                            f = "Break";
                                            break;
                                        case "3rd":
                                            a = "OOAD";
                                            b = "OOAD";
                                            c = "Accounts";
                                            d = "OS";
                                            e = "Math";
                                            f = "Break";
                                            break;
                                        case "4th":
                                            a = "Accounts";
                                            b = "Java";
                                            c = "OS";
                                            d = "Math";
                                            e = "Java";
                                            f = "Break";
                                            break;
                                        case "5th":
                                            a = "Lab";
                                            b = "Lab";
                                            c = "Java";
                                            d = "Math";
                                            e = "Accounts";
                                            f = "Break";
                                            break;
                                        case "6th":
                                            a = "Accounts";
                                            b = "OOAD";
                                            c = "Math";
                                            d = "NME";
                                            e = "OS";
                                            f = "Break";
                                            break;
                                        default:
                                            a = "No Data ";
                                            b = "No Data ";
                                            c = "No Data ";
                                            d = "No Data ";
                                            e = "No Data ";
                                            f = "No Data ";

                                    }


                        }


                        break;
                    case "3rd Year":

                        if (sec.equals("A Section")) {

                                    switch (dayor) {

                                        case "1st":
                                            a = "Lab(ASP)";
                                            b = "Lab(ASP)";
                                            c = "NT";
                                            d = "ASP";
                                            e = "Python";
                                            f = "Break";
                                            break;
                                        case "2nd":
                                            a = "DM";
                                            b = "Python";
                                            c = "Lab(PYT)";
                                            d = "Lab(PYT)";
                                            e = "ASP";
                                            f = "Break";
                                            break;
                                        case "3rd":
                                            a = "Lab(ASP)";
                                            b = "Lab(ASP)";
                                            c = "ASP";
                                            d = "Python";
                                            e = "NT";
                                            f = "Break";
                                            break;
                                        case "4th":
                                            a = "NT";
                                            b = "DM";
                                            c = "Lab(PYT)";
                                            d = "Lab(PYT)";
                                            e = "ASP";
                                            f = "Break";
                                            break;
                                        case "5th":
                                            a = "Lab(ASP)";
                                            b = "DM";
                                            c = "NT";
                                            d = "Python";
                                            e = "ASP";
                                            f = "Break";
                                            break;
                                        case "6th":
                                            a = "Lab(PYT)";
                                            b = "DM";
                                            c = "DM";
                                            d = "NT";
                                            e = "Python";
                                            f = "Break";
                                            break;
                                        default:
                                            a = "No Data ";
                                            b = "No Data ";
                                            c = "No Data ";
                                            d = "No Data ";
                                            e = "No Data ";
                                            f = "No Data ";

                                    }



                        } else if (sec.equals("B Section")) {

                                    switch (dayor) {

                                        case "1st":
                                            a = "ASP";
                                            b = "NT";
                                            c = "Lab(ASP)";
                                            d = "Lab(ASP)";
                                            e = "DM";
                                            f = "Break";
                                            break;
                                        case "2nd":
                                            a = "Lab(PYT)";
                                            b = "Lab(PYT)";
                                            c = "ASP";
                                            d = "Python";
                                            e = "DM";
                                            f = "Break";
                                            break;
                                        case "3rd":
                                            a = "NT";
                                            b = "ASP";
                                            c = "Lab(ASP)";
                                            d = "Lab(ASP)";
                                            e = "Python";
                                            f = "Break";
                                            break;
                                        case "4th":
                                            a = "Lab(PYT)";
                                            b = "Lab(PYT)";
                                            c = "DM";
                                            d = "Python";
                                            e = "ASP";
                                            f = "Break";
                                            break;
                                        case "5th":
                                            a = "NT";
                                            b = "ASP";
                                            c = "Python";
                                            d = "Lab(ASP)";
                                            e = "DM";
                                            f = "Break";
                                            break;
                                        case "6th":
                                            a = "DM";
                                            b = "Python";
                                            c = "NT";
                                            d = "Lab(PYT)";
                                            e = "NT(MAK)";
                                            f = "Break";
                                            break;
                                        default:
                                            a = "No Data ";
                                            b = "No Data ";
                                            c = "No Data ";
                                            d = "No Data ";
                                            e = "No Data ";
                                            f = "No Data ";

                                    }

                        } else {

                                    switch (dayor) {

                                        case "1st":
                                            a = "ASP";
                                            b = "Python";
                                            c = "Lab(ASP)";
                                            d = "Lab(ASP)";
                                            e = "NT";
                                            f = "Break";
                                            break;
                                        case "2nd":
                                            a = "Lab(PYT)";
                                            b = "Lab(PYT)";
                                            c = "Python";
                                            d = "ASP";
                                            e = "NT";
                                            f = "Break";
                                            break;
                                        case "3rd":
                                            a = "ASP";
                                            b = "NT";
                                            c = "Lab(PYT)";
                                            d = "Lab(PYT)";
                                            e = "DM";
                                            f = "Break";
                                            break;
                                        case "4th":
                                            a = "DM";
                                            b = "Lab(ASP)";
                                            c = "Lab(ASP)";
                                            d = "ASP";
                                            e = "Python";
                                            f = "Break";
                                            break;
                                        case "5th":
                                            a = "ASP";
                                            b = "DM";
                                            c = "NT";
                                            d = "Lab(PYT)";
                                            e = "Python";
                                            f = "Break";
                                            break;
                                        case "6th":
                                            a = "Lab(ASP)";
                                            b = "DM";
                                            c = "NT";
                                            d = "Python";
                                            e = "DM";
                                            f = "Break";
                                            break;
                                        default:
                                            a = "No Data ";
                                            b = "No Data ";
                                            c = "No Data ";
                                            d = "No Data ";
                                            e = "No Data ";
                                            f = "No Data ";

                                    }




                        }


                        break;
                    default:
                        a = "No Data ";
                        b = "No Data ";
                        c = "No Data ";
                        d = "No Data ";
                        e = "No Data ";
                        f = "No Data ";

                }

                                                   //block start
                                                   try {
                                                       Calendar calendar = Calendar.getInstance();
                                                       SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss aa");

                                                       Date CurrentTime = dateFormat.parse(dateFormat.format(calendar.getTime()));

                                                       Date twopm = dateFormat.parse("02:00:00 pm");
                                                       Date twofifpm = dateFormat.parse("02:50:00 pm");
                                                       Date threeforty = dateFormat.parse("03:40:00 pm");
                                                       Date fourthir = dateFormat.parse("04:30:00 pm");
                                                       Date fourforty = dateFormat.parse("04:45:00 pm");
                                                       Date fivetwof = dateFormat.parse("05:35:00 pm");
                                                       Date sixten = dateFormat.parse("06:20:00 pm");


                                                       if (CurrentTime.after(twopm) && CurrentTime.before(twofifpm)) {
                                                           period.setText(a);
                                                           period2.setText(b);
                                                       } else if (CurrentTime.after(twofifpm) && CurrentTime.before(threeforty)) {
                                                           period.setText(b);
                                                           period2.setText(c);
                                                       } else if (CurrentTime.after(threeforty) && CurrentTime.before(fourthir)) {
                                                           period.setText(c);
                                                           period2.setText(f);
                                                       } else if (CurrentTime.after(fourthir) && CurrentTime.before(fourforty)) {
                                                           period.setText(f);
                                                           period2.setText(d);
                                                       } else if (CurrentTime.after(fourforty) && CurrentTime.before(fivetwof)) {
                                                           period.setText(d);
                                                           period2.setText(e);
                                                       } else if (CurrentTime.after(fivetwof) && CurrentTime.before(sixten)) {
                                                           period.setText(e);
                                                           period2.setText("Over");
                                                       } else {
                                                           period.setText("No Data");
                                                       }
                                                   } catch (Exception e) {

                                                       Toast.makeText(exampleactivity.this ,"Error Occured ",Toast.LENGTH_LONG).show();
                                                   }
                                                   //block end
                                               }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }}