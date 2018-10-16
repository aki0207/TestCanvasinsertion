package com.example.testcanvasinsertion;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    boolean move_flg = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyView myView = (MyView) findViewById(R.id.my_view);


        //ボタン設定
        Button left_move_button = (Button) findViewById(R.id.leftMoveButton);
        Button right_move_button = (Button) findViewById(R.id.rightMoveButton);


        //ボタンイベント処理
        left_move_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                MyView myView = (MyView) findViewById(R.id.my_view);

                //移動できるか判定
                move_flg = myView.block.isLeftMoveJudge(myView.field.field, myView.block.block_point_left_top_x, myView.block.block_point_left_top_y, myView.block.block_point_left_bottom_x, myView.block.block_point_left_bottom_y);

                if (move_flg == true) {

                    //ブロックの座標位置移動
                    myView.block.block_point_left_top_y = myView.block.block_point_left_top_y - 1;
                    myView.block.block_point_left_bottom_y = myView.block.block_point_left_bottom_y - 1;
                    myView.block.block_point_left_top_y = myView.block.block_point_right_top_y - 1;
                    myView.block.block_point_left_top_y = myView.block.block_point_right_bottom_y - 1;
                    myView.block.leftMove(myView.block);
                    //再描画
                    myView.invalidate();


                }

            }
        });


        right_move_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyView myView = (MyView) findViewById(R.id.my_view);
                //移動できるか判定
                move_flg = myView.block.isRightMoveJudge(myView.field.field, myView.block.block_point_right_top_x, myView.block.block_point_right_top_y, myView.block.block_point_right_bottom_x, myView.block.block_point_right_bottom_y);


                if (move_flg == true) {

                    myView.block.block_point_right_top_y = myView.block.block_point_right_top_y + 1;
                    myView.block.block_point_right_bottom_y = myView.block.block_point_right_bottom_y + 1;
                    myView.block.block_point_left_top_y = myView.block.block_point_left_top_y + 1;
                    myView.block.block_point_left_top_y = myView.block.block_point_left_bottom_y + 1;


                    myView.block.rightMove(myView.block);
                    //再描画
                    myView.invalidate();
                }

            }
        });


    }
}