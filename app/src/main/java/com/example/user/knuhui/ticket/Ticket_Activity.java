package com.example.user.knuhui.ticket;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.user.knuhui.BottomNaviSet;
import com.example.user.knuhui.R;


public class Ticket_Activity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private BottomNaviSet bottomNaviSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("번호표 발급");

        bottomNaviSet = new BottomNaviSet(this,this.getClass().getSimpleName());
        bottomNavigationView = bottomNaviSet.getBottomNavigationView();

        Button button2 = (Button)findViewById(R.id.button2);
        Button button1 = (Button)findViewById(R.id.button1);

        TabHost tabHost1 = (TabHost) findViewById(R.id.tabHost1) ;
        tabHost1.setup() ;

        // 첫 번째 Tab. (탭 표시 텍스트:"TAB 1"), (페이지 뷰:"content1")
        TabHost.TabSpec ts1 = tabHost1.newTabSpec("Tab Spec 1") ;
        ts1.setContent(R.id.tab1) ;
        ts1.setIndicator("발급") ;
        tabHost1.addTab(ts1)  ;

        // 두 번째 Tab. (탭 표시 텍스트:"TAB 2"), (페이지 뷰:"content2")
        TabHost.TabSpec ts2 = tabHost1.newTabSpec("Tab Spec 2") ;
        ts2.setContent(R.id.tab2) ;
        ts2.setIndicator("조회") ;
        tabHost1.addTab(ts2) ;

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"번호표가 발급되었습니다.",Toast.LENGTH_LONG).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListView listView = (ListView) findViewById(R.id.listView1);
                Ticket_ListViewAdapter adapter = new Ticket_ListViewAdapter();

                listView.setAdapter(adapter);

                adapter.addItem("135번","오후 03:31:12");
                adapter.addItem("138번","오후 03:32:04");
            }
        });

    }
}

//        if(findViewById(R.id.fragment_container)!=null){
//            if(savedInstanceState!=null){
//                return;
//            }
//            TicketIssue_Fragment fragment = new TicketIssue_Fragment();
//            fragment.setArguments(getIntent().getExtras());
//
//            getFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();
//
//
//        }
//    }
//
//    public void selectFragment(View view){
//        Fragment fr = null;
//
//        switch (view.getId()){
//            case R.id.issue:
//                fr = new TicketIssue_Fragment();
//                break;
//            case R.id.check:
//                fr = new TicketCheck_Fragment();
//        }
//
//        FragmentManager fm = getFragmentManager();
//        FragmentTransaction fragmentTransaction = fm.beginTransaction();
//        fragmentTransaction.replace(R.id.fragment_container,fr);
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.commit();
//    }

