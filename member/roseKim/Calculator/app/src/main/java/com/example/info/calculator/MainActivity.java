package com.example.info.calculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //더하기버튼액션
    public void plusButtonClickAction(View v){
        EditText getNum1 = (EditText)findViewById(R.id.num1);
        EditText getNum2 = (EditText)findViewById(R.id.num2);

        TextView result = (TextView)findViewById(R.id.result);

        int num1 = Integer.parseInt(getNum1.getText().toString());
        int num2 = Integer.parseInt(getNum2.getText().toString());

        result.setText(Integer.toString(num1+num2));

    }

    //빼기버튼액션
    public void misButtonClickAction(View v){
        EditText getNum1 = (EditText)findViewById(R.id.num1);
        EditText getNum2 = (EditText)findViewById(R.id.num2);

        TextView result = (TextView)findViewById(R.id.result);

        int num1 = Integer.parseInt(getNum1.getText().toString());
        int num2 = Integer.parseInt(getNum2.getText().toString());

        result.setText(Integer.toString(num1-num2));

    }

    //곱하기버튼액션
    public void mulButtonClickAction(View v){
        EditText getNum1 = (EditText)findViewById(R.id.num1);
        EditText getNum2 = (EditText)findViewById(R.id.num2);

        TextView result = (TextView)findViewById(R.id.result);

        int num1 = Integer.parseInt(getNum1.getText().toString());
        int num2 = Integer.parseInt(getNum2.getText().toString());

        result.setText(Integer.toString(num1*num2));

    }

    //나누기버튼액션
    public void divButtonClickAction(View v){
        EditText getNum1 = (EditText)findViewById(R.id.num1);
        EditText getNum2 = (EditText) findViewById(R.id.num2);

        TextView result = (TextView)findViewById(R.id.result);

        int num1 = Integer.parseInt(getNum1.getText().toString());
        int num2 = Integer.parseInt(getNum2.getText().toString());

        result.setText(Integer.toString(num1/num2));

    }
}
