package com.example.testcanvasinsertion;


public class Block {


    int[][] block = new int[4][4];
    //ブロックの座標の初期値.描画の際に必要
    int block_x;
    int block_y;
    int block_width;
    int block_height;
    int block_x_evacuation;
    int block_width_evacuation;

    //フィールドの配列のどの位置にブロックがあるのか。あたり判定に必要。冗長な感じがたまらない
    int block_point_left_top_x = 0;
    int block_point_left_top_y = 8;
    int block_point_right_top_x = 0;
    int block_point_right_top_y = 9;
    int block_point_left_bottom_x = 1;
    int block_point_left_bottom_y = 8;
    int block_point_right_bottom_x = 1;
    int block_point_right_bottom_y = 9;


    //四角のブロック生成
    public Block squareBlock(Block block) {

        //ブロック初期化
        block = blockInitialization(block);


        block.block[1][1] = 2;
        block.block[1][2] = 2;
        block.block[2][1] = 2;
        block.block[2][2] = 2;

        block.block_x = 660;
        block.block_y = 251;
        block.block_width = 719;
        block.block_height = 301;

        block.block_x_evacuation = 660;
        block.block_width_evacuation = 719;


        return block;


    }

    //ブロック初期化
    public Block blockInitialization(Block block) {

        for (int i = 0; i < 4; i++) {

            for (int k = 0; k < 4; k++) {

                block.block[i][k] = 0;


            }
        }

        return block;

    }


    public void leftMove(Block block) {

        this.block_x = block.block_x - 50;
        this.block_y = 251;
        this.block_width = block.block_width - 50;
        this.block_height = 301;


        this.block_point_left_top_y = block_point_left_top_y - 1;
        this.block_point_right_top_y = block_point_right_top_y - 1;
        this.block_point_left_bottom_y = block_point_left_bottom_y - 1;
        this.block_point_right_bottom_y = block_point_right_bottom_y - 1;


    }

    public void rightMove(Block block) {

        this.block_x = block.block_x + 50;
        this.block_y = 251;
        this.block_width = block.block_width + 50;
        this.block_height = 301;


        this.block_point_left_top_y = block_point_left_top_y + 1;
        this.block_point_right_top_y = block_point_right_top_y + 1;
        this.block_point_left_bottom_y = block_point_left_bottom_y + 1;
        this.block_point_right_bottom_y = block_point_right_bottom_y + 1;


    }

    //移動方向に壁、ブロックがないか調べる
    public boolean isLeftMoveJudge(int[][] field, int block_point_left_top_x, int block_point_left_top_y, int block_point_left_bottom_x, int block_point_left_bottom_y) {

        boolean move_flg = true;

        if (field[block_point_left_top_x][block_point_left_top_y - 1] == 1 || field[block_point_left_bottom_x][block_point_left_bottom_y - 1] == 1) {

            move_flg = false;

        }

        return move_flg;

    }

    //移動方向に壁、ブロックがないか調べる
    public boolean isRightMoveJudge(int[][] field, int block_point_right_top_x, int block_point_right_top_y, int block_point_right_bottom_x, int block_point_right_bottom_y) {

        boolean move_flg = true;

        if (field[block_point_right_top_x][block_point_right_top_y + 1] == 1 || field[block_point_right_bottom_x][block_point_right_bottom_y + 1] == 1) {

            move_flg = false;

        }

        return move_flg;

    }

    //ブロックが二次元配列のどの部分に存在するのか座標を返す
    public  Block getBlockCoordinate(Block block) {

         block.block_point_left_top_x = block_point_left_top_x;
         block.block_point_left_top_y = block_point_left_top_y;
         block.block_point_right_top_x = block_point_right_top_x;
         block.block_point_right_top_y = block_point_right_top_y;
         block.block_point_left_bottom_x = block_point_left_bottom_x;
         block.block_point_left_bottom_y = block_point_left_bottom_y;
         block.block_point_right_bottom_x = block_point_right_bottom_x;
         block.block_point_right_bottom_y = block_point_right_bottom_y;

        return block;
    }
}
