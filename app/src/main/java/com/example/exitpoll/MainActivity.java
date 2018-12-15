package com.example.exitpoll;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.exitpoll.db.DatabaseHelper;
import com.example.exitpoll.model.NumberItems;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper mHelper;
    private SQLiteDatabase mDb;
    private List<NumberItems> mNumberItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button choose1Button = findViewById(R.id.choose_no1);
        choose1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button choose2Button = findViewById(R.id.choose_no2);
        choose2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button choose3Button = findViewById(R.id.choose_no3);
        choose3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

        Button button = findViewById(R.id.result);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper helper = new DatabaseHelper(MainActivity.this);
                SQLiteDatabase db = helper.getWritableDatabase();

                Cursor c = db.query("Number" , null ,null ,null ,null ,null ,null );
                c.moveToNext();
                //c.getString(c.getColumnIndex("result"));
            }
        });
    }
}
