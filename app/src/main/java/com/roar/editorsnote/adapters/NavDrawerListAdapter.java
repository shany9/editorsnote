package com.roar.editorsnote.adapters;




import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.roar.editorsnote.R;
import com.roar.editorsnote.model.NavDrawerItem;

public class NavDrawerListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<NavDrawerItem> navDrawerItems;

    public NavDrawerListAdapter(Context context, ArrayList<NavDrawerItem> navDrawerItems){
        this.context = context;
        this.navDrawerItems = navDrawerItems;
    }

    @Override
    public int getCount() {
        return navDrawerItems.size();
    }

    @Override
    public Object getItem(int position) {
        return navDrawerItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.drawer_list_item, null);
        }

        TextView txtTitle = (TextView) convertView.findViewById(R.id.title);
        ImageView startImgIcon = (ImageView) convertView.findViewById(R.id.starticon);
        ImageView endImgIcon = (ImageView) convertView.findViewById(R.id.endicon);


        txtTitle.setText(navDrawerItems.get(position).getTitle());


        endImgIcon.setImageResource(navDrawerItems.get(position).getEndIcon());
        startImgIcon.setImageResource(navDrawerItems.get(position).getStartIcon());
        if(navDrawerItems.get(position).getStartIconVisibility()){
            startImgIcon.setVisibility(View.VISIBLE);
            Log.e("Author" , "icon set");
        }else{
            startImgIcon.setVisibility(View.GONE);
        }

        if(navDrawerItems.get(position).getEndIconVisibility()){
            endImgIcon.setVisibility(View.VISIBLE);
        }else{
            endImgIcon.setVisibility(View.GONE);
        }

        return convertView;
    }

}
