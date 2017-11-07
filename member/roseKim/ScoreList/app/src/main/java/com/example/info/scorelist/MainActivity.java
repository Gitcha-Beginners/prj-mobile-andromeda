package com.example.info.scorelist;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    TextView text;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1);

        listView= (ListView) findViewById(R.id.listView);

    }



    public void mOnClick(View v){

        switch( v.getId() ){
            case R.id.btn_add_member://점수입력버튼
                LayoutInflater inflater=getLayoutInflater();

                final View dialogView= inflater.inflate(R.layout.dialog_addmember, null);

                AlertDialog.Builder buider= new AlertDialog.Builder(this);

                buider.setTitle("볼링 점수 입력");
                buider.setIcon(android.R.drawable.ic_menu_add);
                buider.setView(dialogView);
                buider.setPositiveButton("입력", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        EditText edit_name= (EditText)dialogView.findViewById(R.id.dialog_edit);
                        String name= edit_name.getText().toString();
                        listView.setAdapter(arrayAdapter);
                        arrayAdapter.add(name);
                        Toast.makeText(MainActivity.this, "점수를 입력했습니다", Toast.LENGTH_SHORT).show();

                    }

                });

                buider.setNegativeButton("취소", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(MainActivity.this, "점수 입력을 취소합니다", Toast.LENGTH_SHORT).show();

                    }

                });


                AlertDialog dialog=buider.create();

                dialog.setCanceledOnTouchOutside(false);
                dialog.show();

                break;
        }

    }

}

