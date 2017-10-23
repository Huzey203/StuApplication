package com.example.hzy.stuapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Hzy on 2017/10/23.
 */

public class secActivity extends AppCompatActivity{
    private TextView edit3;
    private TextView edit4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_sec);
        this.initView();
        Intent intent = this.getIntent();
        String infoUserName = intent.getStringExtra(stuActivity.INFO_NAME);
        String infoPerSign = intent.getStringExtra(stuActivity.INFO_AGE);
        edit3.setText(infoUserName);
        edit4.setText(infoPerSign);
     }

    private void initView() {
        edit3 = (TextView) this.findViewById(R.id.text_n);
        edit4 = (TextView) this.findViewById(R.id.text_a);
    }
}
