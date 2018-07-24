package com.example.user.knuhui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Reservation_ListViewAdapter extends BaseAdapter{
    private ArrayList<ReservationItem> listViewItemList = new ArrayList<ReservationItem>() ;

    public Reservation_ListViewAdapter(){

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
            convertView = inflater.inflate(R.layout.reservation_search_item, parent, false);
        }

        TextView textView1 = (TextView)convertView.findViewById(R.id.dept);
        TextView textView2 = (TextView)convertView.findViewById(R.id.doctor);
        TextView textView3 = (TextView)convertView.findViewById(R.id.date);
        TextView textView4 = (TextView)convertView.findViewById(R.id.time);

        ReservationItem listViewItem = listViewItemList.get(position);

        textView1.setText(listViewItem.getDept());
        textView2.setText(listViewItem.getDoctor());
        textView3.setText(listViewItem.getDate());
        textView4.setText(listViewItem.getTime());

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

    public void addItem(String dept, String doctor, String date, String time) {
        ReservationItem item = new ReservationItem();

        item.setDept(dept);
        item.setDoctor(doctor);
        item.setDate(date);
        item.setTime(time);

        listViewItemList.add(item);

    }

}
