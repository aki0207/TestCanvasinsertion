package com.example.testcanvasinsertion;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {

    //フィールドのx軸,y軸のそれぞれのマス数
    public static final int X_AXIS = 12;
    public static final int Y_AXIS = 24;
    //ブロックのサイズ
   /* public static final int BLOCK_X_AXIS = 4;
    public static final int BLOCK_Y_AXIS = 4;*/
    Paint paint;
    //フィールド
    int[][] field;

    Block block = null;
    //ブロックの座標の初期値
    int block_x = 660;
    int block_y = 251;
    int block_width = 719;
    int block_height = 301;

    //フィールドの配列のどこにブロックがあるか。今回は四角の左上の座標のみを保持させてみる
    int block_coordinate_x = 0;
    int block_coordinate_y = 8;


    //座標の退避用
    int block_x_evacuation = 660;
    int block_width_evacuation = 719;


    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();


    }


    @Override
    protected void onDraw(Canvas canvas) {


        Paint[] ArrayPaint;
        ArrayPaint = new Paint[36];

        //初期化
        for (int i = 0; i < 36; i++) {

            ArrayPaint[i] = new Paint();

        }


        field = new int[Y_AXIS][X_AXIS];
        //フィールドの初期化
        field = fieldInitialization(field);


        //drawRectの座標指定に使用する
        int x = 252;
        int y = 250;
        int width = 302;
        int height = 300;


        //壁を描画
        for (int i = 0; i < Y_AXIS; i++) {
            for (int k = 0; k < X_AXIS; k++) {


                if (field[i][k] == 1) {


                    ArrayPaint[k].setColor(Color.BLACK);
                    ArrayPaint[k].setStrokeWidth(1.0f);
                    ArrayPaint[k].setStyle(Paint.Style.FILL);
                    canvas.drawRect(x, y, width, height, ArrayPaint[k]);

                }

                //横にずらしてマスをつくる
                x = width + 1;
                width = x + 50;

            }

            //改行
            x = 252;
            y = height + 1;
            width = 302;
            height = y + 50;

        }


        for (int i = 0; i < 2; i++) {
            for (int k = 0; k < 2; k++) {

                paint.setColor(Color.RED);
                paint.setStrokeWidth(1.0f);
                paint.setStyle(Paint.Style.FILL);
                canvas.drawRect(block_x, block_y, block_width, block_height, paint);

                //canvas.drawRect(block.block_x, block.block_y, block.block_width, block.block_height, paint);

                //塗る場所を変える前に今の座様の退避を取る
                if (k == 0) {

                    block_x_evacuation = block_x;
                    block_width_evacuation = block_width;

                }

                //横にずらしてマスをつくる
                block_x = block_width + 1;
                block_width = block_x + 50;

                //はん
            }


            //改行
            block_x = block_x_evacuation;
            block_y = 301;
            block_width = block_width_evacuation;
            block_height = 351;


        }

    }


    public void leftMove() {

        block_x = block_x - 50;
        block_y = 251;
        block_width = block_width - 50;
        block_height = 301;
        invalidate();


    }

    public void rightMove() {

        block_x = block_x + 50;
        block_y = 251;
        block_width = block_width + 50;
        block_height = 301;
        invalidate();


    }


    //フィールドを初期化
    public int[][] fieldInitialization(int field[][]) {

        for (int y = 0; y < Y_AXIS; y++) {
            for (int x = 0; x < X_AXIS; x++) {
                //壁を作る
                if (x == 0 || x == X_AXIS - 1) {

                    field[y][x] = 1;

                } else if (y == Y_AXIS - 1) {

                    field[y][x] = 1;

                } else {

                    field[y][x] = 0;

                }
            }

        }

        return field;
    }

    //移動方向に壁、ブロックがないか調べる
    public boolean isLeftMoveJudge(int[][] field, int block_coordinate_x, int block_coordinate_y) {

        boolean move_flg = true;

        if (field[block_coordinate_x][block_coordinate_y - 1] == 1) {

            move_flg = false;


        }

        return move_flg;

    }


    //移動方向に壁、ブロックがないか調べる
    public boolean isRightMoveJudge(int[][] field, int block_coordinate_x, int block_coordinate_y) {

        boolean move_flg = true;

        if (field[block_coordinate_x][block_coordinate_y + 2] == 1) {

            move_flg = false;


        }

        return move_flg;

    }


}