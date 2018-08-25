package com.mydistroapps.view;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mydistroapps.R;
import com.mydistroapps.presenter.RefreshMainLayout;


/**
 * Created by Dedi Dot on 4/25/2018.
 * Happy Codding!
 */
public class MainLayout extends FrameLayout {

    public RecyclerView list;
    public SwipeRefreshLayout swipe_refresh;
    public RelativeLayout layout_loading;
    private ProgressBar pre_loader;
    private TextView text_error, text_error2;
    private Context context;
    public static final String CONNECTION_ERROR = "-1", DATA_EMPTY = "204", INTERNAL_SERVER_ERROR = "500",
            LOGIN_FIRST = "-9";
    private RefreshMainLayout onClickTxtError;
    private LinearLayout linear_status;
    public String statusLayout = "";
    public LinearLayout linear_main_layout;

    public MainLayout(Context context) {
        super(context);
        init(context);
    }

    public MainLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MainLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        inflate(context, R.layout.main_layout, this);
        list = findViewById(R.id.list);
        linear_main_layout = findViewById(R.id.linear_main_layout);
        swipe_refresh = findViewById(R.id.swipe_refresh);

        layout_loading = findViewById(R.id.layout_loading);
        pre_loader = findViewById(R.id.pre_loader);
        text_error = findViewById(R.id.text_error);
        text_error2 = findViewById(R.id.text_error2);
        linear_status = findViewById(R.id.linear_status);
        linear_status.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickTxtError.refreshMainLayout();
                hideLoading();
                showLoading();
            }
        });
    }

    public void refreshPage(RefreshMainLayout onClickTxtError) {
        this.onClickTxtError = onClickTxtError;
    }

    public void showLoading() {
        swipe_refresh.setVisibility(View.GONE);
        layout_loading.setVisibility(View.VISIBLE);
        pre_loader.setVisibility(View.VISIBLE);
        linear_status.setVisibility(GONE);
    }

    public void refreshThisPage() {
        hideLoading();
        showLoading();
    }

    public void isEnableSwipeRefresh(boolean isOkay) {
        swipe_refresh.setEnabled(isOkay);
    }

    public void showSnackbar() {
        Snackbar.make(swipe_refresh, context.getString(R.string.error_connection), Snackbar.LENGTH_SHORT).show();
    }

    public void hideLoading() {
        layout_loading.setVisibility(View.GONE);
        swipe_refresh.setVisibility(View.VISIBLE);
        linear_status.setVisibility(GONE);
        statusLayout = "";
        if (swipe_refresh.isRefreshing()) {
            swipe_refresh.setRefreshing(false);
        }
    }

    public void status(CharSequence status) {
        if (status.equals(DATA_EMPTY)) {
            layout_loading.setVisibility(View.VISIBLE);
            swipe_refresh.setVisibility(View.GONE);
            pre_loader.setVisibility(View.GONE);
            linear_status.setClickable(true);
            linear_status.setVisibility(VISIBLE);
            text_error.setText(context.getString(R.string.data_empty));
            text_error2.setVisibility(VISIBLE);
            statusLayout = DATA_EMPTY;
        } else if (status.equals(CONNECTION_ERROR)) {
            layout_loading.setVisibility(View.VISIBLE);
            swipe_refresh.setVisibility(View.GONE);
            pre_loader.setVisibility(View.GONE);
            linear_status.setClickable(true);
            linear_status.setVisibility(VISIBLE);
            text_error.setText(context.getString(R.string.error_connection));
            text_error2.setText(context.getString(R.string.message_check_connection));
            text_error2.setVisibility(VISIBLE);
            statusLayout = CONNECTION_ERROR;
        } else if (status.equals(LOGIN_FIRST)) {
            layout_loading.setVisibility(View.VISIBLE);
            swipe_refresh.setVisibility(View.GONE);
            pre_loader.setVisibility(View.GONE);
            linear_status.setClickable(true);
            linear_status.setVisibility(VISIBLE);
            text_error.setText(context.getString(R.string.login_first));
            text_error2.setVisibility(VISIBLE);
            text_error2.setText(context.getString(R.string.message_login_first));
            statusLayout = LOGIN_FIRST;
        } else if (status.equals(INTERNAL_SERVER_ERROR)) {
            layout_loading.setVisibility(View.VISIBLE);
            swipe_refresh.setVisibility(View.GONE);
            pre_loader.setVisibility(View.GONE);
            linear_status.setClickable(true);
            linear_status.setVisibility(VISIBLE);
            text_error.setText(context.getString(R.string.internal_server_error));
            text_error2.setVisibility(VISIBLE);
            statusLayout = INTERNAL_SERVER_ERROR;
        } else {
            layout_loading.setVisibility(View.VISIBLE);
            swipe_refresh.setVisibility(View.GONE);
            pre_loader.setVisibility(View.GONE);
            linear_status.setClickable(true);
            linear_status.setVisibility(VISIBLE);
            text_error.setText(status);
            text_error2.setVisibility(VISIBLE);
            text_error2.setText(context.getString(R.string.tap_here_for_refresh));
            statusLayout = INTERNAL_SERVER_ERROR;
        }
        if (swipe_refresh.isRefreshing()) {
            swipe_refresh.setRefreshing(false);
        }
    }

}
