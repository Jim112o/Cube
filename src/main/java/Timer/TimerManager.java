package Timer;

import java.util.concurrent.TimeUnit;

public abstract class TimerManager {

    public static String getTimeToString(long time){
        long sec = TimeUnit.MILLISECONDS.toSeconds(time);
        long min = TimeUnit.MILLISECONDS.toMinutes(time);
        sec = sec - min * 60;
        long ms = (int) (time - (sec + (min * 60)) * 1000)/10;
        return String.format("%02d",min) + ":" + String.format("%02d",sec) + "." + String.format("%02d",ms);
    }
}
