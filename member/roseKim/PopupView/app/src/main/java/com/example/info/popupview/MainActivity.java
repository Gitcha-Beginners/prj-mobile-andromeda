package com.example.info.popupview;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        popupView();
    }

    //접수입력 팝업 띄우기
    public void popupView(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("게임 점수");
        alert.setMessage("점수를 입력하세요 뀨");


        final EditText name = new EditText(this);
        alert.setView(name);

        alert.setPositiveButton("입력", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String username = name.getText().toString();

                TextView result = (TextView) findViewById(R.id.result);
                result.setText(username);
            }
        });


        alert.setNegativeButton("취소",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

            }
        });

        alert.show();
    }
}
