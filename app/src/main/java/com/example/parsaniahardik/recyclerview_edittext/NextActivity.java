package com.example.parsaniahardik.recyclerview_edittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

    private TextView tv,tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        tv = (TextView) findViewById(R.id.tv);
        tv1 = (TextView) findViewById(R.id.tv1);

        for (int i = 0; i < CustomAdapter.editModelArrayList.size(); i++){

            tv.setText(tv.getText() + " " + CustomAdapter.editModelArrayList.get(i).getEditTextValue() +System.getProperty("line.separator"));

        }
        for (int i = 0; i < CustomAdapter.editModelArrayList.size(); i++){

            tv1.setText(tv1.getText() + " " + CustomAdapter.editModelArrayList_helper.get(i).getEditTextValue() +System.getProperty("line.separator"));

        }

    }
}
