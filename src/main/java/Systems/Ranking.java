package Systems;

import java.util.ArrayList;
import java.util.Collections;

import static GUI.Ranking.Update;

public class Ranking {

    public static ArrayList<Long> Ranking = new ArrayList<>();

    public static void addRanking(long time){
        Ranking.add(time);
        Collections.sort(Ranking);
        Update();
    }

    public static ArrayList getRanking(){
        return Ranking;
    }

    public static void resetRanking(){
        Ranking.clear();
    }

}
