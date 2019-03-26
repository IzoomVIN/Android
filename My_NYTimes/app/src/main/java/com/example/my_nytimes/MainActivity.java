package com.example.my_nytimes;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
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
        /*Check screen orientation*/
        if(getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_PORTRAIT) {
            recyclerNewsView.setLayoutManager(new LinearLayoutManager(this));
        }else{
            recyclerNewsView.setLayoutManager(new GridLayoutManager(this, 2));
        }
    }
}
