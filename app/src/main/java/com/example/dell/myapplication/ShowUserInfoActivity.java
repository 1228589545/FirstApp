package com.example.dell.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Dell on 2018/11/27.
 */

public class ShowUserInfoActivity extends Activity {
    private TextView mNameTV;
	private TextView mCompTV;
 	private TextView mEmailTV;
 	private TextView mPhoneTV;
 	private SharedPreferences sp;
 	@Override
 	protected void onCreate(Bundle savedInstanceState) {
        		super.onCreate(savedInstanceState);
        		sp = getSharedPreferences("data", Context.MODE_PRIVATE);
        		setContentView(R.layout.showuserinfoactivity);
        		mNameTV = (TextView) findViewById(R.id.tv_name);
        		mCompTV = (TextView) findViewById(R.id.tv_comp);
        		mEmailTV = (TextView) findViewById(R.id.tv_email);
        		mPhoneTV = (TextView) findViewById(R.id.tv_phone);
        		// 取出sp里面存储的相应信息
        		mNameTV.setText(sp.getString("name", "name"));
        		mCompTV.setText(sp.getString("comp", "comp"));
        		mEmailTV.setText(sp.getString("email", "email"));
        		mPhoneTV.setText(sp.getString("phone", "phone"));
        	}
}
