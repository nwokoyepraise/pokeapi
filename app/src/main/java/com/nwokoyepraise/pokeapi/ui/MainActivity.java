package com.nwokoyepraise.pokeapi.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.TextView;

import com.nwokoyepraise.pokeapi.R;
import com.nwokoyepraise.pokeapi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainViewModel mainViewModel = new MainViewModel(getApplication());
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(mainViewModel                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 );
        activityMainBinding.executePendingBindings();

        //watch changes in viewModel
        mainViewModel.getResponse().observe(this, response ->{
            TextView tv = findViewById(R.id.tv);
            tv.setText(response);
        });
    }
}