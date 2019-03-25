package com.example.myfirstapp;


import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText scanner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Button secondA = (Button)findViewById(R.id.butCallSA);
        this.scanner = findViewById(R.id.textInput);
        Button viewButton = findViewById(R.id.ViewButton);
        Button toMatrButton = findViewById(R.id.ToMatr);

        toMatrButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                SecondActivity.start(MainActivity.this,
                        ModifitedClass.spiralMatrixFromString(scanner.getText().toString()));
            }
        });

        viewButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                SecondActivity.start(MainActivity.this, scanner.getText().toString());
            }
        });
    }
}
