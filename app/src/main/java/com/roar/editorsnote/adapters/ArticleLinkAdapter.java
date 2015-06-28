package com.roar.editorsnote.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.roar.editorsnote.R;
import com.roar.editorsnote.fragments.ArticleFragment;
import com.roar.editorsnote.fragments.ArticleListFragment;
import com.roar.editorsnote.model.ArticleLink;

import java.util.ArrayList;

public class ArticleLinkAdapter extends RecyclerView.Adapter<ArticleLinkAdapter.ViewHolder>{
    private ArrayList<ArticleLink> mArticleLinks;
    private String mSource = "";
    private FragmentActivity context;


    // Provide a suitable constructor (depends on the kind of dataset)
    public ArticleLinkAdapter(Context context, ArrayList<ArticleLink> articleLinks, String source) {
        this.context= (FragmentActivity) context;
        mArticleLinks = articleLinks;
        mSource = source;

    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public TextView mHeadline;
        public TextView mTimestamp;

        String mSource = "";
        public ViewHolder(View v, String source) {
            super(v);
            itemView.setOnClickListener(this);
            mHeadline = (TextView) v.findViewById(R.id.headline);
            mTimestamp = (TextView) v.findViewById(R.id.timestamp);

            mSource = source;
        }


        @Override
        public void onClick(View v) {
            Toast.makeText(context,mHeadline.getTag().toString(),Toast.LENGTH_SHORT).show();
            Fragment fragment = ArticleFragment.newInstance(mHeadline.getTag().toString());

            if (fragment != null) {
                FragmentManager fragmentManager = context.getSupportFragmentManager();
                fragmentManager.
                        beginTransaction().
                        addToBackStack(this.getClass().getName())
                        .replace(R.id.frame_container, fragment).commit();


            } else {
                // error in creating fragment
                Log.e("MainActivity", "Error in creating fragment");
            }

        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ArticleLinkAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.article_link_card_view, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v, mSource);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        //Log.e("Author", "headline" + position);
        holder.mHeadline.setText(mArticleLinks.get(position).getHeading());
        holder.mTimestamp.setText(mArticleLinks.get(position).getTimestamp());

        holder.mHeadline.setTag(mArticleLinks.get(position).getLink());
    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mArticleLinks.size();
    }

//    @Override
//    public void onClick(View view) {
//        ViewHolder holder = (ViewHolder) view.getTag();
//        int currentPosition = holder.getPosition();
//        Log.e("Author" , "Position " + currentPosition);
//        //mArticleLinks.get(position).getLink();
//    }

}


/*
if(mSource.equals(view.getContext().getString(R.string.hindu))){
                    mArticleLinks.get(po)
                }
                if(mSource.equals(view.getContext().getString(R.string.ht))){

                }
                if(mSource.equals(view.getContext().getString(R.string.et))){

                }
                if(mSource.equals(view.getContext().getString(R.string.toi))){

                }
                if(mSource.equals(view.getContext().getString(R.string.ie))){

                }
 */