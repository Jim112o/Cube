package Events;

import Timer.StartAndStop;
import Timer.StopWatch;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static GUI.Light.setBlueTint;
import static GUI.Light.setRedTint;
import static Systems.Scramble.Scrambler;
import static Systems.Scramble.scramble;
import static Timer.StartAndStop.*;

public class Keyboard implements KeyListener {


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key){
            case 70:
                pushed_f = true;
                break;
            case 74:
                pushed_j = true;
                break;
        }
        if(!(StartAndStop.standby) && !(pressing) && (pushed_f && pushed_j)){
            setBlueTint(false);
            setRedTint(false);
            pressing = true;
            StartAndStop.Check();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key){
            case 10: //Enter
                if(StopWatch.active){
                    StopWatch.Stop();
                }else if(StopWatch.end){
                    StopWatch.reset();
                    scramble.setText(Scrambler());
                }else{
                    StopWatch.reset();
                    scramble.setText(Scrambler());
                }
            case 32://Space
                if(StopWatch.active){
                    StopWatch.Stop();
                }else if(StopWatch.end){
                    StopWatch.reset();
                    scramble.setText(Scrambler());
                }else{
                    StopWatch.reset();
                    scramble.setText(Scrambler());
                }
            case 70:
                pushed_f = false;
                break;
            case 74:
                pushed_j = false;
                break;
        }
        //F と Jが押されている時
        if(!(pushed_f && pushed_j)){
            pressing = false;
        }

        //タイマーが始まっていなくてFとJが押されていない場合赤を消灯
        if(!(StartAndStop.standby) && !pushed_j && !pushed_f && !StopWatch.active)
            setRedTint(false);


        //開始準備が終わってFとJを離した場合ストップウォッチスタート
        if(StartAndStop.standby && !pushed_j && !pushed_f){
            setRedTint(true);
            if(!pushed_j && !pushed_f){
                StopWatch.Start();
                StartAndStop.standby = false;
            }
        }
    }

}
