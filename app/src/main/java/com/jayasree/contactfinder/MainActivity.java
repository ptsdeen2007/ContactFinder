package com.jayasree.contactfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DbHelper(this);
        if (dbHelper.getCount() == 0) {
            Datas.initializeDb(dbHelper);
        }
    }

    public void call(View view) {
        Intent intent = new Intent(this, ContactActivity.class);
        startActivity(intent);
    }
}
