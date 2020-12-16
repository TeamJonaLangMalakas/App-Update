package com.example.nestegggg;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    RecyclerView mRecyclerView;
    DataBaseHelper databaseHelper;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getSupportActionBar();
        actionBar.setTitle("All Records");
        mRecyclerView = findViewById(R.id.recyclerView);
        databaseHelper = new DataBaseHelper(this);

        showRecord();
        fab = findViewById(R.id.addFabButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, AddGoals.class);
                intent.putExtra("editmode", false);
                startActivity(intent);
            }
        });
    }

    private void showRecord() {
        Adapter adapter = new Adapter(MainActivity.this,
                databaseHelper.getAllData(Constants.C_Add_TIMESTAMP + " DESC"));
        mRecyclerView.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        showRecord();

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        exitFromApp();
    }

    private void exitFromApp() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }
}