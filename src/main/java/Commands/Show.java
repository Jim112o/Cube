package Commands;

import Systems.Systems;

import static Cube.CubeManager.NUM;
import static MAIN.Cube.*;

@CommandInfo(
        aliases = {"show","s"},
        description = "GUI を表示",
        usage = "[GUI]",
        tabCompletion = CommandTabCompletion.GUI)
public class Show extends CubeCommand{

    String args;

    @Override
    public void OnCommand(String[] args) {
        if(args.length <= 0){
            Systems.err.println(Systems.getStrings().TheArgumentIsIncorrect);
            return;
        }
        this.args = args[0];
        if(args[0].equalsIgnoreCase("time") || args[0].equalsIgnoreCase("stopwatch")){
            stopwatch.setVisible(true);
            stopwatch.setLocation(270,140);
            this.args = "stopwatch";
        }else if(args[0].equalsIgnoreCase("ranking") || args[0].equalsIgnoreCase("ran")) {
            ranking.setVisible(true);
            ranking.setLocation(950,140);
            this.args = "ranking";
        }else if(args[0].equalsIgnoreCase("num")){
            if(args.length == 1)
                NUM(null);
            else
                NUM(args[1]);
            return;
        }else if(args[0].equalsIgnoreCase("all")){
            stopwatch.setVisible(true);
            ranking.setVisible(true);
            stopwatch.setLocation(270,140);
            ranking.setLocation(950,140);
            Systems.debug.println(Systems.getStrings().showGUI.replace("%%NAME","stopwatch,ranking"));
            this.args = "all";
        }else{
            Systems.err.println(Systems.getStrings().GuiIsNotFound);
            return;
        }
        command.toFront();
        if(!DEBUGMODE) {Systems.out.println("[SYSTEM] "+ Systems.getStrings().showGUI.replaceAll("%%NAME",this.args));}
    }
}
