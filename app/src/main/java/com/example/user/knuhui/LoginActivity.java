package com.example.user.knuhui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.knuhui.networkmanager.service.TempUsers;

import java.io.UnsupportedEncodingException;

public class LoginActivity extends AppCompatActivity {

    private Button btLogin;
    private EditText etLoginId, etLoginPw;
    private String id,pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        initLayout();

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
//                id = etLoginId.getText().toString();
//                pw = etLoginPw.getText().toString();
//
//                if(id.equals("") || pw.equals("")) {
//                    Toast.makeText(LoginActivity.this, "아이디 또는 비밀번호를 필수로 입력하세요.", Toast.LENGTH_SHORT).show();
//                    return;
//                } else {
//
//                }
//
//                Log.d("loginIDPWTEST", id + " //////////// " + pw);
//
//                if (id.equals(TempUsers.EMR_TEST_USER1) && pw.equals(TempUsers.TEST_USER_PW)) {
//                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                    intent.putExtra("pId", id);
//                    startActivity(intent);
//                    finish();
//                } else {
//                    Toast.makeText(LoginActivity.this, "등록된 회원이 아닙니다.", Toast.LENGTH_SHORT).show();
//                }

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("pId", "93888");
                startActivity(intent);
                finish();
            }
        });
    }

    private void initLayout() {
        btLogin = (Button) findViewById(R.id.btLogin);
        etLoginId = (EditText) findViewById(R.id.etLoginId);
        etLoginPw = (EditText) findViewById(R.id.etLoginPw);
    }
}
