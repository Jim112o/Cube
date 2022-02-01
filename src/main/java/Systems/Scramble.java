package Systems;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import static Systems.Systems.UpDown;
import static Systems.Systems.directions;

public class Scramble extends JPanel{

    public static JLabel scramble = new JLabel();

    public Scramble(){
        scramble = new JLabel(Scramble.Scrambler());
        scramble.setFont(new Font("Clarimo UD PE ExtraLight", Font.BOLD, 20));
        add(scramble, BorderLayout.SOUTH);
    }

    public static String Scrambler(){
        ArrayList<String> Scramble = new ArrayList<String>();
        String before_one = "";
        String before_two = "";

        for(int i = 0 ; i <= 24 ; i++){
            int direction = new Random().nextInt(directions.length);
            int times = new Random().nextInt(UpDown.length);
            if(before_one.equalsIgnoreCase(directions[direction])){
                i--;
            }else{
                if(before_two.equalsIgnoreCase(directions[direction]) ){
                    if(((before_one.equalsIgnoreCase("R") && before_two.equalsIgnoreCase("L")) || (before_one.equalsIgnoreCase("L") && before_two.equalsIgnoreCase("R"))) ||
                       ((before_one.equalsIgnoreCase("B") && before_two.equalsIgnoreCase("F")) || (before_one.equalsIgnoreCase("F") && before_two.equalsIgnoreCase("B"))) ||
                       ((before_one.equalsIgnoreCase("D") && before_two.equalsIgnoreCase("U")) || (before_one.equalsIgnoreCase("U") && before_two.equalsIgnoreCase("D")))){
                        i--;
                        System.out.println("[回避] " + directions[direction] + " -- " +before_one + " -- " + before_two); //TODO 完成時削除
                    }else{
                        before_two = before_one;
                        before_one = directions[direction];
                        Scramble.add(directions[direction] + UpDown[times]);
                    }
                }else{
                    before_two = before_one;
                    before_one = directions[direction];
                    Scramble.add(directions[direction] + UpDown[times]);
                }
            }

        }
        return Scramble.toString().replaceAll("\\[","").replaceAll("\\]","").replaceAll(",","")/*.replaceAll("  ", " ")*/;
    }


}
