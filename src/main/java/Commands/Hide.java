package Commands;

import Systems.Systems;

import static MAIN.Cube.*;

@CommandInfo(
        aliases = {"hide","h"},
        description = "GUI を非表示",
        usage = "[GUI]",
        tabCompletion = CommandTabCompletion.GUI)
public class Hide extends CubeCommand{

    String args;

    @Override
    public void OnCommand(String[] args) {
        if(args.length <= 0){
            Systems.err.println(Systems.getStrings().TheArgumentIsIncorrect);
            return;
        }
        if(args[0].equalsIgnoreCase("time") || args[0].equalsIgnoreCase("stopwatch")){
            stopwatch.setVisible(false);
            this.args = "stopwatch";
        }else if(args[0].equalsIgnoreCase("ranking") || args[0].equalsIgnoreCase("rank")) {
            ranking.setVisible(false);
            this.args = "ranking";
        }else if(args[0].equalsIgnoreCase("all")){
            stopwatch.setVisible(false);
            ranking.setVisible(false);
            Systems.debug.println(Systems.getStrings().hideGUI.replace("%%NAME","stopwatch,ranking"));
            this.args = "all";
        }else{
            Systems.err.println(Systems.getStrings().GuiIsNotFound);
            return;
        }
        if(!DEBUGMODE){Systems.out.println("[SYSTEM] "+ Systems.getStrings().hideGUI.replaceAll("%%NAME",this.args));}
    }
}

