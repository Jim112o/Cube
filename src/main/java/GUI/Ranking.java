package GUI;

import javax.swing.*;
import java.awt.*;

import static Systems.Ranking.Ranking;
import static Systems.Systems.getStrings;
import static Timer.TimerManager.*;

public class Ranking extends JPanel {

    private static JTextPane rankingPane = new JTextPane();

    public Ranking(){
        rankingPane.setPreferredSize(new Dimension(280,455));
        rankingPane.setBackground(Color.BLACK);
        rankingPane.setForeground(Color.RED);
        rankingPane.setEditable(false);
        add(rankingPane);
        //add("20");
    }

    public static void Update(){
        rankingPane.setText("   "+ getStrings().ranking +"\n");
        for(int i = 0; i < Ranking.size() ; i++){
            rankingPane.setText(rankingPane.getText() + "   " + (i + 1) + ". " + getTimeToString(Ranking.get(i)) + "\n");
        }
    }
}
