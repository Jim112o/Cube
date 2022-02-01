package Commands;

import Systems.Systems;

@CommandInfo(
        aliases = {"pll"},
        description = "PLLの動きのリストを出力します。",
        usage = "[string] [string]"
)
public class PLL  extends CubeCommand{

    @Override
    public void OnCommand(String[] args) {
        if(args.length == 0){
            Systems.out.println("使い方:(例) \"cube pll U b\" = U-perm:b");
            return;
        }
        if(args[0].equalsIgnoreCase("U") || (args[0].equalsIgnoreCase("ua")) || (args[0].equalsIgnoreCase("ub"))){
            if(args.length == 1){
                if(args[0].equalsIgnoreCase("ua")){
                    Systems.out.println(Systems.getCode().UaPerm);
                }else if (args[0].equalsIgnoreCase("ub")){
                    Systems.out.println(Systems.getCode().UbPerm);
                }
            }else{
                if(args[1].equalsIgnoreCase("A")){
                    Systems.out.println(Systems.getCode().UaPerm);

                }else if(args[1].equalsIgnoreCase("B")){
                    Systems.out.println(Systems.getCode().UbPerm);
                }else{
                    Systems.err.println("ｺﾏﾝﾄﾞﾐｽｯﾃﾙﾖ");
                }
            }

        }else if(args[0].equalsIgnoreCase("Z")){
            Systems.out.println(Systems.getCode().ZPerm);

        }else if(args[0].equalsIgnoreCase("H")){
            Systems.out.println(Systems.getCode().HPerm);

        }
    }
}
