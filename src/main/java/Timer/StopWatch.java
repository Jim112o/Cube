package Timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import static GUI.Light.*;
import static Systems.Ranking.addRanking;
import static Timer.StartAndStop.*;
import static Timer.TimerManager.*;

public class StopWatch extends JPanel implements ActionListener {



    private static Timer timer;
    private static long min;
    private static long sec;
    private static int ms;
    private static JLabel label = new JLabel("00:00.00");

    // ストップウォッチが起動状態かのフラグ
    public static boolean active;
    public static boolean end = false;
    private static Date start_point;

    public StopWatch() {
        //ラベルの設定
        label.setOpaque(true);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 60));
        label.setPreferredSize(new Dimension(800, 200));
        label.setBackground(null);
        add(label, BorderLayout.CENTER);
        timer = new Timer(10, this);
        //setBackground(Color.WHITE);

        reset();
    }

    public static void Start(){
        active = true;
        end = false;
        start_point = new Date();
        timer.start();
        setBlueTint(false);
    }

    public static void Stop(){
        active = false;
        end = true;
        setBlueTint(false);
        setRedTint(false);
        timer.stop();
        addRanking(newTime);
    }



    // リセット
    public static void reset() {
        min = sec = ms = 0;
        pushed_f = false;
        pushed_j = false;
        pressing = false;
        standby = false;
        active = false;
        end = false;
        setRedTint(false);
        setBlueTint(false);
        label.setText("00:00.00");
    }

    // 起動状態を返却するゲッター
    public boolean isActive() {
        return active;
    }

    public int test(){
        return ms>60 ? 1 : 2;
    }

    private static long newTime;

    @Override
    public void actionPerformed(ActionEvent e) {
        Date end_point = new Date();
        //処理終了時の時刻-処理開始前の時刻
        long time = end_point.getTime() - start_point.getTime();
        newTime = time;
        ms = (int) (time - (sec + (min * 60)) * 1000)/10;
        if(ms % 5 == 0){
            setRedTint(!getRedTint());
            setBlueTint(!getBlueTint());
        }
        label.setText(getTimeToString(time));


    }
}
