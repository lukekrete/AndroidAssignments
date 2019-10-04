package com.example.androidassignments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ChatWindow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);
        final Button ButtonSend = findViewById(R.id.btnSend);
        final ListView lstChat = findViewById(R.id.chatWindow);
        final EditText edtText = findViewById(R.id.editText);
        final ArrayList<String> chat = new ArrayList<>();

        ButtonSend.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chat.add(edtText.getText().toString());

            }
        }));
    }
    private ChatAdapter extends ArrayAdapter<String>{
        public ChatAdapter(Context ctx) {
            super(ctx, 0);
        }

    }

}

