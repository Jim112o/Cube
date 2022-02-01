package MAIN;

import Events.Keyboard;
import Events.Mouse;
import GUI.StopWatchGUI;
import GUI.Ranking;
import GUI.CommandLine;
import String.StringManager;
import String.MoveCodeManager;
import Systems.Scramble;
import Systems.StartUp;
import Systems.Systems;

import javax.swing.*;
import java.awt.*;

import static Systems.Systems.getStrings;


public class Cube extends JFrame{

    public static Cube stopwatch;
    public static Cube ranking;
    public static Cube command;

    public static boolean DEBUGMODE = true;

    public static String language = "en";
    public static String pllCode = "pll";

    private final static int STOPWATCH = 1, COMMAND = 2, RANKING = 3;

    public static void main(String[] args){

        Systems.stringManager = new StringManager(language);
        Systems.moveCodeManager = new MoveCodeManager();
        Systems.Setup();

        //GUIの設定
        stopwatch = new Cube("Cube",STOPWATCH);
        ranking = new Cube(getStrings().ranking,RANKING);
        command = new Cube("CommandLine", COMMAND);
        //コンソールモドキの表示
        command.setVisible(true);

        new StartUp(6/*16*/); //ロマン
    }

    private Cube(String title, int  gui){
        if(gui == 1){
            //------------------------- Main GUI-------------------------------------------------
            BorderLayout borderLayout = new BorderLayout();
            JPanel contentPane = new JPanel();
            contentPane.setLayout(borderLayout); //contentPaneのレイアウト設定
            setContentPane(contentPane); //レイアウト設定
            setTitle(title); //タイトル設定
            setSize(new Dimension(700, 400)); //サイズ設定
            setLocation(270,140); //画面の真ん中にGUIを表示
            setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); //Xボタンを押したときの動作
            setResizable(false);

            Mouse mouse = new Mouse();
            Keyboard keyboard = new Keyboard();
            addKeyListener(keyboard);
            addMouseListener(mouse);
            addMouseMotionListener(mouse);
            contentPane.add(new StopWatchGUI(),BorderLayout.CENTER);
            contentPane.add(new Scramble(), BorderLayout.SOUTH);
            //-----------------------------------------------------------------------------------
        }else if(gui == 2){
            //------------------------------ CommandLine GUI-------------------------------------
            BorderLayout borderLayout = new BorderLayout();
            JPanel contentPane = new JPanel();
            setContentPane(contentPane);
            setLayout(borderLayout); //contentPaneのレイアウト設定
            setTitle(title); //タイトル設定
            setSize(new Dimension(500, 390)); //サイズ設定 TODO 元に戻す 500, 390
            setLocationRelativeTo(null); //画面の真ん中にGUIを表示
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Xボタンを押したときの動作
            setResizable(false);

            Mouse mouse = new Mouse();
            addWindowListener(mouse);

            Keyboard keyboard = new Keyboard();
            addKeyListener(keyboard);

            contentPane.add(new CommandLine());
            //-----------------------------------------------------------------------------------
        }else if(gui == 3){
            //--------------------------------- Ranking GUI -------------------------------------
            BorderLayout borderLayout = new BorderLayout();
            JPanel contentPane = new JPanel();
            setContentPane(contentPane);
            setLayout(borderLayout); //contentPaneのレイアウト設定
            setTitle(title); //タイトル設定
            setSize(new Dimension(300, 500)); //サイズ設定
            setLocation(950,140); //画面の真ん中にGUIを表示
            setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); //Xボタンを押したときの動作
            setResizable(false);

            contentPane.add(new Ranking());
            //-----------------------------------------------------------------------------------


        }



    }

    private static void ANS(String title){

    }
}
