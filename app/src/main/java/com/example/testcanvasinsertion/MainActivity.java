package com.example.testcanvasinsertion;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {


    //フィールドのx軸,y軸のそれぞれのマス数
    public static final int X_AXIS = 12;
    public static final int Y_AXIS = 24;
    boolean move_flg = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final MyView myView = (MyView) findViewById(R.id.my_view);
        //フィールド初期化
        myView.field.field = new int[Y_AXIS][X_AXIS];
        myView.field.fieldInitialization(myView.field, X_AXIS, Y_AXIS);
        //ボタン設定
        Button left_move_button = (Button) findViewById(R.id.leftMoveButton);
        Button right_move_button = (Button) findViewById(R.id.rightMoveButton);


        //定期的にブロックの落下処理を行なう
        final Handler handler = new Handler();
        final Runnable r = new Runnable() {

            //初回かどうかの判断に使う
            int count = 0;


            @Override
            public void run() {


                //MainActivityでインスタンス化しているmyViewにブロックの現在位置を代入する
                myView.block = myView.block.getBlockCoordinate(myView.block);
                //下に動けるかの判定
                move_flg = myView.block.isDownMoveJudge(myView.field.field, myView.block.block_point_left_bottom_x, myView.block.block_point_left_bottom_y, myView.block.block_point_right_bottom_x, myView.block.block_point_right_bottom_y);

                //falseなら落下処理終了
                if (move_flg == false) {


                    return;

                }

                //初回ならしない
                if (count != 0) {

                    //描画位置変更
                    myView.block.downMove(myView.block);

                }

                count++;
                //再描画
                myView.invalidate();
                handler.postDelayed(this, 1000);
            }
        };
        handler.post(r);







        //ボタンイベント処理
        left_move_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //ブロックが下の壁、ブロックにぶつかっていればfalseのはず
                if (move_flg == true) {

                    MyView myView = (MyView) findViewById(R.id.my_view);


                    //移動できるか判定
                    move_flg = myView.block.isLeftMoveJudge(myView.field.field, myView.block.block_point_left_top_x, myView.block.block_point_left_top_y, myView.block.block_point_left_bottom_x, myView.block.block_point_left_bottom_y);

                    if (move_flg == true) {

                        myView.block.leftMove(myView.block);
                        //再描画
                        myView.invalidate();

                    }

                }

            }
        });


        right_move_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //ブロックが下の壁、ブロックにぶつかっていればfalseのはず
                if (move_flg == true) {


                    MyView myView = (MyView) findViewById(R.id.my_view);
                    //移動できるか判定
                    move_flg = myView.block.isRightMoveJudge(myView.field.field, myView.block.block_point_right_top_x, myView.block.block_point_right_top_y, myView.block.block_point_right_bottom_x, myView.block.block_point_right_bottom_y);


                    if (move_flg == true) {


                        myView.block.rightMove(myView.block);

                        //再描画
                        myView.invalidate();

                    }

                }

            }
        });


    }
}