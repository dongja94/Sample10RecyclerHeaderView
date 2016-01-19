package com.example.dongja94.samplerecyclerheaderview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by dongja94 on 2016-01-19.
 */
public class HeaderViewHolder extends RecyclerView.ViewHolder {

    public interface OnHeaderClickListener {
        public void onHeaderClick(View view, int position);
    }
    OnHeaderClickListener mClickListener;
    public void setOnHeaderClickListener(OnHeaderClickListener listener) {
        mClickListener = listener;
    }

    public HeaderViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mClickListener != null) {
                    mClickListener.onHeaderClick(v, getAdapterPosition());
                }
            }
        });
    }
}
