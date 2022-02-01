package Cube.Move;

import static Systems.Systems.*;
import static Systems.Systems.cp;

public class Move {

    public static Object Move(Object Cube,Object Code){

        return Cube;
    }


    public static void Right(int count){

        int sub;
        switch (count){
            case One: //Normal
                sub = cp[1];
                cp[1] = cp[2];
                cp[2] = cp[6];
                cp[6] = cp[5];
                cp[5] = sub;

                break;

                //EOの回転部分を相対でかく <- eoは1回転ごときじゃ変わらない

            case Two: //second
                sub = cp[1];
                cp[1] = cp[6];
                cp[6] = sub;
                sub = cp[2];
                cp[2] = cp[5];
                cp[5] = sub;

                break;

            case Brev: //back rev
                sub = cp[1];
                cp[1] = cp[5];
                cp[5] = cp[6];
                cp[6] = cp[2];
                cp[2] = sub;

                break;
        }

    }

    public static void Left(int count){

        int sub;
        switch (count){
            case One: //Normal

                sub = cp[0];
                cp[0] = cp[4];
                cp[4] = cp[7];
                cp[7] = cp[3];
                cp[3] = sub;

                break;

            case Two: //second

                sub = cp[0];
                cp[0] = cp[7];
                cp[7] = sub;
                sub = cp[3];
                cp[3] = cp[4];
                cp[4] = sub;

                break;

            case Brev: //back rev

                sub = cp[0];
                cp[0] = cp[3];
                cp[3] = cp[7];
                cp[7] = cp[4];
                cp[4] = sub;
                break;

                //TODO EP EOの回転部分を相対でかく

        }
    }

    public static void Up(int count){

        int sub;
        switch (count){
            case One:

                sub = cp[0];
                cp[0] = cp[3];
                cp[3] = sub;
                sub = cp[1];
                cp[1] = cp[2];
                cp[2] = sub;
                break;

            case Two:

                sub = cp[0];
                cp[0] = cp[2];
                cp[2] = sub;
                sub = cp[1];
                cp[1] = cp[3];
                cp[3] = sub;

                break;

            case Brev:

                //TODO 今日はここまで20210916 エクセルにデータ有

        }
    }
}
