package com.mydistroapps.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.mydistroapps.model.DetailPojo;
import com.mydistroapps.view.ItemView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dedi Dot on 8/25/2018.
 * Happy Coding!
 */

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private ItemView itemView;
    private List<DetailPojo> data = new ArrayList<>();

    public ListAdapter(Context context, List<DetailPojo> data) {
        this.mContext = context;
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView = new ItemView(parent.getContext());
        return itemView.viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        itemView.viewHolder = (ItemView.ViewHolder) holder;
        itemView.setData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
