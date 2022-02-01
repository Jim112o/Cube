package Cube.PLL;

import Cube.CubeManager;
import Cube.Move.Move;
import Systems.Systems;

import java.util.ArrayList;
import java.util.List;

public class Ub extends CubeManager {

    public static int[][] Ubt;
    public static int[][] Ubd;
    public static int[][] Ubf;
    public static int[][] Ubb;
    public static int[][] Ubl;
    public static int[][] Ubr;
    public static int[][][] Ub;


    private static String[] UbDCode = {"R", "U", "R", "U", "R", "U", "R", "U", "R"};
    private static int[] UbUCode    = {1, 0, 0, 0, 2, 2, 2, 2, 2};
    private static ArrayList<Object> UbCode;

    public Ub(){
        UbCode = new ArrayList<>();
        for (int n = 0; n < UbUCode.length ; n++){
            UbCode.add(UbDCode[n]);
            UbCode.add(UbUCode[n]);
        }
    }

    /**
     * 呼び出されたときにUbかどうかチェックを行う
     * チェックの方法は、Cubeを複製させて、仮想的に動かして
     * 完成すればUb
     * 違っていれば完成しないのでUbでは無いと判断できる。
     */
    public static void Check() {
        Object test = Move.Move("ff", UbCode);
    }

    public static void CheckUb(int[] top, int[] down){
        int top_check = top[0]^top.length;
        int down_check = down[0]^down.length;
        int top_check_1 = 0;
        int down_check_1 = 0;
        for (int value : top) {
            top_check_1 *= value;
        }
        for (int value : down) {
            down_check_1 *= value;
        }
        if(top_check == top_check_1 && down_check == down_check_1){
            System.out.println("U-perm:b");
        }
    }

}
