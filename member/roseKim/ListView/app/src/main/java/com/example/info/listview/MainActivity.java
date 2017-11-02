package com.example.info.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] scores = {"140" , "184", "114", "132"};
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, scores);
        ListView scoreList = (ListView) findViewById(R.id.scoreList);
        scoreList.setAdapter(adapter);

        scoreList.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String score = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(MainActivity.this, score, Toast.LENGTH_SHORT).show();
                    }
                }
        );

    }
}
