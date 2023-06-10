package com.tinfo.thenewcollege;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;

import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public  class Studentauthactivity extends AppCompatActivity  {
    private FirebaseAuth mAuth;
    private Button login;
    private TextView register,forgotpassword;
    private EditText loginemail;
    private EditText password;
    private ProgressBar progressBar;
    private EditText a;
    private EditText b;

    final String abc="OfficeAdmin87*";
    final String cba="MasjidAdmin90*";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.parseColor("#454A70"));


        mAuth = FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser()!=null){
            Intent intent=new Intent(Studentauthactivity.this,exampleactivity.class);
            startActivity(intent);
finish();

        }


        setContentView(R.layout.activity_studentauthactivity);

        register = (TextView) findViewById(R.id.tvnewregister);
        forgotpassword= (TextView) findViewById(R.id.tvforgetpassword);
        login = (Button) findViewById(R.id.btnstudentlogin);
        loginemail = (EditText) findViewById(R.id.etemail);
        password = (EditText) findViewById(R.id.etpassword);
        progressBar = (ProgressBar) findViewById(R.id.progressBar2);
        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);

                Intent intent=new Intent(Studentauthactivity.this,ForgotPasswordActivity.class);
                startActivity(intent);
                progressBar.setVisibility(View.INVISIBLE);
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);

                Intent intent =new Intent(Studentauthactivity.this,StudentRegistration.class);
                startActivity(intent);
                progressBar.setVisibility(View.INVISIBLE);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               userlogin();
            }
        });

    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }
    private void updateUI(FirebaseUser currentUser) {
        Intent intent =new Intent(Studentauthactivity.this,exampleactivity.class);

    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }

    private void userlogin() {

       String x= loginemail.getText().toString().trim();
       String y= password.getText().toString().trim();
        if(x.isEmpty()) {
            loginemail.setError("Email is Required");
            loginemail.requestFocus();
            return;
        }if(y.isEmpty()){
            password.setError("Password is Required");
            password.requestFocus();
            return;

        }if((!Patterns.EMAIL_ADDRESS.matcher(x).matches())&&( !x.equals(abc)) &&(!x.equals(cba))){

            loginemail.setError("Please Enter a Valid Email Address");
            loginemail.requestFocus();
            return;
        }
        if(password.length()<6){
            password.setError("Password should be minimum of 6 characters");
            password.requestFocus();
            return;
        }


        //Office admin*
        if((x.equals("OfficeAdmin87*"))&&(y.equals("CollegePass99%"))){
            Intent intent =new Intent(Studentauthactivity.this,OfficeAdminPanel.class);
            startActivity(intent);
            Toast.makeText(Studentauthactivity.this,"Entered Office Admin panel!",Toast.LENGTH_LONG).show();
        }
        //*end*


        //Masjid Admin*
        if((x.equals("MasjidAdmin90*"))&&(y.equals("AllahuAkbar101%"))){
            Intent intent =new Intent(Studentauthactivity.this,masjidadminpanel_activity.class);
            startActivity(intent);
            Toast.makeText(Studentauthactivity.this,"Entered Masjid Admin panel!",Toast.LENGTH_LONG).show();

        }
        //*end*


        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(x,y).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();

                    if(user.isEmailVerified()){
                        Toast.makeText(Studentauthactivity.this,"Welcome Buddy!",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Studentauthactivity.this, exampleactivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        user.sendEmailVerification();
                        Toast.makeText(Studentauthactivity.this, "Please Check the link sent to your Email", Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.INVISIBLE);

                    }


                }else{
                    Toast.makeText(Studentauthactivity.this, "Failed to Login.Please check if the Email and password is correct", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE);

                }
       }


        });
    }


}