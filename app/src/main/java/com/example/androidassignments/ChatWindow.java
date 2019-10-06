package com.example.androidassignments;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

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

        class ChatAdapter extends ArrayAdapter{
            public ChatAdapter(Context ctx) {super(ctx, 0);}
            public int getCount(){return chat.size();}
            public String getItem(int position) {return chat.get(position);}
            public View getView(int position, View convertView, ViewGroup parent)
            {
                LayoutInflater inflater = ChatWindow.this.getLayoutInflater();

                View result = null ;
                if(position%2 == 0) {
                    result = inflater.inflate(R.layout.chat_row_incoming, null);
                }
                else {
                    result = inflater.inflate(R.layout.chat_row_outgoing, null);
                }

                TextView message = result.findViewById(R.id.message_text);
                message.setText(   getItem(position)  ); // get the string at position
                return result;
            }
        }

        final ChatAdapter messageAdapter =new ChatAdapter( this );
        lstChat.setAdapter (messageAdapter);
        ButtonSend.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = edtText.getText().toString();
                chat.add(value);
                edtText.setText("");
                messageAdapter.notifyDataSetChanged();
            }
        }));
    }
}