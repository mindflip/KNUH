package com.example.user.knuhui.reservation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.user.knuhui.R;
import com.example.user.knuhui.networkmanager.model.reservation.search.getRevList.GetRevListResult;

import java.util.ArrayList;

public class Reservation_ListViewAdapter extends BaseAdapter{
    private ArrayList<ReservationItem> listViewItemList = new ArrayList<ReservationItem>() ;
    private TextView tvRevHistDept, tvRevHistDoc, tvRevHistDate, tvRevHistTime, tvRevHistKind;

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

        tvRevHistDept = (TextView) convertView.findViewById(R.id.tvRevHistDept);
        tvRevHistDoc = (TextView) convertView.findViewById(R.id.tvRevHistDoc);
        tvRevHistDate = (TextView) convertView.findViewById(R.id.tvRevHistDate);
        tvRevHistTime = (TextView) convertView.findViewById(R.id.tvRevHistTime);
        tvRevHistKind = (TextView) convertView.findViewById(R.id.tvRevHistKind);

        ReservationItem listViewItem = listViewItemList.get(position);

        tvRevHistDept.setText(listViewItem.getDept());
        tvRevHistDoc.setText(listViewItem.getDoctor());
        tvRevHistDate.setText(listViewItem.getDate());
        tvRevHistTime.setText(listViewItem.getTime());
        tvRevHistKind.setText(listViewItem.getReceiptGubunKindNm());

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

    public void addItem (GetRevListResult getRevListResult) {

    }
    public void addItem(String dept, String doctor, String date, String time, String kind) {
        ReservationItem item = new ReservationItem();

        item.setDept(dept);
        item.setDoctor(doctor);
        item.setDate(date);
        item.setTime(time);
        item.setReceiptGubunKindNm(kind);

        listViewItemList.add(item);
    }

    public void removeItem(int position) {
        listViewItemList.remove(position);

    }

    public void clear(){
        listViewItemList.clear();
    }

}
