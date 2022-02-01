package Commands;

import Systems.Systems;
import String.StringManager;

import static Commands.CommandTabCompletion.LANGUAGE;
import static GUI.CommandLine.check;
import static MAIN.Cube.language;
import static MAIN.Cube.ranking;
import static Systems.Systems.getStrings;

@CommandInfo(
        aliases = {"language","l"},
        description = "言語変更",
        usage = "[jp/en]",
        tabCompletion = {LANGUAGE})
public class Language extends CubeCommand {

    @Override
    public void OnCommand(String[] args) {
        if(check(args[0],"jp") || check(args[0],"en"))
            language = args[0];
        else
            return;
        Systems.stringManager = new StringManager(language);
        Systems.out.println("");
        Systems.out.println("");
        Systems.Setup();
        Systems.out.println(getStrings().changeLanguage);
        ranking.setTitle(getStrings().ranking);
    }
}
