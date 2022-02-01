package GUI;

import Systems.Systems;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static Commands.CommandManager.onTabComplete;
import static Events.Command.CommandEvent;
import static Systems.Systems.trimLeft;


public class CommandLine extends JPanel implements ActionListener, KeyListener {

    public static JTextPane CommandLine = new JTextPane();//出力エリア
    public static JTextField input = new JTextField(); //入力エリア
    private static JScrollPane scrollPane = new JScrollPane(CommandLine);//スクロールバー
    public static ArrayList<String> commandList = new ArrayList<>();//入力コマンドログ
    public static int commandCount = -1;//コマンド入力回数
    public static Boolean ActiveCommandLine = false; //コマンドライン入力の許可/拒否

    public CommandLine(){ //コマンドラインのUI

        //画面サイズの設定
        CommandLine.setPreferredSize(new Dimension(480,310));//TODO 元に戻す480, 310
        input.setPreferredSize(new Dimension(480,25));

        //背景色の設定
        CommandLine.setBackground(Color.BLACK);
        input.setBackground(Color.BLACK);

        //文字色の設定
        CommandLine.setForeground(Color.WHITE);
        input.setForeground(Color.WHITE);

        //カーソルの色設定
        input.setCaretColor(Color.red);

        //出力画面の編集不可
        CommandLine.setEditable(false);

        //TABキーを判定するための設定
        input.setFocusTraversalKeysEnabled(false);

        //イベントの有効化
        input.addActionListener(this);
        input.addKeyListener(this);

        //input.addCommandListner(this); TODO いる？

        //コマンドライン本体の設定------------------------

        //パネルの作成
        JPanel p = new JPanel();

        //レイアウトを縦方向に設定
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        //p.add(CommandLine);

        //パネルにパーツを追加
        p.add(scrollPane);
        p.add(input);
        add(p,BorderLayout.CENTER);
    }

    /**
     * ActionListenerが発生したときに使う
     * ActionEventの内容をCommandEventに渡してコマンドを実行させる
     */
    public void actionPerformed(ActionEvent e) {
        CommandEvent(e);
    }

    /**
     *  入力値が一致しているかチェック
     * @param str 入力値
     * @param string 比べる元
     * @return 一致ならTrue 不一致ならFlase
     */
    public static boolean check(String str, String string){
        return str.equalsIgnoreCase(string);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * キーが押されたときに呼ばれる
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            if (!commandList.isEmpty()) {
                if(commandCount > 0)
                    commandCount--;
                input.setText(commandList.get(commandCount));
            }
        }else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            if (!commandList.isEmpty()) {
                if(commandCount < commandList.size() - 1){
                    commandCount++;
                }else{
                    commandCount = commandList.size();
                    input.setText("");
                    return;
                }
                if(!(commandCount >= commandList.size())){
                    input.setText(commandList.get(commandCount));
                }
            }
        }
    }

    /**
     *
     * キーを離したときによばれる
     */
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar() == KeyEvent.VK_TAB){
            String str = input.getText();
            str = trimLeft(str);
            String[] args = str.split(" ");
            List<String> list;
            try{
                list = onTabComplete(args);
                if(list.size() == 0){
                    return;
                }else if(list.size() == 1){
                    input.setText(list.get(0));
                    return;
                }
                Systems.out.println(String.join(" ", Objects.requireNonNull(list)));
            }catch (NullPointerException ex){
                Systems.err.println("restart コマンドを実行するのをオススメします。");
            }
        }
    }
}
