package com.example.dongja94.samplerecyclerheaderview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dongja94 on 2016-01-19.
 */
public class HeaderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements HeaderViewHolder.OnHeaderClickListener{
    List<Header> headers = new ArrayList<Header>();
    List<String> items = new ArrayList<String>();

    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_ITEM = 100;

    public void addHeader(View headerView,Object data, boolean isClick) {
        Header header = new Header();
        header.headerView = headerView;
        header.data = data;
        header.isClickable = isClick;
        headers.add(header);
        notifyDataSetChanged();
    }

    public void add(String item) {
        items.add(item);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (position < headers.size()) return VIEW_TYPE_HEADER + position;
        return VIEW_TYPE_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_ITEM :
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item, parent, false);
                return new ItemViewHolder(view);
            default:
                Header headerData = headers.get(viewType);
                HeaderViewHolder holder = new HeaderViewHolder(headerData.headerView);
                holder.setOnHeaderClickListener(this);
                return holder;
        }
    }

    @Override
    public void onHeaderClick(View view, int position) {
        Header header = headers.get(position);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position >= headers.size()) {
            int index = position - headers.size();
            ((ItemViewHolder)holder).setText(items.get(index));
        }
    }

    @Override
    public int getItemCount() {
        return headers.size() + items.size();
    }
}
