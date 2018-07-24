package com.example.user.knuhui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Profile_ListViewAdapter extends BaseAdapter{
    private ArrayList<ProfileItem> listViewItemList = new ArrayList<>() ;

    public Profile_ListViewAdapter(){

    }

    @Override
    public int getCount() {
        return listViewItemList.size() ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.setting_item, parent, false);
        }

        TextView textView1 = (TextView)convertView.findViewById(R.id.textview1);
        ImageView imageView1 = (ImageView)convertView.findViewById(R.id.imageview1);


        ProfileItem listViewItem = listViewItemList.get(position);


        textView1.setText(listViewItem.getMenu());
        imageView1.setImageDrawable(listViewItem.getDrawable());
        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position ;
    }
    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position) ;
    }

    public void addItem(String menu, Drawable drawable) {
        ProfileItem item = new ProfileItem();

        item.setMenu(menu);
        item.setDrawable(drawable);

        listViewItemList.add(item);
    }
}
