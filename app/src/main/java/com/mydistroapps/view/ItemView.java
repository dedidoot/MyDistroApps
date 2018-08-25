package com.mydistroapps.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.mydistroapps.R;
import com.mydistroapps.activity.DetailActivity;
import com.mydistroapps.helper.ImageUtils;
import com.mydistroapps.model.DetailPojo;

/**
 * Created by Dedi Dot on 8/24/2018.
 * Happy Codding!
 */

public class ItemView extends FrameLayout {

    private Context context;
    public ViewHolder viewHolder;
    private ImageUtils imageUtils;

    public ItemView(Context context) {
        super(context);
        init(context);
    }

    public ItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        imageUtils = new ImageUtils();
        inflate(context, R.layout.item_view, this);
        viewHolder = new ViewHolder(this);
    }

    public void setData(final DetailPojo detailPojo) {
        viewHolder.item_name.setText(detailPojo.name);
        imageUtils.showImageDefault(context, viewHolder.item_image, detailPojo.imageUrl);
        viewHolder.linear_item_view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("data", new Gson().toJson(detailPojo));
                context.startActivity(intent);
            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout linear_item_view;
        private TextView item_name;
        private ImageView item_image;

        public ViewHolder(View view) {
            super(view);
            linear_item_view = view.findViewById(R.id.linear_item_view);
            item_name = view.findViewById(R.id.item_name);
            item_image = view.findViewById(R.id.item_image);
        }
    }

}
