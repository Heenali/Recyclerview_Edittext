package com.example.parsaniahardik.recyclerview_edittext;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Parsania Hardik on 17-Apr-18.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    public static ArrayList<EditModel> editModelArrayList;
    public static ArrayList<EditModel> editModelArrayList_helper;
    Context c;

    public CustomAdapter(Context ctx, ArrayList<EditModel> editModelArrayList,ArrayList<EditModel> editModelArrayList_helper){

        c=ctx;
        inflater = LayoutInflater.from(ctx);
        this.editModelArrayList = editModelArrayList;
        this.editModelArrayList_helper = editModelArrayList_helper;

    }

    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.rv_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(final CustomAdapter.MyViewHolder holder, final int position) {


        holder.txt_driver.setText(editModelArrayList.get(position).getEditTextValue());
        holder.txt_helper.setText(editModelArrayList_helper.get(position).getEditTextValue());
        Log.d("print","yes");

    }

    @Override
    public int getItemCount() {
        return editModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        protected EditText txt_helper;
        protected  AutoCompleteTextView txt_driver,txt_vendor;
        LinearLayout layout_costtovendor;
        LinearLayout layout_info1,layout_info2;

        public MyViewHolder(View itemView) {
            super(itemView);

            txt_helper = (EditText) itemView.findViewById(R.id.txt_helper);
            txt_driver = (AutoCompleteTextView) itemView.findViewById(R.id.txt_driver);
            txt_vendor = (AutoCompleteTextView) itemView.findViewById(R.id.txt_vendor);
            layout_costtovendor=(LinearLayout)itemView.findViewById(R.id.layout_costtovendor);
            layout_info1=(LinearLayout)itemView.findViewById(R.id.layout_info1);
            layout_info2=(LinearLayout)itemView.findViewById(R.id.layout_info2);
            layout_costtovendor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {

                    if(layout_info1.getVisibility() == View.VISIBLE)
                    {
                        layout_info1.setVisibility(View.GONE);
                        layout_info2.setVisibility(View.GONE);
                    }
                    else
                    {
                        layout_info1.setVisibility(View.VISIBLE);
                        layout_info2.setVisibility(View.VISIBLE);
                    }
                }
            });

            String[] languages={"Jignesh Lalwani","Heenali Lakhani ","Heenali Jaypalbhai","Atif Ali","Atif Aslam","Emran Khan","Sanjay Panchal","Ali khan"};

            ArrayAdapter adapter_driver = new ArrayAdapter(c,android.R.layout.simple_list_item_1,languages);

            txt_driver.setAdapter(adapter_driver);
            txt_driver.setThreshold(3);



            ArrayAdapter adapter_vendor = new ArrayAdapter(c,android.R.layout.simple_list_item_1,languages);
            txt_vendor.setAdapter(adapter_vendor);
            txt_vendor.setThreshold(3);


            txt_driver.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                      editModelArrayList.get(getAdapterPosition()).setEditTextValue(txt_driver.getText().toString());
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
            txt_helper.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    editModelArrayList_helper.get(getAdapterPosition()).setEditTextValue(txt_helper.getText().toString());
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

        }

    }
}
