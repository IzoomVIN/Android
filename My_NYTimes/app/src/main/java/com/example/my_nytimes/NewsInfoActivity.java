package com.example.my_nytimes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;

public class NewsInfoActivity extends AppCompatActivity {

    private ImageView image;
    private TextView title;
    private TextView date;
    private TextView text;
    private String ImageURL;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_info);

        this.toolbar = findViewById(R.id.actionBar);
        this.image = findViewById(R.id.ANIimageView);
        this.title = findViewById(R.id.title);
        this.date = findViewById(R.id.date);
        this.text = findViewById(R.id.text);
        this.ImageURL = getIntent().getStringExtra("imageURL");

        build();
    }

    private void build(){
        Glide.with(this)
                .load(this.ImageURL)
                .into(this.image);

        this.setActionBar(toolbar);
        this.getActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle(getIntent().getStringExtra("category").toUpperCase());
        this.title.setText(getIntent().getStringExtra("title"));
        this.date.setText(getIntent().getStringExtra("date"));
        this.text.setText(getIntent().getStringExtra("text"));
    }

    public static void start(Activity activity, String imageURL,
                             String category, String title,
                             String date, String text){

        Intent intent = new Intent();
        intent.setClass(activity, NewsInfoActivity.class);
        intent.putExtra("imageURL", imageURL);
        intent.putExtra("title", title);
        intent.putExtra("date", date);
        intent.putExtra("category", category);
        intent.putExtra("text", text);
        activity.startActivity(intent);
    }
}
