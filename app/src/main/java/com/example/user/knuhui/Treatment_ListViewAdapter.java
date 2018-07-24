package com.example.user.knuhui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Treatment_ListViewAdapter extends BaseAdapter {
    private ArrayList<TreatmentItem> listViewItemList = new ArrayList<TreatmentItem>() ;

    public Treatment_ListViewAdapter(){

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
            convertView = inflater.inflate(R.layout.treatment_item, parent, false);
        }

        TextView textView1 = (TextView)convertView.findViewById(R.id.name);
        TextView textView2 = (TextView)convertView.findViewById(R.id.dept);
        TextView textView3 = (TextView)convertView.findViewById(R.id.date);
        TextView textView4 = (TextView)convertView.findViewById(R.id.chemical_name);
        TextView textView5 = (TextView)convertView.findViewById(R.id.prescription_amount);
        TextView textView6 = (TextView)convertView.findViewById(R.id.number);
        TextView textView7 = (TextView)convertView.findViewById(R.id.days);
        TextView textView8 = (TextView)convertView.findViewById(R.id.usage_name);

        TreatmentItem listViewItem = listViewItemList.get(position);


        textView1.setText(listViewItem.getName());
        textView2.setText(listViewItem.getDept());
        textView3.setText(listViewItem.getDate());
        textView4.setText(listViewItem.getChemical_name());
        textView5.setText(listViewItem.getPrescription_amount());
        textView6.setText(listViewItem.getNumber());
        textView7.setText(listViewItem.getDays());
        textView8.setText(listViewItem.getUsage_name());

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

    public void addItem(String name, String dept, String date, String c_name, String p_amount, String num, String days, String u_name) {
        TreatmentItem item = new TreatmentItem();

        item.setNumber(name);
        item.setDept(dept);
        item.setDate(date);
        item.setChemical_name(c_name);
        item.setPrescription_amount(p_amount);
        item.setNumber(num);
        item.setDays(days);
        item.setUsage_name(u_name);

        listViewItemList.add(item);
    }
}
