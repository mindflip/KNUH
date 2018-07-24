package com.example.user.knuhui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Wait_ListViewAdapter extends BaseAdapter {
    private ArrayList<WaitItem> listViewItemList = new ArrayList<WaitItem>() ;

    public Wait_ListViewAdapter() {

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
            convertView = inflater.inflate(R.layout.wait_item, parent, false);
        }

        TextView textView1 = (TextView)convertView.findViewById(R.id.dept);
        TextView textView2 = (TextView)convertView.findViewById(R.id.wait);
        TextView textView3 = (TextView)convertView.findViewById(R.id.time);


        WaitItem listViewItem = listViewItemList.get(position);


        textView1.setText(listViewItem.getDept());
        textView2.setText(listViewItem.getWait());
        textView3.setText(listViewItem.getTime());

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

    public void addItem(String dept, String wait, String time) {
        WaitItem item = new WaitItem();

        item.setDept(dept);
        item.setWait(wait);
        item.setTime(time);

        listViewItemList.add(item);
    }
}


