package com.example.testcanvasinsertion;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ボタン設定
        Button left_move_button = (Button) findViewById(R.id.leftMoveButton);

        left_move_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                MyView myView = (MyView)findViewById(R.id.my_view);
                myView.move();





            }
        });


    }
}