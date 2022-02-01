package Events;

import Timer.StartAndStop;
import Timer.StopWatch;

import javax.swing.*;
import java.awt.event.*;

import static GUI.CommandLine.*;
import static GUI.Light.setBlueTint;
import static GUI.Light.setRedTint;
import static Timer.StartAndStop.pressing;


public class Mouse implements MouseListener , MouseMotionListener , WindowListener {

    public static final StopWatch stopWatch = new StopWatch();


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        /**StartAndStop.clicked = true;
        if(!(StartAndStop.standby)){
            Systems.out.println("1-true");
            StartAndStop.Check();
        }*/
        //クリックでタイマー止める
        /**
        if(!(StartAndStop.standby) && StopWatch.active){
            setBlueTint(false);
            setRedTint(false);
            pressing = true;
            StartAndStop.Check();
        }*/
    }


    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {//マウスが動いている時に呼び出される
        /**if(!(StartAndStop.standby) && StopWatch.active){
            setBlueTint(false);
            setRedTint(false);
            pressing = true;
            StartAndStop.Check();
        }*/
    }


    @Override
    public void windowDeactivated(WindowEvent e){}
    @Override
    public void windowOpened(WindowEvent e){}
    @Override
    public void windowClosing(WindowEvent e){}
    @Override
    public void windowClosed(WindowEvent e){}
    @Override
    public void windowIconified(WindowEvent e){}
    @Override
    public void windowDeiconified(WindowEvent e){}

    @Override
    public void windowActivated(WindowEvent e){
        if(ActiveCommandLine)
            input.requestFocus();
    }

}
