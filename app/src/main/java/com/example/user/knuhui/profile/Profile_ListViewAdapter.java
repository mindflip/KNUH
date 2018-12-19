package com.example.user.knuhui.profile;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.knuhui.R;

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

        ImageView ivListIcon = (ImageView) convertView.findViewById(R.id.ivListIcon);
        TextView tvListTitle = (TextView)convertView.findViewById(R.id.tvListTitle);
        ImageView ivListArrow = (ImageView)convertView.findViewById(R.id.ivListArrow);

        ProfileItem listViewItem = listViewItemList.get(position);

        ivListIcon.setImageDrawable(listViewItem.getDrawableIcon());
        tvListTitle.setText(listViewItem.getMenu());
        ivListArrow.setImageDrawable(listViewItem.getDrawable());
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

    public void addItem(Drawable icon, String menu, Drawable arrow) {
        ProfileItem item = new ProfileItem();

        item.setDrawableIcon(icon);
        item.setMenu(menu);
        item.setDrawable(arrow);

        listViewItemList.add(item);
    }
}
