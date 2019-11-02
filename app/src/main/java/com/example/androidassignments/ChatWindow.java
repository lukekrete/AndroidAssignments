package com.example.androidassignments;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
    static final String GET_MESSAGES = "SELECT KEY_MESSAGE FROM MESSAGES";
    String ACTIVITY_NAME = "ChatWindow";
    final ArrayList<String> chat = new ArrayList<>();
    static SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);

        final Button ButtonSend = findViewById(R.id.btnSend);
        final ListView lstChat = findViewById(R.id.chatWindow);
        final EditText edtText = findViewById(R.id.editText);

        ChatDatabaseHelper dbHelper = new ChatDatabaseHelper(this);
        database = dbHelper.getWritableDatabase();

        final Cursor cursor = database.rawQuery(GET_MESSAGES,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Log.i(ACTIVITY_NAME, "SQL MESSAGE:" + cursor.getString( cursor.getColumnIndex( ChatDatabaseHelper.KEY_MESSAGE) ) );
            chat.add(cursor.getString(cursor.getColumnIndex(ChatDatabaseHelper.KEY_MESSAGE)));
            cursor.moveToNext();
        }
        Log.i(ACTIVITY_NAME, "Cursor’s  column count =" + cursor.getColumnCount() );
        for (int i = 0; i <cursor.getColumnCount();i++){
            Log.i(ACTIVITY_NAME, "Column Name: "+ cursor.getColumnName(i));
        }

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
                ContentValues xValues = new ContentValues();
                xValues.put(ChatDatabaseHelper.KEY_MESSAGE,value);
                database.insert(ChatDatabaseHelper.TABLE_NAME, "NullPlaceHolder",xValues);
                edtText.setText("");
                messageAdapter.notifyDataSetChanged();
            }
        }));
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        database.close();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    }
}