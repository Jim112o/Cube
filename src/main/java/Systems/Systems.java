package Systems;

import Cube.Cube;
import Events.Command;
import String.StringManager;
import String.MoveCodeManager;
import String.Strings;
import String.Codes;
import Systems.Exception.MyException;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

import static GUI.CommandLine.CommandLine;
import static GUI.CommandLine.input;
import static MAIN.Cube.DEBUGMODE;
import static Systems.OperatingSystem.*;
import static Systems.OperatingSystem.isWindows;

public abstract class Systems {

    public static StringManager stringManager;
    public static MoveCodeManager moveCodeManager;

    private static StringManager getStringManager(){
        return stringManager;
    }
    private static MoveCodeManager getMoveCodeManager(){
        return moveCodeManager;
    }

    public static Strings getStrings(){
        return getStringManager().getStrings();
    }
    public static Codes getCode(){
        return getMoveCodeManager().getCode();
    }


    public static void Setup(){
        CJ   = new String[]{getStrings().yellow, getStrings().white, getStrings().red, getStrings().orange, getStrings().blue, getStrings().green};
        DJ   = new String[]{getStrings().top, getStrings().bottom, getStrings().front, getStrings().back, getStrings().leftSide, getStrings().rightSide};
        UMDJ = new String[]{getStrings().up, getStrings().middle, getStrings().down};
        LMRJ = new String[]{getStrings().left, getStrings().middle, getStrings().right};
        cplist = new ArrayList<>();
        cplist.add(cp0);
        cplist.add(cp1);
        cplist.add(cp2);
        cplist.add(cp3);
        cplist.add(cp4);
        cplist.add(cp5);
        cplist.add(cp6);
        cplist.add(cp7);

        eplist = new ArrayList<>();
        eplist.add(ep0);
        eplist.add(ep1);
        eplist.add(ep2);
        eplist.add(ep3);
        eplist.add(ep4);
        eplist.add(ep5);
        eplist.add(ep6);
        eplist.add(ep7);
        eplist.add(ep8);
        eplist.add(ep9);
        eplist.add(ep10);
        eplist.add(ep11);

        cp = new int[]{0,1,2,3,4,5,6,7};//コーナーパーツ
        co = new int[]{0,0,0,0,0,0,0,0};//コーナーパーツの向き
        ep = new int[]{0,1,2,3,4,5,6,7,8,9,10,11};//エッジパーツ
        eo = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};//エッジパーツの向き
    }

    //OperatingSystem
    public final static int
        WINDOWS = 0,
        MAC = 1;

    //Direction
    public final static int
            U   = 0,
            D   = 1,
            F   = 2,
            B   = 3,
            L   = 4,
            R   = 5;

    //Move
    public final static int
            One = 0,
            Two = 1,
            Brev = 2; //back reverse

    final static String[] directions = {"U","D","F","B","R","L"};
    final static String[] UpDown = {"","'","2"};

    //Color
    public static int
            YELLOW = 0,
            WHITE  = 1,
            RED    = 2,
            ORANGE = 3,
            BLUE   = 4,
            GREEN  = 5;


    //Location
    public static int[]
            cp = {0,1,2,3,4,5,6,7},//コーナーパーツ
            co = {0,0,0,0,0,0,0,0},//コーナーパーツの向き
            ep = {0,1,2,3,4,5,6,7,8,9,10,11},//エッジパーツ
            eo = {0,0,0,0,0,0,0,0,0,0,0,0};//エッジパーツの向き

    //Answer
    public static int[][] solved = {
            {0,1,2,3,4,5,6,7},//cp
            {0,0,0,0,0,0,0,0},//co
            {0,1,2,3,4,5,6,7,8,9,10,11},//ep
            {0,0,0,0,0,0,0,0,0,0,0,0}//eo
    };

    //CP
    /**private static int[] cp0 = {WHITE,ORANGE,GREEN},
                        cp1 = {WHITE,ORANGE,BLUE},
                        cp2 = {WHITE,RED,BLUE},
                        cp3 = {WHITE,RED,GREEN},
                        cp4 = {YELLOW,ORANGE,GREEN},
                        cp5 = {YELLOW,ORANGE,BLUE},
                        cp6 = {YELLOW,RED,BLUE},
                        cp7 = {YELLOW,RED,GREEN};

    //EP
    private static int[] ep0 = {ORANGE,GREEN},
            ep1 = {ORANGE,BLUE},
            ep2 = {RED,BLUE},
            ep3 = {RED,GREEN},
            ep4 = {WHITE,ORANGE},
            ep5 = {WHITE,BLUE},
            ep6 = {WHITE,RED},
            ep7 = {WHITE,GREEN},
            ep8 = {YELLOW,ORANGE},
            ep9 = {YELLOW,BLUE},
            ep10 = {YELLOW,RED},
            ep11 = {YELLOW,GREEN};*/

    //CP(白上、緑正面)
    private static int[] cp0 = {WHITE,BLUE,ORANGE},
            cp1 = {WHITE,BLUE,RED},
            cp2 = {WHITE,GREEN,RED},
            cp3 = {WHITE,GREEN,ORANGE},
            cp4 = {YELLOW,BLUE,ORANGE},
            cp5 = {YELLOW,BLUE,RED},
            cp6 = {YELLOW,GREEN,RED},
            cp7 = {YELLOW,GREEN,ORANGE};

    private static ArrayList<int[]> cplist;

    //EP(白上、緑正面)
    private static int[] ep0 = {BLUE,ORANGE},
            ep1 = {BLUE,RED},
            ep2 = {GREEN,RED},
            ep3 = {GREEN,ORANGE},
            ep4 = {WHITE,BLUE},
            ep5 = {WHITE,RED},
            ep6 = {WHITE,GREEN},
            ep7 = {WHITE,ORANGE},
            ep8 = {YELLOW,BLUE},
            ep9 = {YELLOW,RED},
            ep10 = {YELLOW,GREEN},
            ep11 = {YELLOW,ORANGE};

    private static ArrayList<int[]> eplist;

    /**
     *
     * @param Pnum CPナンバー
     * @param co 向き
     */
    private static int[] getCO(int Pnum, int co){
        int o0 = 0;
        int o1 = 1;
        int o2 = 2;
        switch (co){
            case 0:
                break;
            case 1:
                o0 = 2;
                o1 = 0;
                o2 = 1;
                break;
            case 2:
                o0 = 1;
                o1 = 2;
                o2 = 0;
                break;
        }
        return new int[]{cplist.get(Pnum)[o0],cplist.get(Pnum)[o1],cplist.get(Pnum)[o2]};
    }

    private static int getZero(int[] co){
        int count = 0;
        for(int n : co){
            if(n == YELLOW || n == WHITE){
                return count;
            }
            count++;
        }
        return 99;
    }

    private static int[] getCOtest(int Pnum, int co){
        int o0 = 0;
        int o1 = 1;
        int o2 = 2;
        switch (co){
            case 0:
                break;
            case 1:
                o0 = 2;
                o1 = 0;
                o2 = 1;
                break;
            case 2:
                o0 = 1;
                o1 = 2;
                o2 = 0;
                break;
        }
        return new int[]{cplist.get(Pnum)[o0],cplist.get(Pnum)[o1],cplist.get(Pnum)[o2]};
    }

    private static int[] getEO(int Pnum, int co){
        int o0 = 0;
        int o1 = 1;
        switch (co){
            case 0:
                break;
            case 1:
                o0 = 1;
                o1 = 0;
                break;
        }
        return new int[]{eplist.get(Pnum)[o0],eplist.get(Pnum)[o1]};
    }


    private static int[] direction = {YELLOW,WHITE,RED,ORANGE,BLUE,GREEN};

    //日本語
    public static String[] DJ   = {"上面","下面","正面","背面","左面","右面"},
                           UMDJ = {"上","中","下"},
                           LMRJ = {"左","中","右"},
                           CJ   = {"黄色","白色","赤色","橙色","青色","緑色"};

    //英語
    public static String[] CE = {"yellow","white","red","orange","blue","green"};

    public final static ArrayList<String>
            YELLOWJ = new ArrayList<>(),
            WHITEJ  = new ArrayList<>(),
            REDJ    = new ArrayList<>(),
            ORANGEJ = new ArrayList<>(),
            BLUEJ   = new ArrayList<>(),
            GREENJ  = new ArrayList<>();


    /**TODO 最終的には使えるようにすること。
     * 現段階では黄色が上、赤が正面で開発しているためこの機能は使わないが
     * 今後つかえるようにすることをTODOとする
     * @param color1 上面
     * @param color2 正面
     * @param color3 下面 //ここいる？？？？
     */
    public static void setDirection(int color1, int color2, int color3){
        if      (color1 == YELLOW && color2 == BLUE   && color3 == WHITE){  direction = new int[]{color1,color3,color2,GREEN,ORANGE,RED};
        }else if(color1 == YELLOW && color2 == GREEN  && color3 == WHITE){  direction = new int[]{color1,color3,color2,BLUE,RED,ORANGE};
        }else if(color1 == YELLOW && color2 == ORANGE && color3 == WHITE){  direction = new int[]{color1,color3,color2,RED,GREEN,BLUE};

        }else if(color1 == GREEN && color2 == RED    && color3 == BLUE){   direction = new int[]{color1,color3,color2,ORANGE,YELLOW,WHITE};
        }else if(color1 == GREEN && color2 == WHITE  && color3 == BLUE){   direction = new int[]{color1,color3,color2,YELLOW,RED,ORANGE};
        }else if(color1 == GREEN && color2 == ORANGE && color3 == BLUE){   direction = new int[]{color1,color3,color2,RED,WHITE,YELLOW};
        }else if(color1 == GREEN && color2 == YELLOW && color3 == BLUE){   direction = new int[]{color1,color3,color2,WHITE,ORANGE,RED};

        }else if(color1 == WHITE && color2 == RED    && color3 == YELLOW){ direction = new int[]{color1,color3,color2,ORANGE,GREEN,BLUE};
        }else if(color1 == WHITE && color2 == BLUE   && color3 == YELLOW){ direction = new int[]{color1,color3,color2,GREEN,RED,ORANGE};
        }else if(color1 == WHITE && color2 == ORANGE && color3 == YELLOW){ direction = new int[]{color1,color3,color2,RED,BLUE,GREEN};
        }else if(color1 == WHITE && color2 == GREEN  && color3 == YELLOW){ direction = new int[]{color1,color3,color2,BLUE,ORANGE,RED};//基本はこれ

        }else if(color1 == BLUE && color2 == RED     && color3 == GREEN){  direction = new int[]{color1,color3,color2,ORANGE,WHITE,YELLOW};
        }else if(color1 == BLUE && color2 == YELLOW  && color3 == GREEN){  direction = new int[]{color1,color3,color2,WHITE,RED,ORANGE};
        }else if(color1 == BLUE && color2 == ORANGE  && color3 == GREEN){  direction = new int[]{color1,color3,color2,YELLOW,WHITE};
        }else if(color1 == BLUE && color2 == WHITE   && color3 == GREEN){  direction = new int[]{color1,color3,color2,YELLOW,ORANGE,RED};

        }else if(color1 == RED  && color2 == WHITE   && color3 == ORANGE){ direction = new int[]{color1,color3,color2,YELLOW,BLUE,GREEN};
        }else if(color1 == RED  && color2 == GREEN   && color3 == ORANGE){ direction = new int[]{color1,color3,color2,BLUE,WHITE,YELLOW};
        }else if(color1 == RED  && color2 == YELLOW  && color3 == ORANGE){ direction = new int[]{color1,color3,color2,WHITE,GREEN,BLUE};
        }else if(color1 == RED  && color2 == BLUE    && color3 == ORANGE){ direction = new int[]{color1,color3,color2,GREEN,YELLOW,WHITE};

        }else if(color1 == ORANGE  && color2 == WHITE   && color3 == RED){ direction = new int[]{color1,color3,color2,YELLOW,GREEN,BLUE};
        }else if(color1 == ORANGE  && color2 == BLUE   && color3 == RED){ direction = new int[]{color1,color3,color2,GREEN,WHITE,YELLOW};
        }else if(color1 == ORANGE  && color2 == YELLOW  && color3 == RED){ direction = new int[]{color1,color3,color2,WHITE,BLUE,GREEN};
        }else if(color1 == ORANGE  && color2 == GREEN    && color3 == RED){ direction = new int[]{color1,color3,color2,BLUE,YELLOW,WHITE};
        }



    }

    public static int getColor(String str_color){
        int color = 99;
        for(int i = 0; i < Systems.CJ.length ; i++){
            if(str_color.equalsIgnoreCase(CJ[i]) || str_color.equalsIgnoreCase(CE[i])){
                color = i;
                break;
            }else if(str_color.equalsIgnoreCase(String.valueOf(i))){
                color = i;
                break;
            }
        }
        if(color == 99){
            System.err.println("カラーエラー");
            return 99;
        }
        return color;
    }

    /**
     * 移動元の位置番号と向きを移動先の位置番号で指定した場合に色を出力させたいみたいだったけれど
     * 結局何がしたかったのか思い出せん
     * @param cp1
     * @param co1
     * @param cp2
     * @return
     */
    public static int[] getColor(int cp1, int co1, int cp2){
        int color = 99;
        int[] co1Color = cplist.get(cp1);
        int[] co2Color = cplist.get(cp2);
        return new int[] {color,color,color};
    }

    /**
     * 入力した色からパーツ番号と向きを返す。
     * @param up 上面又は下面の色
     * @param front 正面又は背面の色
     * @param side サイドの色
     * @param num パーツ位置番号
     * @return パーツ番号と向き
     */
    public static int[] getCornerParts(int up, int front, int side, String num){
        String[] frontNum = {"2","3","6","7"};
        int cpnum = 99;
        int conum = 99;
        for(int i = 0; i < cplist.size() ; i++){
            if(CheckColor(up,front,side,cplist.get(i)[0]) && CheckColor(up,front,side,cplist.get(i)[1]) && CheckColor(up,front,side,cplist.get(i)[2])){
                cpnum = i;
            }
        }
        if(cpnum != 99){
            int zero = getZero(new int[] {up,front,side});
            switch (zero){
                case 0:
                    conum = 0;
                    break;
                case 1:
                    conum = Arrays.asList(frontNum).contains(num) ? 2 : 1;
                    break;
                case 2:
                    conum = Arrays.asList(frontNum).contains(num) ? 1 : 2;
                    break;
            }
        }
        return new int[]{cpnum,conum};
    }

    public static int[] getCornerPartstest(int up, int front, int side, String num){
        String[] frontNum = {"2","3","6","7"};
        int cpnum = 99;
        int conum = 99;
        for(int i = 0; i < cplist.size() ; i++){
            if(CheckColor(up,front,side,cplist.get(i)[0]) && CheckColor(up,front,side,cplist.get(i)[1]) && CheckColor(up,front,side,cplist.get(i)[2])){
                cpnum = i;
            }
        }
        if(cpnum != 99){
            int[] co0 = getCO(cpnum,0);
            int[] co1 = getCO(cpnum,1);
            int[] co2 = getCO(cpnum,2);
            if(up == co0[0])
                conum = 0;
            else if(up == co1[0]) {
                conum = Arrays.asList(frontNum).contains(num) ? 1 : 2;
            }else if(up == co2[0]) {
                conum = Arrays.asList(frontNum).contains(num) ? 2 : 1;
            }
        }
        return new int[]{cpnum,conum};
    }

    public static int[] getEdgeParts(int up, int side){
        int epnum = 99;
        int eonum = 99;
        for(int i = 0; i < eplist.size() ; i++){
            if((up == eplist.get(i)[0] && side == eplist.get(i)[1]) || up == eplist.get(i)[1] && side == eplist.get(i)[0]){
                epnum = i;
                break;
            }
        }
        if(epnum != 99){
            int[] co0 = getEO(epnum,0);
            int[] co1 = getEO(epnum,1);
            if(up == co0[0])
                eonum = 0;
            else if(up == co1[0])
                eonum = 1;
        }
        return new int[]{epnum,eonum};
    }

    static void Add(int direction, int num, int color){
        int cube_direction = 0;
        switch (direction){

        }

    }

    private static boolean CheckColor(int up, int front, int side, int COLOR){
        return up == COLOR || front == COLOR || side == COLOR;

    }
    private static boolean CheckColor(int up, int side, int COLOR){
        return up == COLOR || side == COLOR;

    }

    static void CheckInterval(int interval) throws MyException{
        if(interval < 6){
            throw new MyException("範囲外の待機時間");
        }
    }

    public static void INPUTLOCK(boolean lock){
        input.setEditable(!lock);
        input.setCaretColor(Color.red);
        if(!(lock)){
            input.setText("");
        }
    }

    public static String trimLeft(String s) {
        int startPos = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                startPos = i;
                break;
            }
        }
        return s.substring(startPos);
    }

    /**
     * commandとcomparisonを頭から見ていって一致するかどうか
     * @param command 比べる元
     * @param comparison 比べる側
     * @return 頭が一致していたらTrue
     */
    public static Boolean MatchCheck(String command, String comparison){
        for(int i = 1; i <= command.length() ; i++){
            if(comparison.equalsIgnoreCase(command.substring(0,i))){
                return true;
            }
        }
        return false;
    }

    public static Integer getOS(){

        if(isWindows()){
            return 0;
        }else if(isMac()) {
            return 1;
        }
        return 100;
    }


    public static final class out{

        public static void println(String str, boolean newLine){
            if(newLine){ CommandLine.setText(CommandLine.getText() + "\n" + str); }
            else{ CommandLine.setText(CommandLine.getText() + str); }
        }
        public static void println(){ CommandLine.setText(CommandLine.getText() + "\n"); }
        public static void println(String str){ CommandLine.setText(CommandLine.getText() + "\n" + str); }
        public static void println(String[] str){ CommandLine.setText(CommandLine.getText() + "\n" + Arrays.toString(str)); }
        public static void println(int num){ CommandLine.setText(CommandLine.getText() + "\n" + num); }
        public static void println(Exception e){ CommandLine.setText(CommandLine.getText() + "\n " + e); }
        public static void println(Cube cube){ CommandLine.setText(CommandLine.getText() + "\n " + cube.toString());}
    }

    public static final class debug{

        public static void println(){ if(DEBUGMODE)CommandLine.setText(CommandLine.getText() + "\n[DEBUG] "); }
        public static void println(String str){ if(DEBUGMODE)CommandLine.setText(CommandLine.getText() + "\n[DEBUG] " + str); }
        public static void println(String[] str){ if(DEBUGMODE)CommandLine.setText(CommandLine.getText() + "\n[DEBUG] " + Arrays.toString(str)); }
        public static void println(int num){ if(DEBUGMODE)CommandLine.setText(CommandLine.getText() + "\n[DEBUG] " + num); }
        public static void println(Exception e){ if(DEBUGMODE)CommandLine.setText(CommandLine.getText() + "\n[DEBUG] " + e); }
        public static void println(StackTraceElement[] stackTrace) { if(DEBUGMODE)CommandLine.setText(CommandLine.getText() + "\n[DEBUG] " + Arrays.toString(stackTrace)); }
    }

    public static final class err{

        public static void println(String str, boolean newLine){
            if(newLine){ CommandLine.setText(CommandLine.getText() + "\n[ERROR] " + str);}
            else{CommandLine.setText(CommandLine.getText() + str);}
        }
        public static void println(){ CommandLine.setText(CommandLine.getText() + "\n[ERROR] "); }
        public static void println(String str){ CommandLine.setText(CommandLine.getText() + "\n[ERROR] " + str); }
        public static void println(String str, int code){ CommandLine.setText(CommandLine.getText() + "\n[ERROR] " + str + "[CODE: "+code+"]"); }
        public static void println(String[] str){ CommandLine.setText(CommandLine.getText() + "\n[ERROR] " + Arrays.toString(str)); }
        public static void println(int num){ CommandLine.setText(CommandLine.getText() + "\n[ERROR] " + num); }
        public static void println(Exception e){ CommandLine.setText(CommandLine.getText() + "\n[ERROR] " + e); }
        public static void println(StackTraceElement[] stackTrace) { CommandLine.setText(CommandLine.getText() + "\n[ERROR] " + Arrays.toString(stackTrace)); }
    }
}
