package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int in1;
    public void generateNumber(){
        Random rand= new Random();
        in1=rand.nextInt(20)+1;
    }

    public void answer(View view)
    {
        Log.i("info", Integer.toString(in1));

        EditText input= (EditText) findViewById(R.id.inputnum);
        int in = Integer.valueOf(input.getText().toString());

        //int i=0;
        //while(i==0)
        if(in>in1)
        {
            Toast.makeText(this, "Try Lower", Toast.LENGTH_LONG).show();
        }
        else if(in<in1)
        {
            Toast.makeText(this, "TRy Higher", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Very good! Try Again", Toast.LENGTH_SHORT).show();
           // i=1;
            generateNumber();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateNumber();
    }
}
