package com.example.marketinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private Button button;
    ArrayList<String>  arrayList;
    ArrayAdapter<String> arrayAdapter;
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView) findViewById(R.id.ListView);
        button = (Button) findViewById(R.id.button);
        arrayList=new ArrayList<>();
        arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
        setUpListViewListener();
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        add();
                    }
                });

            }

    private void setUpListViewListener() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Context context=getApplicationContext();
                Toast.makeText(context,"Item Has Been Removed",Toast.LENGTH_LONG).show();
        arrayList.remove(i);
        arrayAdapter.notifyDataSetChanged();
        return true;
            }
        });
    }

    private void add() {
        EditText input= findViewById(R.id.editTextTextPersonName);
        String itemText= input.getText().toString().trim();

        if(!(itemText.equals(""))){
            arrayAdapter.add(itemText);
            input.setText("");
        }
        else {
            Toast.makeText(getApplicationContext(),"Please enter item", Toast.LENGTH_LONG).show();
            
}

    }


    }
