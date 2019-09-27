package com.example.androidassignments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(ACTIVITY_NAME,"in onCreate()");
        final SharedPreferences sharedPref = getSharedPreferences("DefaultEmail", this.MODE_PRIVATE);
        String email = sharedPref.getString("DefaultEmail", "email@domain.com");
        final EditText email_field = findViewById(R.id.edt_email);
        email_field.setText(email);


        Button login = findViewById(R.id.btn_login);
        login.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("DefaultEmail", email_field.getText().toString());
                editor.commit();
                Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                //Log.i(ACTIVITY_NAME, "THis is where it ends");
                Log.d("My_tag", intent.toString());
                startActivity(intent);
            }
        }));
    }



    protected void onResume(){
        super.onResume();
        Log.i(ACTIVITY_NAME,"in onResume()");
    }
    protected void onStart(){
        super.onStart();
        Log.i(ACTIVITY_NAME,"in onStart()");

    }
    protected void onPause(){
        super.onPause();
        Log.i(ACTIVITY_NAME,"in onPause()");

    }
    protected void onStop(){
        super.onStop();
        Log.i(ACTIVITY_NAME,"in onStop()");

    }
    protected void onDestroy(){
        super.onDestroy();
        Log.i(ACTIVITY_NAME,"in onDestroy()");

    }
}
