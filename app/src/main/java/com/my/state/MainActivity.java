package com.my.state;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;

import com.my.state.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private int cnt;
    private ActivityMainBinding activityMainBinding;
    public static final String CNT = "CNT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);

        if (savedInstanceState != null)
        {
            cnt = savedInstanceState.getInt(CNT, 0);
            Log.d("Happy", "OnCreate cnt ="+cnt);

        }

    }

    public void checkMe(View view) {
        cnt++;
        activityMainBinding.couterTextView.setText(String.valueOf(cnt));
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {

        cnt = savedInstanceState.getInt(CNT);
        activityMainBinding.couterTextView.setText(String.valueOf(cnt));
        Log.d("happy", "onRestoreInstanceState"+cnt);
        super.onRestoreInstanceState(savedInstanceState);
    }



    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("happy", "onSaveInstanceState"+cnt);
        outState.putInt(CNT, cnt);

    }
}