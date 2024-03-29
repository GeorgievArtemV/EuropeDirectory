package com.example.europedirectory.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.europedirectory.R;
import com.example.europedirectory.ui.screen.CoreFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.placeHolder, new CoreFragment()).commit();
    }
}