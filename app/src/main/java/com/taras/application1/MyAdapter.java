package com.taras.application1;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> { //[Comment] Your adapter? Use correct names
    private String[] mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView; //[Comment] Wrong visibility modifier. Wrong formatting
        public ViewHolder(View v) {
            super(v);
            mImageView = (ImageView) v;
        }
    }

    public MyAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.image, parent, false);
        // set the view's size, margins, paddings and layout parameters
        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Context context = holder.mImageView.getContext();

        Picasso.with(context)
                .load(Uri.parse(mDataset[position]))
                .fit()
                .centerCrop()
                .into(holder.mImageView);

        final String message = mDataset[position];

        holder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtils.show(context, message);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}

