package com.example.user.knuhui.treatment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.user.knuhui.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Treatment_ListViewAdapter extends BaseAdapter {
    private ArrayList<TreatmentItem> listViewItemList = new ArrayList<TreatmentItem>() ;

    private TextView tvPrescListDept, tvPrescListDate, tvPrescListMed, tvPrescListUsg, tvPrescListEff, tvPrescListDan;

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

        tvPrescListDept = (TextView) convertView.findViewById(R.id.tvPrescListDept);
        tvPrescListDate = (TextView) convertView.findViewById(R.id.tvPrescListDate);
        tvPrescListMed = (TextView) convertView.findViewById(R.id.tvPrescListMed);
        tvPrescListUsg = (TextView) convertView.findViewById(R.id.tvPrescListUsg);
        tvPrescListEff = (TextView) convertView.findViewById(R.id.tvPrescListEff);
        tvPrescListDan = (TextView) convertView.findViewById(R.id.tvPrescListDan);

        TreatmentItem listViewItem = listViewItemList.get(position);

        tvPrescListDept.setText(listViewItem.getDept());
        tvPrescListDate.setText(listViewItem.getDate());
        tvPrescListMed.setText(listViewItem.getMedicineNm());
        tvPrescListUsg.setText(listViewItem.getUsageNm());
        tvPrescListEff.setText(listViewItem.getEffectNm());
        tvPrescListDan.setText(listViewItem.getDangerNote());

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

    public void addItem(String dept, String date, String med, String usg, String eff, String dan) {
        TreatmentItem item = new TreatmentItem();

        item.setDept(dept);
        item.setDate(date);
        item.setMedicineNm(med);
        item.setUsageNm(usg);
        item.setEffectNm(eff);
        item.setDangerNote(dan);

        listViewItemList.add(item);
    }
}
