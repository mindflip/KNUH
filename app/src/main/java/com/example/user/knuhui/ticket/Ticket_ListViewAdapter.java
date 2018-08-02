package com.example.user.knuhui.ticket;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.user.knuhui.R;

import java.util.ArrayList;

public class Ticket_ListViewAdapter extends BaseAdapter {
    private ArrayList<TicketItem> listViewItemList = new ArrayList<TicketItem>() ;

    public Ticket_ListViewAdapter(){

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
            convertView = inflater.inflate(R.layout.ticket_item, parent, false);
        }

        TextView textView1 = (TextView)convertView.findViewById(R.id.number);
        TextView textView2 = (TextView)convertView.findViewById(R.id.time);

        TicketItem listViewItem = listViewItemList.get(position);


        textView1.setText(listViewItem.getNumber());
        textView2.setText(listViewItem.getTime());

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

    public void addItem(String number,String time) {
        TicketItem item = new TicketItem();

        item.setNumber(number);
        item.setTime(time);

        listViewItemList.add(item);
    }
}
