package Systems;

import Commands.CommandManager;
import GUI.CommandLine;
import String.StringManager;
import Systems.Exception.MyException;

import java.util.Timer;
import java.util.TimerTask;

import static MAIN.Cube.DEBUGMODE;
import static MAIN.Cube.language;
import static GUI.CommandLine.ActiveCommandLine;

public final class StartUp {

    private static int interval0;
    private static final String[] CreatedByJim = {"C","r","e","a","t","e","d"," ","b","y"," ","J","i","m","."};
    private static int i = 0;

    public StartUp(int interval){
        if(DEBUGMODE){
            CommandLine.CommandLine.setText(">");
            Systems.debug.println("簡略起動");
            Systems.debug.println("Setup(); 未実行");
            new CommandManager();
            ActiveCommandLine = true;
            return;
        }
        CommandLine.CommandLine.requestFocus();
        ActiveCommandLine = false;
        try {
            Systems.CheckInterval(interval);
        }catch (MyException e){
            Systems.err.println(e.getStackTrace());
            Systems.err.println("StartUp中にエラーが発生した為、StartUpを中断しました。");
            Systems.err.println("\"restart\" を入力して再度SetUpを行ってください。");
            return;
        }
        Systems.INPUTLOCK(true);
        interval0 = interval;
        final Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(interval0 == interval){
                    Systems.stringManager = new StringManager(language);
                    CommandLine.CommandLine.setText("");
                    Systems.out.println("-------------------------------------------------------------------------------------------------------------------");
                    Systems.out.println();
                    Systems.out.println();
                    Systems.out.println();
                    Systems.out.println("   　　■　　　■　■■■■■　■　　　　　■　　　　　　　■■■■");
                    Systems.out.println("  　　 ■　　　■　■　　　　　■　　　　　■　　　　　　■■　　■■");
                    Systems.out.println("  　　 ■　　　■　■　　　　　■　　　　　■　　　　　　■　　　　■");
                    Systems.out.println("   　　■　　　■　■　　　　　■　　　　　■　　　　　　■　　　　■");
                    Systems.out.println("  　　 ■■■■■　■■■■■　■　　　　　■　　　　　　■　　　　■");
                    Systems.out.println("  　　 ■　　　■　■　　　　　■　　　　　■　　　　　　■　　　　■");
                    Systems.out.println("  　　 ■　　　■　■　　　　　■　　　　　■　　　　　　■　　　　■");
                    Systems.out.println("  　　 ■　　　■　■　　　　　■　　　　　■　　　　　　■■　　■■");
                    Systems.out.println("  　　 ■　　　■　■■■■■　■■■■■　■■■■■　　　■■■■");
                    Systems.out.println();
                    Systems.out.println();
                    Systems.out.println();
                    Systems.out.println("-------------------------------------------------------------------------------------------------------------------");
                }else if(interval0 == interval/2){
                    Systems.Setup();
                    CommandLine.CommandLine.setText("");
                    final Timer timer = new Timer();
                    i=0;
                    timer.scheduleAtFixedRate(new TimerTask() {
                        @Override
                        public void run() {
                            if(i >= CreatedByJim.length -1){
                                timer.cancel();
                            }
                            CommandLine.CommandLine.setText("");
                            Systems.out.println("-------------------------------------------------------------------------------------------------------------------");
                            Systems.out.println();
                            Systems.out.println();
                            Systems.out.println();
                            Systems.out.println();
                            Systems.out.println();
                            Systems.out.println();
                            Systems.out.println("                                                                 CubeApplication");
                            Systems.out.println();
                            Systems.out.println();
                            Systems.out.println("                                                                  ",false);
                            for(int n = 0; n<=i ; n++){
                                Systems.out.println(CreatedByJim[n],false);
                            }
                            Systems.out.println();
                            Systems.out.println();
                            Systems.out.println();
                            Systems.out.println();
                            Systems.out.println();
                            Systems.out.println();
                            Systems.out.println();
                            Systems.out.println("-------------------------------------------------------------------------------------------------------------------");
                            i++;
                        }
                    },0,150);
                }else if(interval0 == interval -1){
                    CommandLine.CommandLine.setText("");
                    Systems.out.println("-------------------------------------------------------------------------------------------------------------------");
                    Systems.out.println();
                    Systems.out.println();
                    Systems.out.println();
                    Systems.out.println();
                    Systems.out.println();
                    Systems.out.println();
                    Systems.out.println();
                    Systems.out.println();
                    Systems.out.println();
                    Systems.out.println();
                    Systems.out.println();
                    Systems.out.println();
                    Systems.out.println("Prototype");
                    Systems.out.println();
                    Systems.out.println();
                    Systems.out.println("　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　Language: "+ language);
                    Systems.out.println("-------------------------------------------------------------------------------------------------------------------");

                }
                if(interval0 <= 0) {
                    CommandLine.CommandLine.setText(">");
                    new CommandManager();
                    Systems.INPUTLOCK(false);
                    ActiveCommandLine = true;
                    timer.cancel();
                }
                interval0--;
            }
        },0,1000);

    }
}
