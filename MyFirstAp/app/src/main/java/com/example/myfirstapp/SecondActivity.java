package com.example.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity{
    private String message;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Button emailButton = findViewById(R.id.butGoToMail);
        TextView textView = findViewById(R.id.textViewSA);
        String introduction = getString(R.string.introduction);

        this.message = introduction.concat(getIntent().getStringExtra("Message"));
        textView.setText(this.message);
        emailButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                /* Call action for all applications, that can send a messages or object*/
//        Intent intentMail = new Intent(Intent.ACTION_SEND);
                /* Call action for only Email applications*/
                Intent intentMail = new Intent(Intent.ACTION_SENDTO);
                /* This method used for all ACTION_SEND...*/
                /*Caused all applications, that can send a messages or objects*/
//        intentMail.setType("plain/text");
                /*Caused a smaller set of applications than the previous method*/
//        intentMail.setType("plain/text");
                /*Caused all applications, that can send a messages*/
//        intentMail.setType("*/*");
                /* This method used for only ACTION_SENDTO*/
                /* Mailto: recipient's email address*/
                intentMail.setData(Uri.parse("mailto: chaosstruct@gmail.com"));

                /* Sender's email address*/
//                intentMail.putExtra(Intent.EXTRA_EMAIL,
//                        "Slava_148.1998@mail.ru");

                /* Theme of message*/
                intentMail.putExtra(Intent.EXTRA_SUBJECT,
                        getString(R.string.theme));

                /* Text of message*/
                intentMail.putExtra(Intent.EXTRA_TEXT,
                        SecondActivity.this.message);

                if (intentMail.resolveActivity(getPackageManager()) != null){
                    startActivity(intentMail);
                }else{
                    Toast.makeText(SecondActivity.this, R.string.ErrorMessage, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public static void start(Activity activity,String message){
        Intent intent = new Intent();
        intent.setClass(activity, SecondActivity.class);
        intent.putExtra("Message",message);
        activity.startActivity(intent);
    }

}
