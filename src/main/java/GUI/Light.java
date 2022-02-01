package GUI;

import Image.Tying;

import javax.swing.*;

public class Light extends JPanel {

    private static JLabel Blank1   = new JLabel("                             ");
    private static JLabel red  = new JLabel();
    private static JLabel blue = new JLabel();
    private static boolean redTint = false;
    private static boolean blueTint = false;

    Light(){
        Tying.tying(red,"black_dark_red");
        Tying.tying(blue,"black_dark_blue");
        add(red);
        add(Blank1);
        add(blue);
    }

    public static void setRedTint(boolean tint){
        redTint = tint;
        if(tint){
            Tying.tying(red,"black_red");
        }else{
            Tying.tying(red,"black_dark_red");
        }
    }

    public static void setBlueTint(boolean tint){
        blueTint = tint;
        if(tint){
            Tying.tying(blue,"black_blue");
        }else{
            Tying.tying(blue,"black_dark_blue");
        }
    }

    public static boolean getRedTint(){
        return redTint;
    }

    public static boolean getBlueTint(){
        return blueTint;
    }

}
