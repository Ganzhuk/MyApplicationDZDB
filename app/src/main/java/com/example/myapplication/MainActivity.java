package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private AbsListView.RecyclerListener RecyclerListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSaveClick(View v){
        TextView textView = (TextView)findViewById(R.id.editTextTextPersonName4);
        TextView textView2 = (TextView)findViewById(R.id.autoCompleteTextView5);
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
        db.execSQL("INSERT INTO users VALUES(textView, textView2)");
        Cursor cursor = db.rawQuery("SELECT * FROM users", null);
        while(cursor.moveToNext()) {
            db.execSQL("CREATE TABLE IF NOT EXISTS users (item TEXT, text TEXT)");
        }
        cursor.close();
        db.close();
    }

    public void onViewDataBase(View v){
        
    }
}