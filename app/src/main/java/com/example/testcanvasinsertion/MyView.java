package com.example.testcanvasinsertion;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {

    //フィールドのx軸,y軸のそれぞれのマス数
    public static final int X_AXIS = 12;
    public static final int Y_AXIS = 24;
    //とりあえずテストでループを実装してみる
    int test_count = 1;
    //ブロックを生成するかどうかのflg。あとでええ感じにする
    boolean flg = true;

    Paint paint = new Paint();
    Field field = new Field();
    Block block = new Block();


    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);


    }


    @Override
    protected void onDraw(Canvas canvas) {


        test_count++;


        //フィールドの生成、初期化
        field.field = new int[Y_AXIS][X_AXIS];
        field = field.fieldInitialization(field, X_AXIS, Y_AXIS);

        //ブロックを生成するのはブロックが下についたときのみ。booleanでflgたてて管理すればええかも
        if (flg == true) {
            //ブロック初期化
            block.blockInitialization(block);
            block.squareBlock(block);
            flg = false;
        } else {

            block.getBlockCoordinate(block);

        }


        //フィールド壁を描画
        for (int i = 0; i < Y_AXIS; i++) {
            for (int k = 0; k < X_AXIS; k++) {


                if (field.field[i][k] == 1) {

                    paint.setColor(Color.BLACK);
                    paint.setStrokeWidth(1.0f);
                    paint.setStyle(Paint.Style.FILL);
                    canvas.drawRect(field.field_x, field.field_y, field.field_width, field.field_height, paint);

                }

                //横にずらしてマスをつくる
                field.field_x = field.field_width + 1;
                field.field_width = field.field_x + 50;

            }

            //改行
            field.field_x = 252;
            field.field_y = field.field_height + 1;
            field.field_width = 302;
            field.field_height = field.field_y + 50;

        }


        //ブロックの描画
        for (int i = 0; i < 2; i++) {
            for (int k = 0; k < 2; k++) {

                paint.setColor(Color.RED);
                paint.setStrokeWidth(1.0f);
                paint.setStyle(Paint.Style.FILL);
                canvas.drawRect(block.block_x, block.block_y, block.block_width, block.block_height, paint);

                //塗る場所を変える前に今の座標の退避を取る
                if (k == 0) {

                    block.block_x_evacuation = block.block_x;
                    block.block_width_evacuation = block.block_width;

                }

                //横にずらしてマスをつくる
                block.block_x = block.block_width + 1;
                block.block_width = block.block_x + 50;


            }


            //改行
            block.block_x = block.block_x_evacuation;
            block.block_y = block.block_height + 1;
            block.block_width = block.block_width_evacuation;
            block.block_height = block.block_y + 50;


        }


        if (test_count < 9) {


            // Handlerクラスをインスタンス化し、postDelayedメソッドを呼んでいる
            new Handler().postDelayed(new Runnable() {
                // Runnable型のインスタンス化と定義
                @Override
                public void run() {

                    //フィールドは
                   /* field.field_y = field.field_height + 1;
                    field.field_width = 302;
                    field.field_height = field.field_y + 50

                    field.field_x = 252;
                    field.field_y = 250;
                    field.field_width = 302;
                    field.field_height = 300;*/


                   /* block.block_x = 660;
                    block.block_y = 251;
                    block.block_width = 719;
                    block.block_height = 301;
*/
                    // 遅らせて実行したい処理

                    block.block_y = block.block_height + 1;
                    block.block_height = block.block_y + 50;
                    invalidate();
                }
            }, 1000); // 遅らせたい時間(ミリ秒) 3000ミリ秒 -> 3秒


        }

    }


}





