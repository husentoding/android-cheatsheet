package com.example.husen.mvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

//    ViewModel
    private NameViewModel viewModel;

    private TextView tes;
    private EditText tes2;
    private Button tes3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tes = findViewById(R.id.tes);
        tes2 = findViewById(R.id.tes2);
        tes3 = findViewById(R.id.tes3);
//        getViewModel
        viewModel = ViewModelProviders.of(this).get(NameViewModel.class);

//        create observers
        final Observer<String> nameObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                Log.e("mvvm", "1");
                tes.setText(s);
            }
        };

        final Observer<Integer> numberObserver = new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                Log.e("mvvm", integer.toString());
            }
        };



//        observe the live data
        viewModel.getCurrentName().observe(this, nameObserver);
        viewModel.getCurrentData().observe(this, numberObserver);

//        update live data
        tes3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rand = new Random();
                String s = tes2.getText().toString();
                viewModel.getCurrentName().setValue(s);
                viewModel.getCurrentData().setValue(rand.nextInt(50));
                Log.e("mvvm", "value setted");
            }
        });


    }
}
