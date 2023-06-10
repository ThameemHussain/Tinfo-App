package com.tinfo.thenewcollege;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DisplayImage extends AppCompatActivity {
ImageView Image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_image);
        getSupportActionBar().setTitle("Announcement");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF3385")));





        Image=(ImageView) findViewById(R.id.imageView5);

        FirebaseDatabase mDatabase;


        mDatabase = FirebaseDatabase.getInstance();

        mDatabase.getReference().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String image = snapshot.child("imageUrl").getValue(String.class);
                Glide.with(DisplayImage.this).load(image).into(Image);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}