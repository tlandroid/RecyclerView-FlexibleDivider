package com.yqritc.recyclerviewflexibledivider.sample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by yqritc on 2015/01/08.
 */
public class SimpleStaggeredAdapter extends RecyclerView.Adapter<SimpleStaggeredAdapter.ViewHolder> {

    private LayoutInflater mLayoutInflater;

    public SimpleStaggeredAdapter(Context context) {
        super();
        mLayoutInflater = LayoutInflater.from(context);
    }

    RecyclerView recyclerView;
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        recyclerView = (RecyclerView)parent;
        View view = mLayoutInflater.inflate(R.layout.layout_sample_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mSampleText.setText(String.valueOf(position));

        StaggeredGridLayoutManager manager = (StaggeredGridLayoutManager)recyclerView.getLayoutManager();
        StaggeredGridLayoutManager.LayoutParams params = (StaggeredGridLayoutManager.LayoutParams)holder.mSampleText.getLayoutParams();
        if (manager.getOrientation() == StaggeredGridLayoutManager.HORIZONTAL)
        {
            params.width = (200 + (position % 3) * 30);
            params.height = StaggeredGridLayoutManager.LayoutParams.MATCH_PARENT;
        }
        else
        {
            params.width = StaggeredGridLayoutManager.LayoutParams.MATCH_PARENT;
            params.height = (200 + (position % 3) * 30);
        }
        holder.mSampleText.setLayoutParams(params);
    }

    @Override
    public int getItemCount() {
        return 33;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView mSampleText;

        public ViewHolder(View view) {
            super(view);
            mSampleText = (TextView) view.findViewById(R.id.text_sample);
        }
    }
}
