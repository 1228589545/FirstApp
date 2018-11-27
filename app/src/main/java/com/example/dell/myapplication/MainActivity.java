package com.example.dell.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    private EditText mNameET;
    private EditText mCompET;
    private EditText mPhoneET;
    private EditText mEmailET;
    private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = getSharedPreferences("data", Context.MODE_PRIVATE);
        mNameET = (EditText) findViewById(R.id.et_name);
        mCompET = (EditText) findViewById(R.id.et_comp);
        mPhoneET = (EditText) findViewById(R.id.et_phone);
        mEmailET = (EditText) findViewById(R.id.et_email);
        findViewById(R.id.btn_save).setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save:
                if(!TextUtils.isEmpty(mNameET.getText().toString().trim())){
                    //将输入信息存储起来
                    SharedPreferences.Editor edit = sp.edit();
                    edit.putString("name",
                            mNameET.getText().toString().trim());
                    edit.putString("comp",
                            mCompET.getText().toString().trim());
                    edit.putString("phone",
                            mPhoneET.getText().toString().trim());
                    edit.putString("email",
                            mEmailET.getText().toString().trim());
                    edit.commit();
                    Intent intent = new Intent(MainActivity.this,ShowUserInfoActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }else{
                    Toast.makeText(this, "姓名不能为空", 0).show();
                }
                break;
        }
    }
}
