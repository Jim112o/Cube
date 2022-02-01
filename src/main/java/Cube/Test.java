package Cube;

import Systems.Search;
import Systems.Systems;

import static Systems.Search.SearchEdge;
import static Systems.Systems.getStrings;

public class Test {

    //十字つくるやーつ
    static int[] four;
    static int[] five;
    static int[] six;
    static int[] seven;
    static boolean comp4 = false;
    static boolean comp5 = false;
    static boolean comp6 = false;
    static boolean comp7 = false;

    static int cross(){
        four = SearchEdge(4);
        if(four == null ){
            Systems.err.println(Systems.getStrings().ThePartsAreNotSetUpCorrectly,344);
            return 99;
        }else{
            comp4 = four();
        }
        five  = SearchEdge(5);
        if(five == null){
            Systems.err.println(Systems.getStrings().ThePartsAreNotSetUpCorrectly,354);
            return 99;
        }
        six  = SearchEdge(6);
        if(six  == null){
            Systems.err.println(Systems.getStrings().ThePartsAreNotSetUpCorrectly,364);
            return 99;
        }
        seven = SearchEdge(7);
        if(seven == null){
            Systems.err.println(Systems.getStrings().ThePartsAreNotSetUpCorrectly,374);
            return 99;
        }
        return 0;
    }

    static boolean four(){
        if(four[0] == 4 && four[1] == 0){
            return true;
        }
        int[] rotations = four;
        if(rotations[0] == 0){
            if(rotations[1] != 0){
                //y2 { (f u` r` f`) or (f r u) } y2
            }
            return true;
        }else{
            int rotation = rotations[0];
            int orientation = rotations[1];
            if(rotation == 8){
                if(orientation != 0){
                    //y2 d r f` y2
                }else{
                    //y2 f2 y2
                }
                return true;
            }else{
                switch (rotation){
                    case 0:
                        if(orientation == 0){
                            //
                        }else{
                            //
                        }
                        break;
                }
            }

        }
        return false;
    }

}
