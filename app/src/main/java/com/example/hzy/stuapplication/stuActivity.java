package com.example.hzy.stuapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;

public class stuActivity extends AppCompatActivity {

    private CheckBox chk1, chk2, chk3;
    private EditText edit1;
    private EditText edit2;
    private Button button;

    public static final String INFO_NAME = "INFO_NAME";
    public static final String INFO_AGE = "INFO_AGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu);
        addListenerOnCheck1();
        addListenerOnCheck2();
        addListenerOnCheck3();

        List<String> list = new ArrayList<String>();
            list.add("软工1501");
            list.add("软工1502");
            list.add("软工1503");
            list.add("软工1504");

        Button button = (Button) findViewById(R.id.button) ;
        //edit = (EditText) findViewById(R.id.edit_name);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                Toast.makeText(stuActivity.this,"保存成功！",
                    Toast.LENGTH_SHORT).show();
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        Spinner sp = (Spinner) findViewById(R.id.spi_class);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            // parent： 为控件Spinner   view：显示文字的TextView   position：下拉选项的位置从0开始  
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //TextView tvResult = (TextView) findViewById(R.id.text_class);
            //获取Spinner控件的适配器
                ArrayAdapter<String> adapter = (ArrayAdapter<String>) parent.getAdapter();
                //tvResult.setText(adapter.getItem(position));
            }
            //没有选中时的处理
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        this.initView();
    }

    private void addListenerOnCheck1() {
        chk1 = (CheckBox) findViewById(R.id.checkBox1);
        chk2 = (CheckBox) findViewById(R.id.checkBox2);
        chk3 = (CheckBox) findViewById(R.id.checkBox3);
        chk2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                StringBuffer result = new StringBuffer();
                result.append(" soccer : ").append
                        (chk1.isChecked());
                result.append(" basketball : ").append
                        (chk2.isChecked());
                result.append(" movie : ").append
                        (chk3.isChecked());

                Toast.makeText(stuActivity.this, result.toString(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
    private void addListenerOnCheck2() {

        chk1 = (CheckBox) findViewById(R.id.checkBox1);
        chk2 = (CheckBox) findViewById(R.id.checkBox2);
        chk3 = (CheckBox) findViewById(R.id.checkBox3);
        chk3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                StringBuffer result = new StringBuffer();
                result.append(" soccer : ").append
                        (chk1.isChecked());
                result.append(" basketball : ").append
                        (chk2.isChecked());
                result.append(" movie : ").append
                        (chk3.isChecked());

                Toast.makeText(stuActivity.this, result.toString(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
    private void addListenerOnCheck3() {

        chk1 = (CheckBox) findViewById(R.id.checkBox1);
        chk2 = (CheckBox) findViewById(R.id.checkBox2);
        chk3 = (CheckBox) findViewById(R.id.checkBox3);
        chk1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                StringBuffer result = new StringBuffer();
                result.append(" soccer : ").append
                        (chk1.isChecked());
                result.append(" basketball : ").append
                        (chk2.isChecked());
                result.append(" movie : ").append
                        (chk3.isChecked());

                Toast.makeText(stuActivity.this, result.toString(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }

//    protected void onDestory() {
//        super.onDestroy();
//        String inputText = edit.getText().toString();
//        save(inputText);
//    }

    public void save(String inputText) {
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            out = openFileOutput("data", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer .write(inputText);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer !=null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.activity_stu,menu);
//        return true;
//    }
//
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return  true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    private void initView() {
        edit1 = (EditText) this.findViewById(R.id.edit_name);
        edit2 = (EditText) this.findViewById(R.id.edit_age);
        button = (Button) this.findViewById(R.id.button);
    }

    public void postParam(View view) {
        Intent intent = new Intent(this,stuActivity.class);
        String infoUserName = edit1.getText().toString();
        String infoPerSignature = edit2.getText().toString();
        intent.putExtra(INFO_NAME, infoUserName);
        intent.putExtra(INFO_AGE, infoPerSignature);
        this.startActivity(intent);
    }

}
