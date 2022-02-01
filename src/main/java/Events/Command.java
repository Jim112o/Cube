package Events;

import Systems.Exit;
import Systems.StartUp;
import Systems.Systems;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static Commands.CommandManager.OnCommand;
import static GUI.CommandLine.*;
import static MAIN.Cube.DEBUGMODE;


public class Command {

    /**
     * actionPerformedから渡された内容を受け取って
     * コマンドを実行する準備まで
     */
    public static void CommandEvent(ActionEvent e){
        String str;

        if (e.getSource() == input) {//入力されたら


            str = input.getText();//入力内容を取得

            //単純コマンド--------------------------------------------

            //終了系コマンドが入力されたときの動作
            if(check(str,"exit") || check(str,"bye")){ input.setText("");Systems.INPUTLOCK(true);new Exit("bye");return; }

            //出力画面のクリア コマンドが入力されたときの動作
            if(check(str,"clear") || check(str,"cls")){commandList.add(str); CommandLine.setText(""); input.setText(""); return;}

            //再起動
            if(str.equals("restart")){new StartUp(8); if(!DEBUGMODE){input.setText("RESTART");}else{input.setText("");} commandList.clear(); return;}

            //ここまで

            //複雑コマンド-----------------------------------------------------

            //スペースで区切ってargsにしまう
            String[] args = str.trim().split(" ");


            if(!(check(args[0],""))){//入力されたものが何かしらの文字だったら

                //直近と異なるコマンドを入力していればコマンドリストに追加する
                if(!(commandList.contains(String.join(" ",args)))){
                    commandList.add(String.join(" ",args));
                }


                //コマンド入力回数を増やす
                commandCount = commandList.size();

            }else{//何も入力されてないとき＞を出力、改行して終了
                Systems.out.println(">");
                input.setText("");
                return;
            }

            //複雑コマンドの条件分岐---------------------------------------------------

            //1単語目をcommandに入れる
            //commandはメインのコマンド名が入ってる
            String command = args[0];

            //cube系コマンドの場合
            if(command.equalsIgnoreCase("cube") || command.equalsIgnoreCase("c")){

                ArrayList<String> cmds = new ArrayList<>(Arrays.asList(args));
                cmds.remove(0);
                int size = cmds.size();
                args = cmds.toArray(new String[size]);
            }
            Systems.out.println("> " + str);
            try{
                OnCommand(command, args);
            }catch (NullPointerException ex){
                Systems.err.println("StartUpが正常に行われていません。");
            }
            input.setText("");
        }
    }
}
