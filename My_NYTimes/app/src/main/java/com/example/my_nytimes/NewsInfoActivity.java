package com.example.my_nytimes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class NewsInfoActivity extends AppCompatActivity {

    private ImageView image;
    private TextView title;
    private TextView date;
    private TextView text;
    private TextView toolbarCategory;
    private ImageButton cancelBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_info);
        image = findViewById(R.id.ANIimageView);
        title = findViewById(R.id.title);
        date = findViewById(R.id.date);
        text = findViewById(R.id.text);
        toolbarCategory = findViewById(R.id.toolbar_text);
        cancelBut = findViewById(R.id.toolbar_button);
        build();
    }

    private void build(){
        Glide.with(this)
                .load(getIntent()
                        .getStringExtra("imageURL"))
                .into(image);

        toolbarCategory.setText(getIntent().getStringExtra("category"));
        title.setText(getIntent().getStringExtra("title"));
        date.setText(getIntent().getStringExtra("date"));
        text.setText(getIntent().getStringExtra("text"));

        cancelBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.start(NewsInfoActivity.this);
            }
        });
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
