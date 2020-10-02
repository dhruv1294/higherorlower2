package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNumber;
    MainViewModel mainViewModel;

    public void answer(View view)
    {
        Log.i("info", Integer.toString(randomNumber));

        EditText input= (EditText) findViewById(R.id.inputnum);
        int givenNumber = Integer.parseInt(input.getText().toString());

        if(givenNumber> randomNumber)
        {
            Toast.makeText(this, "Try Lower", Toast.LENGTH_LONG).show();
        }
        else if(givenNumber< randomNumber)
        {
            Toast.makeText(this, "Try Higher", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Very good! Guess another random number!", Toast.LENGTH_SHORT).show();
            mainViewModel.getNewRandom();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.getRandomLiveData().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                randomNumber = integer;
            }
        });
    }
}
