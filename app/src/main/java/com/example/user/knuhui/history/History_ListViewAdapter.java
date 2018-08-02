package com.example.user.knuhui.history;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.knuhui.R;

import java.util.ArrayList;

public class History_ListViewAdapter extends BaseAdapter{
    private ArrayList<HistoryItem> listViewItemList = new ArrayList<HistoryItem>() ;

    public History_ListViewAdapter(){

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
            convertView = inflater.inflate(R.layout.history_item, parent, false);
        }

        TextView textView1 = (TextView)convertView.findViewById(R.id.textview1);
        ImageView imageView1 = (ImageView)convertView.findViewById(R.id.imageview1);


        HistoryItem listViewItem = listViewItemList.get(position);


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
        HistoryItem item = new HistoryItem();

        item.setMenu(menu);
        item.setDrawable(drawable);

        listViewItemList.add(item);
    }
}
