package com.example.myapplication;

import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    public TextView result;
    public EditText num;

    public MainActivity() throws FileNotFoundException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            ReadWrite readWrite = new ReadWrite(this);
            json = readWrite;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    ReadWrite json;
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void ping(View view) throws IOException {
        json.write();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Read(View view) throws IOException {
        json.read();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Add(View view) throws IOException {
        EditText Class = (EditText)findViewById(R.id.Class);
        EditText Name = (EditText)findViewById(R.id.Name);
        EditText DueDate = (EditText)findViewById(R.id.DueDate);

        String ClassStr = Class.getText().toString();
        String NameStr = Name.getText().toString();
        String DueDateStr = DueDate.getText().toString();

        Assignment x = new Assignment(ClassStr, NameStr, DueDateStr, false);

        json.addToList(x);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Cycle(View view) throws IOException {
        TextView txt = (TextView)findViewById(R.id.CurrentAssignment);
        txt.setText(json.cycleAssignments());
    }

    public void Remove(View view){
        json.removeFromList();
    }
}