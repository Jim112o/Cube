package Timer;

import java.util.Timer;
import java.util.TimerTask;

import static GUI.Light.setBlueTint;
import static GUI.Light.setRedTint;

public class StartAndStop {

    public static boolean clicked = false;
    public static boolean pushed_f = false;
    public static boolean pushed_j = false;
    public static boolean standby = false;
    public static boolean pressing = false;
    public static boolean getClicked(){
        return clicked;
    }

    public static boolean getPushed(){
        return pressing;
    }

    private static int interval = 1;

    public static void Check(){
        standby = false;
        interval = 3;
        setRedTint(true);
        if(StopWatch.active){
            setRedTint(false);
            StopWatch.Stop();
        }else if(!StopWatch.end){
            setBlueTint(false);
            setRedTint(true);
            final Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    if(!(getPushed())){
                        setRedTint(false);
                        setBlueTint(false);
                        timer.cancel();
                    }
                    if(interval <= 0) {
                        if(getPushed()){
                            standby = true;
                            setRedTint(true);
                            setBlueTint(true);
                        }
                        timer.cancel();
                    }
                    interval--;
                }
            },0,400);
        }
    }
}
