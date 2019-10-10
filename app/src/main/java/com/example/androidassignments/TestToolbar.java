package com.example.androidassignments;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TestToolbar extends AppCompatActivity {
    String optionText = "Lets harvest this wheat";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_toolbar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "I replaced this with my own text", Snackbar.LENGTH_LONG)
                        .setAction("Action/Reaction", null).show();
            }
        });

    }
    public boolean onCreateOptionsMenu(Menu m){
        getMenuInflater().inflate(R.menu.toolbar_menu, m);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem mi){
        int id = mi.getItemId();
        switch(id){
            case R.id.action_one:
                View view = findViewById(R.id.toolbar);
                Snackbar.make(view, optionText, Snackbar.LENGTH_LONG)
                        .setAction("Action/Reaction", null).show();
                Log.d("Toolbar","Option 1 Selected");
                break;
            case R.id.action_two:
                AlertDialog.Builder builder = new AlertDialog.Builder(TestToolbar.this);
                builder.setMessage(R.string.dialog)
                        .setTitle(R.string.dialog_title)
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User clicked OK button
                                Intent resultIntent = new Intent(  );
                                resultIntent.putExtra("Response", getResources().getString(R.string.my_information));
                                setResult(Activity.RESULT_OK, resultIntent);
                                finish();
                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        })
                        .show();
                Log.d("Toolbar","Option 2 Selected");
                break;
            case R.id.action_three:
                AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                // Get the layout inflater
                LayoutInflater inflater = this.getLayoutInflater();
                final View customDialogLayout = inflater.inflate(R.layout.custom_layout, null);
                // Inflate and set the layout for the dialog
                // Pass null as the parent view because its going in the dialog layout
                builder2.setView(customDialogLayout)
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                optionText = ((EditText)customDialogLayout.findViewById(R.id.newMessage)).getText().toString();
                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });
                builder2.create().show();
                Log.d("Toolbar","Option 3 Selected");
                break;
            case R.id.about:
                CharSequence text ="Version 1.0 by Luke Krete";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(getApplicationContext() ,text ,duration);
                toast.show();
                Log.d("Toolbar","About Selected");
                break;
        }

        return true;
    }
}
