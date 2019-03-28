package com.example.my_nytimes;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
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
                this, DataUtils.generateNews(), new ItemClickedCallback() {
            @Override
            public void onItemClicked(NewsItem item) {
                NewsInfoActivity.start(MainActivity.this, item.getImageUrl(), item.getCategory().getName(),
                        item.getFullText(), item.getPublishDate().toString(),
                        item.getFullText());
            }
        }));
        /*Check screen orientation*/
        if(checkOrientation()) {
            recyclerNewsView.setLayoutManager(new LinearLayoutManager(this));
        }else{
            recyclerNewsView.setLayoutManager(new GridLayoutManager(this, 2));
        }

        recyclerNewsView.setItemAnimator(new DefaultItemAnimator());
    }

    private boolean checkOrientation(){
        if(getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_PORTRAIT) {
            return true;
        }
        return false;
    }

    public static void start(Activity activity){
        Intent intent = new Intent();
        intent.setClass(activity, MainActivity.class);
        activity.startActivity(intent);
    }
}
