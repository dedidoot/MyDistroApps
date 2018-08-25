package com.mydistroapps.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;

import com.mydistroapps.adapter.ListAdapter;
import com.mydistroapps.api.ApiRequest;
import com.mydistroapps.model.BasePojo;
import com.mydistroapps.model.DetailPojo;
import com.mydistroapps.presenter.RefreshMainLayout;
import com.mydistroapps.view.MainLayout;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;

/**
 * Created by Dedi Dot on 8/25/2018.
 * Happy Coding!
 */

public class ListActivity extends AppCompatActivity implements RefreshMainLayout{

    private MainLayout mainLayout;
    private ApiRequest apiRequest;
    private ListAdapter listAdapter;
    private List<DetailPojo> data = new ArrayList<>();
    private String IS_FROM = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        IS_FROM = getIntent().getStringExtra("is_from");

        getSupportActionBar().setTitle(IS_FROM.toUpperCase());

        mainLayout = new MainLayout(ListActivity.this);

        apiRequest = new ApiRequest();

        mainLayout.showLoading();
        mainLayout.showLoading();

        mainLayout.refreshPage(this);

        mainLayout.swipe_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData(true);
            }
        });

        listAdapter = new ListAdapter(this, data);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mainLayout.list.setLayoutManager(linearLayoutManager);
        mainLayout.list.setAdapter(listAdapter);

        setContentView(mainLayout);

        getData(true);

    }

    private void getData(final boolean isNeedRefresh) {

        if (IS_FROM.equals(MainActivity.HAT)) {

            apiRequest.getHat().subscribe(new Observer<BasePojo>() {
                @Override
                public void onCompleted() {
                }

                @Override
                public void onError(Throwable e) {
                    mainLayout.status(MainLayout.CONNECTION_ERROR);
                }

                @Override
                public void onNext(BasePojo basePojo) {
                    if (basePojo != null && basePojo.status) {

                        if (isNeedRefresh) {
                            data.clear();
                        }

                        data.addAll(basePojo.detailPojos);
                        listAdapter.notifyDataSetChanged();

                        mainLayout.hideLoading();

                    } else {
                        mainLayout.status(MainLayout.CONNECTION_ERROR);
                    }
                }
            });

        } else if (IS_FROM.equals(MainActivity.JEANS)) {

            apiRequest.getJeans().subscribe(new Observer<BasePojo>() {
                @Override
                public void onCompleted() {
                }

                @Override
                public void onError(Throwable e) {
                    mainLayout.status(MainLayout.CONNECTION_ERROR);
                }

                @Override
                public void onNext(BasePojo basePojo) {
                    if (basePojo != null && basePojo.status) {

                        if (isNeedRefresh) {
                            data.clear();
                        }

                        data.addAll(basePojo.detailPojos);
                        listAdapter.notifyDataSetChanged();

                        mainLayout.hideLoading();

                    } else {
                        mainLayout.status(MainLayout.CONNECTION_ERROR);
                    }
                }
            });

        } else if (IS_FROM.equals(MainActivity.SHIRT)) {

            apiRequest.getShirt().subscribe(new Observer<BasePojo>() {
                @Override
                public void onCompleted() {
                }

                @Override
                public void onError(Throwable e) {
                    mainLayout.status(MainLayout.CONNECTION_ERROR);
                }

                @Override
                public void onNext(BasePojo basePojo) {
                    if (basePojo != null && basePojo.status) {

                        if (isNeedRefresh) {
                            data.clear();
                        }

                        data.addAll(basePojo.detailPojos);
                        listAdapter.notifyDataSetChanged();

                        mainLayout.hideLoading();

                    } else {
                        mainLayout.status(MainLayout.CONNECTION_ERROR);
                    }
                }
            });

        }


    }

    @Override
    public void refreshMainLayout() {
        getData(true);
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
