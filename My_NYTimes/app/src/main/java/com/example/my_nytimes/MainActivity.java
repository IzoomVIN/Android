package com.example.my_nytimes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerNewsView = findViewById(R.id.RecyclerNewsView);
        recyclerNewsView.setAdapter(new NewsRecyclerAdapter(
                this, DataUtils.generateNews()));
        recyclerNewsView.setLayoutManager(new LinearLayoutManager(this));
    }
}
