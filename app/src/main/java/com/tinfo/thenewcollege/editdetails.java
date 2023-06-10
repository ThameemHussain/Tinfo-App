package com.tinfo.thenewcollege;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class editdetails extends AppCompatActivity {
private Button update;
private Spinner yearsp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editdetails);
        getSupportActionBar().setTitle("Year Editor");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF3385")));

        update=(Button) findViewById(R.id.button);
        yearsp=(Spinner) findViewById(R.id.spnrYear2);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String updatedyear=yearsp.getSelectedItem().toString().trim();
                FirebaseDatabase.getInstance().getReference("Users")
                        .child(FirebaseAuth.getInstance().getUid()).child("YearofStudying").setValue(updatedyear).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(editdetails.this, "Updation Successful", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(editdetails.this, "Updation Failure, Try again!!", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

    }
}