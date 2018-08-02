package com.example.user.knuhui.history;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.user.knuhui.R;

import java.util.ArrayList;

public class History1_ListViewAdapter extends BaseAdapter {
    private ArrayList<History1Item> listViewItemList = new ArrayList<History1Item>() ;

    public History1_ListViewAdapter(){

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
            convertView = inflater.inflate(R.layout.history1_item, parent, false);
        }

        TextView textView1 = (TextView)convertView.findViewById(R.id.dept);
        TextView textView2 = (TextView)convertView.findViewById(R.id.doctor);
        TextView textView3 = (TextView)convertView.findViewById(R.id.date);


        History1Item listViewItem = listViewItemList.get(position);


        textView1.setText(listViewItem.getDept());
        textView2.setText(listViewItem.getDoctor());
        textView3.setText(listViewItem.getDate());

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

    public void addItem(String dept, String doctor, String date) {
        History1Item item = new History1Item();

        item.setDept(dept);
        item.setDoctor(doctor);
        item.setDate(date);

        listViewItemList.add(item);
    }
}
