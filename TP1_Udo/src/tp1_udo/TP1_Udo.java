package tp1_udo;

import javax.swing.ImageIcon;

public class TP1_Udo {

    public static void main(String[] args) {

        ImageIcon icon = new ImageIcon("image/u.png");
        Fenetre jeu = new Fenetre("Udo", 1000, 500, icon);
        jeu.creerFenetre1();

    }

}
