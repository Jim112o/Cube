package GUI;
import javax.swing.*;

import Timer.StopWatch;

public class StopWatchGUI extends JPanel {

    public StopWatchGUI(){
        //setLayout(new GridLayout(2,1));
        add(new StopWatch());
        add(new Light());
    }


}
