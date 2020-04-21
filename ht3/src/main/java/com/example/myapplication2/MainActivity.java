package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(findViewById(R.id.toolBar));

        ItemAdapter adapter = new ItemAdapter();
        adapter.setOnItemClickListener(position -> {
            Intent intent = new Intent(MainActivity.this, EditContact.class);
            startActivity(intent);
        });

        if (Store.getStore().size() > 0) {
            TextView tv = findViewById(R.id.noContactsTV);
            tv.setText("");
        }
        FloatingActionButton floatingActionButton = findViewById(R.id.FloatingActionButton);
        floatingActionButton.setOnClickListener(this);

        RecyclerView recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, RegistrationUserInfoActivity.class);
        startActivity(intent);
        }
    }


