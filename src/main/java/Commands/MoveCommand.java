package Commands;

import Cube.Move.Move;

import static Cube.CubeManager.STATUS;


@CommandInfo(
        aliases = {"move"},
        description = "Cube App Command",
        usage = "help",
        tabCompletion = {CommandTabCompletion.DIRECTION})
public class MoveCommand extends CubeCommand{
    @Override
    public void OnCommand(String[] args) {
        if(args[0].equalsIgnoreCase("right")){
            if(args.length == 1)
                Cube.Move.Move.Right(1);
            else
                Cube.Move.Move.Right(Integer.parseInt(args[1]));
        }else if(args[0].equalsIgnoreCase("now")){
            STATUS();
        }
    }
}
