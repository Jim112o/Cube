package Commands;

import GUI.CommandLine;
import Systems.Systems;

import java.util.*;

import static Commands.CommandTabCompletion.*;
import static Systems.Systems.MatchCheck;

public class CommandManager{

    private static ArrayList<CubeCommand> cmds;

    public CommandManager(){
        cmds = new ArrayList<>();
        cmds.add(new Help());
        cmds.add(new Show());
        cmds.add(new Hide());
        cmds.add(new Language());
        cmds.add(new Debug());
        cmds.add(new MoveCommand());
        cmds.add(new Search());
        cmds.add(new Back());
        cmds.add(new PLL());
    }

    public static boolean OnCommand(String command, String[] args){
        if(command.equalsIgnoreCase("cube") || command.equalsIgnoreCase("c")){
            if(args.length == 0){
                int timer = 0;
                for(CubeCommand gcmd : cmds){
                    if(timer == 0)
                        Systems.out.println("Help menu");
                    if(timer >= 8) {
                        Systems.out.println("Use \"cube help 2\" for the next page.");
                        break;
                    }

                    CommandInfo info = gcmd.getClass().getAnnotation(CommandInfo.class);
                    Systems.out.println("- " + "cube" +
                            String.join("|",info.aliases()) + getCommandUsage(info) + " - " +
                            info.description());
                    timer++;
                }
                return true;
            }

            CubeCommand wanted = null;

            for (CubeCommand gcmd : cmds){
                CommandInfo info = gcmd.getClass().getAnnotation(CommandInfo.class);
                for (String alias : info.aliases()){
                    if(alias.equals(args[0])){
                        wanted = gcmd;
                        break;
                    }
                }
            }

            if(wanted == null){
                Systems.out.println("command Not Found.");
                return true;
            }

            Vector<String> a = new Vector<>(Arrays.asList(args));
            a.remove(0);
            args = a.toArray(new String[0]);

            try{
                wanted.OnCommand(args);
                return true;
            } catch (RuntimeException ex){
                Systems.err.println("An internal error occurred while attempting to perform this command");
                Systems.debug.println(ex);
            }
        }else{
            CubeCommand wanted = null;

            for (CubeCommand gcmd : cmds){
                CommandInfo info = gcmd.getClass().getAnnotation(CommandInfo.class);
                for (String alias : info.aliases()){
                    if(alias.equals(args[0])){
                        wanted = gcmd;
                        break;
                    }
                }
            }

            if(wanted == null){
                Systems.out.println("command Not Found.");
                return false;
            }

            Vector<String> a = new Vector<>(Arrays.asList(args));
            a.remove(0);
            args = a.toArray(new String[0]);

            try{
                wanted.OnCommand(args);
                return true;
            } catch (RuntimeException ex){
                Systems.err.println("An internal error occurred while attempting to perform this command");
            }
        }
        return false;
    }

    public static List<String> onTabComplete(String[] args){
        int length = args.length;
        List<String> completions = new ArrayList<>();
        if(length == 1){
            String partial = args[0];
            List<String> commands = new ArrayList<>();
            for(CubeCommand cmd : CommandManager.cmds){
                commands.add(cmd.getClass().getAnnotation(CommandInfo.class).aliases()[0]);
            }
            if(partial.equalsIgnoreCase("")){
                return Collections.singletonList("cube help");
            }
            for (String cmd : commands){
                if(MatchCheck(cmd,partial))
                    completions.add(cmd);
                if(partial.equalsIgnoreCase(cmd)){
                    length += 1;
                    args = new String[]{String.join(",",args)," "};
                }
            }
        }
        if(length >= 2){
            CubeCommand wanted = null;

            for (CubeCommand cmd : CommandManager.cmds){
                CommandInfo info = cmd.getClass().getAnnotation(CommandInfo.class);
                for (String alias : info.aliases()){
                    if(alias.equals(args[0])){
                        wanted = cmd;
                        break;
                    }
                }
            }

            if(wanted != null){
                if(length == 2){
                    List<String> availableCompletions = getPossibleTabCompletions(wanted, 0);
                    List<String> ret = new ArrayList<>();
                    if(availableCompletions.size() != 0){
                        for(String tab : availableCompletions){
                            if(tab != null){
                                if(MatchCheck(tab,args[1])){
                                    ret.add(tab);
                                }
                            }
                        }
                        if(ret.isEmpty()){
                            Systems.out.println(args[0] + " "  + availableCompletions);
                            CommandLine.input.setText(args[0] + String.format("%-1s",""));
                            System.out.println("スペース");
                        }else{
                            if(ret.size() == 1){
                                CommandLine.input.setText(args[0] + " " + ret.get(0));
                            }else{
                                CommandLine.input.setText(args[0]);
                            }
                            Systems.out.println(args[0] + " "  + ret);
                        }
                    }
                }else if(length == 3){
                    List<String> availableCompletions = getPossibleTabCompletions(wanted, 1);
                    if(availableCompletions.size() != 0){
                        Systems.out.println(args[0] + " " + args[1] + availableCompletions);
                        CommandLine.input.setText(args[0] + " " + args[1] + " ");
                    }
                }
            }
            Collections.sort(completions);
        }
        return completions;
    }

    static List<CubeCommand> getCommands(){
        return cmds;
    }

    private static String getCommandUsage(CommandInfo info){
        if(info.usage().equalsIgnoreCase(""))
            return "";
        else
            return " " + info.usage();
    }

    private static List<String> getPossibleTabCompletions(CubeCommand command, int index){
        List<String> availableCompletions = new ArrayList<>();

        CommandTabCompletion[] tabCompletion = command.getClass().getAnnotation(CommandInfo.class).tabCompletion();
        if(tabCompletion.length >= index + 1){
            if(tabCompletion[index] == COLOR){
                availableCompletions.addAll(Arrays.asList(Systems.CJ));
            }else if(tabCompletion[index] == DIRECTION){
                availableCompletions.add("right");
                availableCompletions.add("left");
                availableCompletions.add("back");
                availableCompletions.add("front");
                availableCompletions.add("up");
                availableCompletions.add("down");
                availableCompletions.add("middle");
            }else if(tabCompletion[index] == GUI){
                availableCompletions.add("stopwatch");
                availableCompletions.add("ranking");
                availableCompletions.add("all");
            }else if(tabCompletion[index] == LANGUAGE){
                availableCompletions.add("jp");
                availableCompletions.add("en");
            }else if(tabCompletion[index] == BOOLEAN){
                availableCompletions.add(Boolean.TRUE.toString());
                availableCompletions.add(Boolean.FALSE.toString());
            }
        }
        return availableCompletions;
    }
}
