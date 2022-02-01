package Systems;

import java.util.Timer;
import java.util.TimerTask;

public class Search extends Systems {

    static int section = 0;
    final public static int CORNER = 11,
                     EDGE   = 22;
    public static int INFO = 0;
    int i = 0;

    public static void Serch(){

    }

    public static void SerhStart(){
        section = 0;
        final Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(section == 1)
                    Systems.out.println("[SYSTEM] "+Systems.getStrings().PleaseEnterTheCurrentStatus);//現在の状態を入力してください。
                if(section == 2)
                    Systems.out.println("[SYSTEM] "+Systems.getStrings().DoNotKnowTheNumber);//数字が分からない場合は"cube num"を入力してください。
                if(section == 3)
                    Systems.out.println("[SYSTEM] "+Systems.getStrings().NowFirstHoldTheYellowSideUpAndTheRedSideInFrontOfYou);//では、まず黄色の面を上、赤色の面を正面に持ってください。
                if(section == 4)
                    Systems.out.println("[SYSTEM] "+Systems.getStrings().LetsStartByConner);//じゃあまずは、コーナーの情報を入力していきます。
                if(section >= 5){
                    SearchCorner();
                    timer.cancel();
                }
                section++;
            }
        },0,1000);
    }

    private static void SearchCorner(){
        INFO = CORNER;
        Systems.debug.println("コーナーパーツの情報を入力する状態に移行。INFO: " +INFO);
        Systems.out.println("[SYSTEM] \"cube c [NUM] [up-color/down-color] [front-color/back-color] [side-color]\"\n" +
                "[SYSTEM] Enter the information for the corner part in");//"コマンド"でコーナーパーツの情報を入力してください。
    }

    public static int[] SearchCorner(int SearchPart){
        int[] ret = null;
        for(int i = 0 ; i < cp.length ; i++){
            if(cp[i] == SearchPart){
                ret = new int[]{i,co[i]};
                break;
            }
        }
        return ret;
    }

    private static void SearchEdge(){
        INFO = EDGE;
        Systems.debug.println("エッジパーツの情報を入力する状態に移行。INFO: " +INFO);
        Systems.out.println("[SYSTEM] \"cube e [NUM] [up-color/down-color] [side-color]\"\n" +
                "[SYSTEM] Enter the information for the corner part in");//"コマンド"でエッジパーツの情報を入力してください。
    }

    public static int[] SearchEdge(int SearchPart){
        int[] ret = null;
        for(int i = 0 ; i < ep.length ; i++){
            if(ep[i] == SearchPart){
                ret = new int[]{i,eo[i]};
                break;
            }
        }
        return ret;
    }


    public static void setDirection(String up, String front, String down){
        int color1 = getColor(up);
        int color2 = getColor(front);
        int color3 = getColor(down);
        setDirection(color1,color2,color3);
    }
}
