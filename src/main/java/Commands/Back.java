package Commands;


import static MAIN.Cube.*;

@CommandInfo(
        aliases = {"back","b"},
        description = "Command Line を背面に移動",
        usage = "")
public class Back extends CubeCommand {
    @Override
    public void OnCommand(String[] args) {
        ranking.toFront();
        stopwatch.toFront();
        return;
    }
}
