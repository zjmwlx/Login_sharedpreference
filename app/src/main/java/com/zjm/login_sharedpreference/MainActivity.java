package com.zjm.login_sharedpreference;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etUserName;
    private EditText etPassWord;
    private CheckBox cbRember;
    private Button btnLogin;
    private String username = null;
    private String password = null;


    private HashMap<String, String> hashmap = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        setOnClick();
        //回显数据
        getUser();


    }

    private void getUser() {
        hashmap = UseInfoUtils.getUser(this);
        if (hashmap != null) {
            String username = hashmap.get("username").toString();
            String password = hashmap.get("password").toString();
            etUserName.setText(username);
            etPassWord.setText(password);
        }
    }

    private void setOnClick() {
        btnLogin.setOnClickListener(this);

    }

    private void initview() {
        etUserName = (EditText) findViewById(R.id.et_usename);
        etPassWord = (EditText) findViewById(R.id.et_password);
        cbRember = (CheckBox) findViewById(R.id.cb_rember_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                boolean isrember = cbRember.isChecked();
                username = etUserName.getText().toString().trim();
                password = etPassWord.getText().toString();
                if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
                    Toast.makeText(this, username + "登录成功", Toast.LENGTH_SHORT).show();

                        UseInfoUtils.saveUser(this, username, password, isrember);

                } else {
                    Toast.makeText(this, "请输入正确的用户名和密码！", Toast.LENGTH_SHORT).show();
                }
        }
    }
}
