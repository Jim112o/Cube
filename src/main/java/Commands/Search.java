package Commands;

import Systems.Systems;

import static MAIN.Cube.DEBUGMODE;
import static Systems.Search.*;

@CommandInfo(
        aliases = {"status"},
        description = "",
        usage = "[c/e] [NUM] [up-color/down-color] [front-color/back-color] [side-color]",
        tabCompletion = CommandTabCompletion.COLOR
)
public class Search extends CubeCommand{

    @Override
    public void OnCommand(String[] args) {
        int num;
        if(isNumber(args[1])){
            num = Integer.parseInt(args[1]);
        }else{
            Systems.err.println("Argument 2 should be a number." +
                    "Type \"cube help\"");//引数2は数字を入力してください。
            return;
        }
        if(args[0].equalsIgnoreCase("c")){
            if(INFO != CORNER && !DEBUGMODE){
                Systems.err.println(getStrings().NowThisIsACommandThatIsNotAvailable);//今は、使えないコマンドです。
                return;
            }
            if(num > 8){
                Systems.err.println(getStrings().CornerPartNumbersAre0To7);//コーナーパーツ番号は0～7です。
                return;
            }
            if(args.length != 5){
                Systems.err.println(getStrings().TheArgumentIsIncorrect);
                return;
            }
            int up_color = getColor(args[2]);
            int fb_color = getColor(args[3]);
            int side_color = getColor(args[4]);
            if(up_color == 99 || fb_color == 99 || side_color == 99 ){
                Systems.err.println(getStrings().ColorIsNotEnteredCorrectly);//色が正しく入力されていません。
                return;
            }
            int[] cpco = getCornerParts(up_color,fb_color,side_color, String.valueOf(num));
            if(cpco[0] == 99 || cpco[1] == 99){
                Systems.err.println(getStrings().CantFindTheCorrespondingPart + getStrings().PleaseCheckTheColorAgain);//対応するパーツが見つかりません。色を再度確認してください。
                return;
            }
            cp[num] = cpco[0];
            co[num] = cpco[1];
            Systems.debug.println(num+"の場所には["+cp[num]+"]が入っており、向きは["+co[num]+"]です。");
        }else if(args[0].equalsIgnoreCase("e")){
            if(INFO != EDGE && !DEBUGMODE){
                Systems.err.println(getStrings().NowThisIsACommandThatIsNotAvailable);//今は、使えないコマンドです。
                return;
            }
            if(num > 12){
                Systems.err.println(getStrings().TheEdgePartNumbersAre0To11);//エッジパーツ番号は0～11です。
                return;
            }
            if(args.length != 4){
                Systems.err.println(getStrings().TheArgumentIsIncorrect);
                return;
            }
            int up_color = getColor(args[2]);
            int side_color = getColor(args[3]);
            if(up_color == 99 || side_color == 99 ){
                Systems.err.println(getStrings().ColorIsNotEnteredCorrectly);//色が正しく入力されていません。
                return;
            }
            int[] epeo = getEdgeParts(up_color,side_color);
            if(epeo[0] == 99 || epeo[1] == 99){
                Systems.err.println(getStrings().CantFindTheCorrespondingPart + getStrings().PleaseCheckTheColorAgain);//対応するパーツが見つかりません。色を再度確認してください。
                return;
            }
            ep[num] = epeo[0];
            eo[num] = epeo[1];
            Systems.debug.println(num+"の場所には["+ep[num]+"]が入っており、向きは["+eo[num]+"]です。");

        }
    }

    private boolean isNumber(String num) {
        try {
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
