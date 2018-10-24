package com.example.parsaniahardik.recyclerview_edittext;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private RecyclerView recyclerView;
    private CustomAdapter customAdapter;
    public ArrayList<EditModel> editModelArrayList;
    public ArrayList<EditModel> editModelArrayList_helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        btn = (Button) findViewById(R.id.btn);

        editModelArrayList = populateList();
        editModelArrayList_helper = populateList_helper();

        customAdapter = new CustomAdapter(this,editModelArrayList,editModelArrayList_helper);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,NextActivity.class);
                startActivity(intent);
            }
        });

    }

    private ArrayList<EditModel> populateList(){

        ArrayList<EditModel> list = new ArrayList<>();

        for(int i = 0; i < 3; i++)
        {
            EditModel editModel = new EditModel();
            editModel.setEditTextValue("");
            list.add(editModel);
        }

        return list;
    }
    private ArrayList<EditModel> populateList_helper(){

        ArrayList<EditModel> list = new ArrayList<>();

        for(int i = 0; i < 3; i++)
        {
            EditModel editModel = new EditModel();
            editModel.setEditTextValue("");
            list.add(editModel);
        }

        return list;
    }

}
