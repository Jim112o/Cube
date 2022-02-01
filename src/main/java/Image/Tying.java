package Image;

import javax.swing.*;
import java.awt.*;

public class Tying extends JPanel{

    public static ImageIcon card ;


    private static JLabel icon = new JLabel();

    /**
     *
     * @param image imageをiconに設定する
     * @return 表示
     */
    public static JLabel tying(String image){
        card = new ImageIcon("src\\main\\java\\Image\\"+image+".png"); //画像を取得
        JLabel iicon = new JLabel(card); //Labelに入れる
        icon.setIcon(card);
        return iicon; //返す
    }

    /**
     *
     * @param image imageを取得
     * @return 画像を返す
     */
    public static ImageIcon imageIcon(String image){
        return new ImageIcon("src\\main\\java\\Image\\"+image+".png");
    }

    /**
     *
     * @param label ラベルに画像をつける
     * @return 画像付きになって返る
     */
    public static JLabel tying(JLabel label){
        label.setIcon(new ImageIcon("src\\main\\java\\Image\\"+label.getText()+".png"));
        return label;
    }

    /**
     *
     * @param label 画像をつけるラベル
     * @param image 画像名
     */
    public static void tying(JLabel label, String image){
        ImageIcon icon0 = new ImageIcon("src\\main\\java\\Image\\"+image+".png");
        Image smallImg = icon0.getImage().getScaledInstance((int) (icon0.getIconWidth() * 0.5), -1, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(smallImg);
        label.setIcon(icon);
    }

}
