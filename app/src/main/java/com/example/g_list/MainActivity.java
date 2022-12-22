package com.example.g_list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    ListView my_list,empty_list;
    ArrayList<String> listitems;
    ArrayAdapter my_adapter;

    EditText enter;
    ImageView add_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        my_list=findViewById(R.id.listviewid);
        empty_list=findViewById(R.id.listviewid2);
        listitems=new ArrayList<String>();
        listitems.add("item 1");
        listitems.add("item 2");
        my_adapter=new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,listitems);
        my_list.setAdapter(my_adapter);
        empty_list.setAdapter(my_adapter);

        enter=findViewById(R.id.enteritemid);
        add_item=findViewById(R.id.additemid);
        add_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem();

            }
        });
    }

    private void addItem()
    {
        if(enter.getText().toString()==null||enter.getText().toString()=="")
        {
            Toast.makeText(getApplicationContext(), "enter an item ", Toast.LENGTH_SHORT).show();
        }
        else
        {
            listitems.add(enter.getText().toString());
            my_list.setAdapter(my_adapter);
        }
    }
}