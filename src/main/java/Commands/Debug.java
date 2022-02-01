package Commands;

import Cube.Cube;
import Systems.Systems;

import static Commands.CommandTabCompletion.BOOLEAN;
import static MAIN.Cube.*;
import static Systems.Search.SerhStart;

@CommandInfo(
        aliases = {"debug"},
        description = "Debug Command",
        usage = "true/false",
        tabCompletion = {BOOLEAN})
public class Debug extends CubeCommand{
    @Override
    public void OnCommand(String[] args) {
        if(args[0].equalsIgnoreCase("true") || args[0].equalsIgnoreCase("t") ) {
            DEBUGMODE = true;
            Systems.out.println("[SYSTEM] Debug mode is " + DEBUGMODE);
            Systems.debug.println("DEBUGMODE: "+ DEBUGMODE);
        }else if(args[0].equalsIgnoreCase("false") || args[0].equalsIgnoreCase("f") ) {
            DEBUGMODE = false;
            Systems.out.println("[SYSTEM] Debug mode is " + DEBUGMODE);
            Systems.debug.println("DEBUGMODE: "+ DEBUGMODE);
        }else if(args[0].equalsIgnoreCase("start")){
            SerhStart();
        }else if(args[0].equalsIgnoreCase("get")){
            Cube cube = new Cube();
            cube.setMoveCount(1);
            Systems.out.println(cube.getMoveCount());
            Systems.out.println("改行");
            Systems.out.println(cube);
        }
    }
}
