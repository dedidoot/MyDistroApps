package com.mydistroapps.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mydistroapps.R;
import com.mydistroapps.databinding.MainActivityInject;

/**
 * Created by Dedi Dot on 25/08/2018.
 * Happy Coding!
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MainActivityInject inject;
    public final static String HAT = "hat";
    public final static String JEANS = "jeans";
    public final static String SHIRT = "shirt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject = DataBindingUtil.setContentView(this, R.layout.activity_main);
        inject.linearHat.setOnClickListener(this);
        inject.linearJeans.setOnClickListener(this);
        inject.linearShirt.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        Intent intent = new Intent(this, ListActivity.class);

        switch (view.getId()) {
            case R.id.linear_hat:
                intent.putExtra("is_from", HAT);
                startActivity(intent);
                break;
            case R.id.linear_jeans:
                intent.putExtra("is_from", JEANS);
                startActivity(intent);
                break;
            case R.id.linear_shirt:
                intent.putExtra("is_from", SHIRT);
                startActivity(intent);
                break;
        }
    }
}
