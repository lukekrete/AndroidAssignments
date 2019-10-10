package com.example.androidassignments;

import android.support.annotation.Nullable;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "StartActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(ACTIVITY_NAME, "In onCreate()");
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(ACTIVITY_NAME, "I am here, in activity");
                Intent intent = new Intent(getApplicationContext(), ListItemsActivity.class);
                startActivityForResult(intent, 10);
            }
        });
        Button btnStartChat = findViewById(R.id.startChat);
        btnStartChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(ACTIVITY_NAME, "User Clicked Start Chat");
                Intent intent = new Intent(getApplicationContext(), ChatWindow.class);
                startActivity(intent);
            }
        });
        Button btnStartToolbar = findViewById(R.id.StartToolBar);
        btnStartToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(ACTIVITY_NAME, "User Clicked Start Toolbar");
                Intent intent = new Intent(getApplicationContext(), TestToolbar.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10){
            Log.i(ACTIVITY_NAME, "Returned to MainActivity.onActivityResult");
        }
        if(resultCode == Activity.RESULT_OK){
            String messagePassed = data.getStringExtra("Response");
            CharSequence text = ("ListItemsActivity passed:" + messagePassed) ;
            Toast toast = Toast.makeText(getApplicationContext(),text, Toast.LENGTH_LONG);
            toast.show();

        }
    }
    @Override
    protected void onStart(){
        Log.i(ACTIVITY_NAME, "In onStart()");
        super.onStart();
    }
    @Override
    protected void onResume(){

        Log.i(ACTIVITY_NAME, "In onResume()");
        super.onResume();
    }
    @Override
    protected void onPause(){
        Log.i(ACTIVITY_NAME, "In onPause()");
        super.onPause();
    }
    @Override
    protected void onStop(){
        Log.i(ACTIVITY_NAME, "In onStop()");
        super.onStop();
    }
    @Override
    protected void onDestroy(){
        Log.i(ACTIVITY_NAME, "In onDestroy()");
        super.onDestroy();
    }

}
