package Systems;

import GUI.CommandLine;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import static GUI.CommandLine.ActiveCommandLine;

import static MAIN.Cube.DEBUGMODE;
import static Systems.Systems.*;

public class Exit {

    private static int interval0;
    private static final String[] SeeYou = {"S","e","e"," ","y","o","u","!","!","!"};
    private static final String[] ThankYouForPlaying = {"T","h","a","n","k"," ","y","o","u"," ","f","o","r"," ","p","l","a","y","i","n","g","."};
    private static String[] playhul;
    private static String Bar = "----------------------------------------------------------------------------------------------------------------------";
    private static String DebugSeeYouSpace = "                                                                    ";
    private static String DebugPressSpace = "                                                          ";
    private static String SeeYouSpace = "                                                                  ";
    private static String ThankSpace = "                                                      ";
    private static int i = 0;

    public Exit(String str){
        if(getOS() == MAC){
            Bar = "-----------------------------------------------------------";
            DebugSeeYouSpace = "                                                  ";
            DebugPressSpace = "                                          ";
            SeeYouSpace = "                                                  ";
            ThankSpace = "                                       ";
        }
        ActiveCommandLine = false;
        CommandLine.CommandLine.requestFocus();
        int interval = 5;
        interval0 = interval;
        final Timer timer = new Timer();
        if(DEBUGMODE){
            Systems.INPUTLOCK(true);
            CommandLine.CommandLine.setText("");
            Systems.out.println(Bar);
            for(int K = 0 ; K < 7 ; K++){ Systems.out.println(); }
            Systems.out.println(DebugSeeYouSpace,false);
            Systems.out.println("See You!!!",false);
            Systems.out.println();
            Systems.out.println();
            Systems.out.println(DebugPressSpace,false);
            Systems.out.println("Press the close button.",false);
            for(int K = 0 ; K < 7 ; K++){ Systems.out.println(); }
            Systems.out.println(Bar);
            return;
        }
        CommandLine.input.setText(str);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(interval0 == interval){
                    CommandLine.CommandLine.setText("");
                    final Timer timer = new Timer();
                    i=0;
                    timer.scheduleAtFixedRate(new TimerTask() {
                        @Override
                        public void run() {
                            if(i >= ThankYouForPlaying.length -1){
                                timer.cancel();
                            }
                            CommandLine.CommandLine.setText("");
                            Systems.out.println(Bar);
                            for(int K = 0 ; K < 8 ; K++){ Systems.out.println(); }
                            Systems.out.println(ThankSpace,false);
                            for(int n = 0; n<=i ; n++){ Systems.out.println(ThankYouForPlaying[n],false); }
                            for(int K = 0 ; K < 8 ; K++){ Systems.out.println(); }
                            Systems.out.println(Bar);
                            i++;
                        }
                    },0,140);
                }else if(interval0 == interval/2 -1){
                    CommandLine.CommandLine.setText("");
                    final Timer timer = new Timer();
                    i=0;
                    timer.scheduleAtFixedRate(new TimerTask() {
                        @Override
                        public void run() {
                            if(i >= SeeYou.length -1){
                                timer.cancel();
                            }
                            CommandLine.CommandLine.setText("");
                            Systems.out.println(Bar);
                            for(int K = 0 ; K < 8 ; K++){ Systems.out.println(); }
                            Systems.out.println(SeeYouSpace,false);
                            for(int n = 0; n<=i ; n++){ Systems.out.println(SeeYou[n],false); }
                            for(int K = 0 ; K < 8 ; K++){ Systems.out.println(); }
                            Systems.out.println(Bar);
                            i++;
                        }
                    },0,50);
                }
                if(interval0 <= 0) {
                    System.exit(0);
                    timer.cancel();
                }
                interval0--;
            }
        },0,1000);
    }

    public Exit(){
        if(getOS() == MAC){
            Bar = "-----------------------------------------------------------";
            DebugSeeYouSpace = "                                                  ";
            DebugPressSpace = "                                          ";
            SeeYouSpace = "                                                  ";
            ThankSpace = "                                       ";
        }
        ActiveCommandLine = false;
        CommandLine.CommandLine.requestFocus();
        int interval = 5;
        interval0 = interval;
        final Timer timer = new Timer();
        if(DEBUGMODE){
            Systems.INPUTLOCK(true);
            CommandLine.CommandLine.setText("");
            Systems.out.println(Bar);
            for(int K = 0 ; K < 7 ; K++){ Systems.out.println(); }
            Systems.out.println(DebugSeeYouSpace,false);
            Systems.out.println("See You!!!",false);
            Systems.out.println();
            Systems.out.println();
            Systems.out.println(DebugPressSpace,false);
            Systems.out.println("Press the close button.",false);
            for(int K = 0 ; K < 7 ; K++){ Systems.out.println(); }
            Systems.out.println(Bar);
            return;
        }
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(interval0 == interval){
                    CommandLine.CommandLine.setText("");
                    final Timer timer = new Timer();
                    i=0;
                    timer.scheduleAtFixedRate(new TimerTask() {
                        @Override
                        public void run() {
                            if(i >= ThankYouForPlaying.length -1){
                                timer.cancel();
                            }
                            CommandLine.CommandLine.setText("");
                            Systems.out.println(Bar);
                            for(int K = 0 ; K < 8 ; K++){ Systems.out.println(); }
                            Systems.out.println(ThankSpace,false);
                            for(int n = 0; n<=i ; n++){ Systems.out.println(ThankYouForPlaying[n],false); }
                            for(int K = 0 ; K < 8 ; K++){ Systems.out.println(); }
                            Systems.out.println(Bar);
                            i++;
                        }
                    },0,140);
                }else if(interval0 == interval/2 -1){
                    CommandLine.CommandLine.setText("");
                    final Timer timer = new Timer();
                    i=0;
                    timer.scheduleAtFixedRate(new TimerTask() {
                        @Override
                        public void run() {
                            if(i >= SeeYou.length -1){
                                timer.cancel();
                            }
                            CommandLine.CommandLine.setText("");
                            Systems.out.println(Bar);
                            for(int K = 0 ; K < 8 ; K++){ Systems.out.println(); }
                            Systems.out.println(SeeYouSpace,false);
                            for(int n = 0; n<=i ; n++){ Systems.out.println(SeeYou[n],false); }

                            for(int K = 0 ; K < 8 ; K++){ Systems.out.println(); }
                            Systems.out.println(Bar);
                            i++;
                        }
                    },0,50);
                }
                if(interval0 <= 0) {
                    System.exit(0);
                    timer.cancel();
                }
                interval0--;
            }
        },0,1000);
    }
}
