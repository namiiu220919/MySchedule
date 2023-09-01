package com.example.myschedule.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myschedule.R;

public class DangKy extends AppCompatActivity {
    EditText edtUsernamedk,edtPassworddk;
    Button btnSignup;
    TKMKDao nddao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        TextView txtBack = findViewById(R.id.txtBack);
        edtUsernamedk = findViewById(R.id.edtUsernamedk);
        edtPassworddk = findViewById(R.id.edtPassworddk);
        btnSignup = findViewById(R.id.btnSignup);
        nddao = new TKMKDao(getApplicationContext());

        txtBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUsernamedk.getText().toString();
                String pass = edtPassworddk.getText().toString();
                if (TextUtils.isEmpty(user)){
                    Toast.makeText(DangKy.this, "Vui lòng nhập tên đăng nhập", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(DangKy.this, "Vui lòng nhập mật khẩu", Toast.LENGTH_SHORT).show();
                }else {
                    TKMK nd = new TKMK(user, pass);
                    if (nddao.insert(nd)){
                        Toast.makeText(DangKy.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(DangKy.this, DangNhap.class));
                    }else {
                        Toast.makeText(DangKy.this, "Đăng ký Fail", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}