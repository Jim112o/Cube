package Commands;

import Systems.Systems;
import Commands.CommandManager.*;

import java.util.ArrayList;

@CommandInfo(
        aliases = {"help"},
        description = "説明",
        usage = "[page]")
public class Help extends CubeCommand {

    @Override
    public void OnCommand(String[] args) {
        int page = 1;
        if(args.length > 0){
            try{
                page = Integer.parseInt(args[0]);
            } catch (NumberFormatException ex){
                Systems.out.println("[ERROR] 数値を入力してください。");
                return;
            }
        }

        ArrayList<String> commandList = new ArrayList<>();
        for(CubeCommand cmd : CommandManager.getCommands()){
            CommandInfo info = cmd.getClass().getAnnotation(CommandInfo.class);
            commandList.add("- " + String.join(":",info.aliases()) + " "
                                + info.usage() + " - "
                                + info.description());
        }

        int commandListLength = CommandManager.getCommands().size();
        int maxItemperPage = 8;
        int totalPages = 1;

        for(int i = 0; i < commandListLength / maxItemperPage; i++){
            totalPages++;
        }

        if(commandListLength % maxItemperPage == 0){
            totalPages--;
        }

        if(page > totalPages){
            if(totalPages > 1)
                Systems.out.println("There are only "+ totalPages + " pages.");
            else
                Systems.out.println("There is only 1 page.");
            return;
        }

        int currentItem = ((page * maxItemperPage) - maxItemperPage);
        // 2 * 3 = 6 ; 6 - 3 = 3

        Systems.out.println("Help menu");
        Systems.out.println("Page " + page + "of " + totalPages);

        if(totalPages == 0){
            Systems.out.println("Command no data");
        }else{
            for(int i = currentItem; i < (currentItem + maxItemperPage); i++){
                if(!(i >= commandListLength))
                    Systems.out.println(commandList.get(i));
            }
        }
    }


}
