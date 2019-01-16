package com.example.user.knuhui.reservation;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.knuhui.BottomNaviSet;
import com.example.user.knuhui.MainActivity;
import com.example.user.knuhui.R;
import com.example.user.knuhui.networkmanager.NetworkManager;
import com.example.user.knuhui.networkmanager.model.reservation.search.getRevList.GetRevList;
import com.example.user.knuhui.networkmanager.model.reservation.search.getRevList.GetRevListResult;
import com.example.user.knuhui.networkmanager.model.reservation.search.putRevCancel.PutRevCancel;
import com.example.user.knuhui.networkmanager.model.reservation.search.putRevCancel.PutRevCancelResult;
import com.example.user.knuhui.networkmanager.service.RelayService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Reservation_Search_Activity extends AppCompatActivity {

    private RelayService relayService;

    private AlertDialog.Builder alertDialogBuilder;
    private ListView lvReservationList;
    private Reservation_ListViewAdapter adapter;
    private Button btGetRevList;

    private BottomNavigationView bottomNavigationView;
    private BottomNaviSet bottomNaviSet;

    private List<GetRevListResult> getRevListResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_search);

        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("예약 조회");

        bottomNaviSet = new BottomNaviSet(this, this.getClass().getSimpleName());
        bottomNavigationView = bottomNaviSet.getBottomNavigationView();

        relayService = NetworkManager.getRelayService();

        getRevList();

        initLayout();
    }

    ListView.OnItemLongClickListener onItemLongClickListener = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

            final GetRevListResult selectedItem = getRevListResult.get(position);

            String itemDept = selectedItem.getDepartmentNm();
            String itemDoc = selectedItem.getDoctorNm();
            String itemDate = selectedItem.getDataDate();

            Log.i("checkItem", id + "     //////////" + position + "    @@@@@@@@@@@@@" + itemDept + itemDate);

            AlertDialog alertDialog = new AlertDialog.Builder(Reservation_Search_Activity.this).create();
            alertDialog.setTitle("예약취소");
            alertDialog.setMessage(itemDept + "\n" + itemDoc + "\n" + itemDate);
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "예",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            putRevCancel(selectedItem.getDepartmentCd(), selectedItem.getDoctorId(), selectedItem.getDataDate(), "전산실.", "93888", selectedItem.getReceiptNo());

                            dialog.dismiss();
                        }
                    });
            alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "아니오",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();

            return false;
        }
    };

    private void getRevList() {
        Call<GetRevList> call = relayService.getRevList("93888", "20180101","20191231");

        call.enqueue(new Callback<GetRevList>() {
            @Override
            public void onResponse(Call<GetRevList> call, Response<GetRevList> response) {
                if(response.isSuccessful() && response.body()!=null) {
                    getRevListResult = response.body().getResultinfo().getResult();
                    callListItems();
                }
            }

            @Override
            public void onFailure(Call<GetRevList> call, Throwable t) {
                Log.e("Not Response", t.getLocalizedMessage());
                Toast.makeText(Reservation_Search_Activity.this, "서버와 연결이 불안정합니다.\n해당 화면에 다시 접속해주세요.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void putRevCancel(String departmentCd, String doctorId, String dataDate, String pNm, String pId, String receiptNo) {
        Call<PutRevCancel> call = relayService.putRevCancel(departmentCd, doctorId, dataDate, pNm, pId, receiptNo);

        call.enqueue(new Callback<PutRevCancel>() {
            @Override
            public void onResponse(Call<PutRevCancel> call, Response<PutRevCancel> response) {
                if(response.isSuccessful() && response.body() != null) {
                    PutRevCancelResult result = response.body().getResultinfo().getResult();

                    if (result.getCount().equals("1")){
                        Toast.makeText(getApplicationContext(), "예약이 취소되었습니다.", Toast.LENGTH_SHORT).show();
                        getRevList();
                    }
                }
            }

            @Override
            public void onFailure(Call<PutRevCancel> call, Throwable t) {
                Log.e("Not Response", t.getLocalizedMessage());
                Toast.makeText(Reservation_Search_Activity.this, "서버와 연결이 불안정합니다.\n해당 화면에 다시 접속해주세요.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initLayout() {
        btGetRevList = (Button) findViewById(R.id.btReservationList);
        lvReservationList = (ListView) findViewById(R.id.lvReservationList);

        adapter = new Reservation_ListViewAdapter();
        lvReservationList.setAdapter(adapter);

        btGetRevList.setOnClickListener(onClickListener);
        lvReservationList.setOnItemLongClickListener(onItemLongClickListener);
    }

    Button.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            callListItems();
        }
    };

    private void callListItems() {
        adapter.clear();

        if(getRevListResult == null) {
            Toast.makeText(getApplicationContext(),"서버에서 값을 불러오지 못 했습니다.", Toast.LENGTH_SHORT).show();
        } else {
            for(GetRevListResult item : getRevListResult) {
                adapter.addItem(item.getDepartmentNm(), item.getDoctorNm(), item.getDataDate(), item.getDataTime(), item.getReceiptGubunKindNm());
            }
        }

        adapter.notifyDataSetChanged();
    }
}