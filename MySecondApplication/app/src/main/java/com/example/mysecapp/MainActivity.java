package com.example.mysecapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText messageEdit;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Vinogradov Vyacheslav");
        Button sendMessageBut;
        ImageButton vkButton;
        ImageButton gitButton;
        LinearLayout textLayaut;

        sendMessageBut = findViewById(R.id.sendMessageBut);
        vkButton = findViewById(R.id.vkButton);
        gitButton = findViewById(R.id.gitButton);
        messageEdit = findViewById(R.id.enterMessage);
        textLayaut = findViewById(R.id.textLayaut);

        TextView my_text = new TextView(MainActivity.this);
        my_text.setText("© 2018 VVE");

        LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, // width
                ViewGroup.LayoutParams.MATCH_PARENT); // height

        linearLayoutParams.gravity = Gravity.CENTER_HORIZONTAL;
        my_text.setLayoutParams(linearLayoutParams);

        textLayaut.addView(my_text);


        sendMessageBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(messageEdit.getText().toString());
            }
        });

        vkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToVK();
            }
        });

        gitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToGit();
            }
        });
    }

    private void sendMessage(String message){
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto: Slava147148@gmail.com"));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "From business card");
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        if (emailIntent.resolveActivity(getPackageManager()) != null){
            startActivity(emailIntent);
        }else{
            Toast.makeText(MainActivity.this, R.string.ErrorMessage, Toast.LENGTH_LONG).show();
        }
    }

    private void goToVK(){
        /*ACTION_VIEW used for open url in browser from app*/
        Intent viewIntent = new Intent(Intent.ACTION_VIEW);
        viewIntent.setData(Uri.parse(getString(R.string.my_VK)));
        if (viewIntent.resolveActivity(getPackageManager()) != null){
            startActivity(viewIntent);
        }else{
            Toast.makeText(MainActivity.this, R.string.ErrorView, Toast.LENGTH_LONG).show();
        }
    }

    private void goToGit(){
        Intent viewIntent = new Intent(Intent.ACTION_VIEW);
        viewIntent.setData(Uri.parse(getString(R.string.mu_git)));
        if (viewIntent.resolveActivity(getPackageManager()) != null){
            startActivity(viewIntent);
        }else{
            Toast.makeText(MainActivity.this, R.string.ErrorView, Toast.LENGTH_LONG).show();
        }
    }


}
