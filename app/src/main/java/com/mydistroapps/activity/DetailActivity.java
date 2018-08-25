package com.mydistroapps.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.mydistroapps.R;
import com.mydistroapps.databinding.MyDetailActivityInject;
import com.mydistroapps.helper.ImageUtils;
import com.mydistroapps.model.DetailPojo;

/**
 * Created by Dedi Dot on 8/25/2018.
 * Happy Coding!
 */

public class DetailActivity extends AppCompatActivity {

    private MyDetailActivityInject inject;
    private DetailPojo detailPojo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject = DataBindingUtil.setContentView(this, R.layout.detail_activity);

        detailPojo = new Gson().fromJson(getIntent().getStringExtra("data"), DetailPojo.class);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle(detailPojo.name);

        ImageUtils imageUtils = new ImageUtils();

        imageUtils.showImageDefault(this, inject.image, detailPojo.imageUrl);

        inject.name.setText(detailPojo.name);
        inject.description.setText(detailPojo.description);
        inject.price.setText(detailPojo.price);
        inject.brand.setText(detailPojo.brand);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
