package Cube;

import Cube.PLL.*;
import Systems.Systems;

import java.awt.*;
import java.util.ArrayList;

import static Systems.Systems.cp;
import static Systems.Systems.ep;

public class CubeManager{


    Cube cube;


    public static void NUM(String surface){
        if(surface == null){
            Systems.out.println("------------------  Cube Number  ------------------");
            Systems.out.println("                                                   ");
            Systems.out.println("                     　 |----|----|----|                   ");
            Systems.out.println("                     　 |  0 |  4 |  1 |                   ");
            Systems.out.println("                   　   |----|----|----|                   ");
            Systems.out.println("                     　 |  7 |  U |  5 |                   ");
            Systems.out.println("                     　 |----|----|----|                   ");
            Systems.out.println("                     　 |  3 |  6 |  2 |                   ");
            Systems.out.println("      |----|----|----||----|----|----||----|----|----||----|----|----|      ");
            Systems.out.println("      | 　| 　 | 　||  　| 　| 　|| 　| 　 | 　||　 |　 |　 |　     ");
            Systems.out.println("      |----|----|----||----|----|----||----|----|----||----|----|----|      ");
            Systems.out.println("      | 　|  L | 　||  3 |  F |  2 || 　|  R | 　||  1 |  B |  0 |      ");
            Systems.out.println("      |----|----|----||----|----|----||----|----|----||----|----|----|      ");
            Systems.out.println("      | 　| 　 | 　||  　| 　| 　|| 　| 　 | 　||　 |　 |　 |　     ");
            Systems.out.println("      |----|----|----||----|----|----||----|----|----||----|----|----|      ");
            Systems.out.println("     　                 |  7 | 10|  6 |                   ");
            Systems.out.println("     　                 |----|----|----|                   ");
            Systems.out.println("       　               | 11|  D |  9 |                   ");
            Systems.out.println("         　             |----|----|----|                   ");
            Systems.out.println("           　           |  4 |  8 |  5 |                   ");
            Systems.out.println("             　         |----|----|----|                   ");
            Systems.out.println("                                                   ");
            Systems.out.println("------------------------------------------------------");
        }else if(surface.equalsIgnoreCase("f")){
            Systems.out.println("------------------  Cube Number  ------------------");
            Systems.out.println("      |----|----|----|");
            Systems.out.println("      | ③ | 6  | ② |");
            Systems.out.println("      |----|----|----|");
            Systems.out.println("      |  3 |  F | 2 |");
            Systems.out.println("      |----|----|----|");
            Systems.out.println("      | ⑦ |10 | ⑥ |");
            Systems.out.println("      |----|----|----|");
            Systems.out.println("------------------------------------------------------");
        }
    }

    public static void STATUS(){

        Systems.out.println("------------------  Cube Status  ------------------");
        Systems.out.println("                                                   ");
        Systems.out.println("                      |----|----|----|                   ");
        Systems.out.println("                      |  "+cp[0]+" |  "+ep[4]+" |  "+cp[1]+" |                   ");
        Systems.out.println("                      |----|----|----|                   ");
        Systems.out.println("                      |  "+ep[7]+" |  U |  "+ep[5]+" |                   ");
        Systems.out.println("                      |----|----|----|                   ");
        Systems.out.println("                      |  "+cp[3]+" |  "+ep[6]+" |  "+cp[2]+" |                   ");
        Systems.out.println("      |----|----|----||----|----|----||----|----|----||----|----|----|      ");
        Systems.out.println("      | 　| 　 | 　||  　| 　| 　|| 　| 　 | 　||　 |　 |　 |　     ");
        Systems.out.println("      |----|----|----||----|----|----||----|----|----||----|----|----|      ");
        Systems.out.println("      | 　|  L | 　||  "+ep[3]+" |  F |  "+ep[2]+" || 　|  R | 　||  "+ep[1]+" |  B |  "+ep[0]+" |      ");
        Systems.out.println("      |----|----|----||----|----|----||----|----|----||----|----|----|      ");
        Systems.out.println("      | 　| 　 | 　||  　| 　| 　|| 　| 　 | 　||　 |　 |　 |　     ");
        Systems.out.println("      |----|----|----||----|----|----||----|----|----||----|----|----|      ");
        Systems.out.println("                      |  "+cp[7]+" | "+ep[10]+" |  "+cp[6]+" |                   ");
        Systems.out.println("                      |----|----|----|                   ");
        Systems.out.println("                      | "+ep[11]+" |  D |  "+ep[9]+" |                   ");
        Systems.out.println("                      |----|----|----|                   ");
        Systems.out.println("                      |  "+cp[4]+" |  "+ep[8]+" |  "+cp[5]+" |                   ");
        Systems.out.println("                      |----|----|----|                   ");
        Systems.out.println("                                                   ");
        Systems.out.println("------------------------------------------------------");
    }
}
