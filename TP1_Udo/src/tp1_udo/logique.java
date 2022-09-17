/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1_udo;

import java.awt.Color;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Random;
import java.util.Scanner;
import javax.swing.JButton;

/**
 *
 * @author Mohamed
 */
public class logique {

    int nbCasesVertes;
    public String grille;
    public JButton[][] bouttons;
    public JButton boutton;
    public char[][] nombre;
    public char[][] nombresDeJeu;
    public char[][] tableauDuJeu;
    public String[][] tab;
    public int grilleChoisie;
    int nbGrilles = 1;

    public logique(String grille) {
        this.grille = grille;
    }

    public logique(JButton[][] bouttons) {
        this.bouttons = bouttons;

    }

    public String[][] lireGrille() {
        // permet de faire un gros string 
        String text = "";
        int compteur = 0;
        try {
            Scanner s1 = new Scanner(new File(grille));
            while (s1.hasNextLine()) {
                compteur = compteur + 1;
                text = text + s1.nextLine();

            }

        } catch (FileNotFoundException e) {
            System.out.println("erreur 1");
        }

        nombre = new char[compteur][4];
        int k = 0;
        //fait le tableau de char a partir d'un string 
        for (int i = 0; i < compteur; i++) {

            for (int j = 0; j < 4; j++) {
                nombre[i][j] = text.charAt(k);
                k++;

            }
        }
        //compter le nombre de grilles
        for (int i = 0; i < compteur; i++) {
            if (nombre[i][0] == '-' && nombre[i][1] == '-' && nombre[i][2] == '-' && nombre[i][3] == '-') {
                nbGrilles = nbGrilles + 1;

            }

        }

        //un gros tableau des nombres sans les -
        nombresDeJeu = new char[compteur][4];
        for (int i = 0; i < compteur; i++) {
            for (int j = 0; j < 4; j++) {
                if (nombre[i][0] == '-' && nombre[i][1] == '-' && nombre[i][2] == '-' && nombre[i][3] == '-') {
                    i = i + 1;
                    nombresDeJeu[i][j] = nombre[i][j];

                } else {
                    nombresDeJeu[i][j] = nombre[i][j];
                }
            }

        }
        //nombre aléatoire entre 0 et le nombre de grille
        Random rand = new Random();
        grilleChoisie = rand.nextInt(nbGrilles);

        //
        //for(int i = 0+(grilleChoisie*4);i<4+(grilleChoisie*4);i++){
        for (int i = 0; i < compteur; i++) {
            for (int j = 0; j < 4; j++) {

            }

        }
        //crée le tableau de jeu choisie par le nombre aléatoire
        tableauDuJeu = new char[4][4];
        if (grilleChoisie == 0) {
            for (int i = 0 + ((grilleChoisie * 4)); i < 4 + ((grilleChoisie * 4)); i++) {

                for (int j = 0; j < 4; j++) {

                    tableauDuJeu[i - ((grilleChoisie * 4))][j] = nombresDeJeu[i][j];

                }

            }
        } else {
            for (int i = 0 + ((grilleChoisie * 4) + grilleChoisie); i < 4 + ((grilleChoisie * 4) + grilleChoisie); i++) {

                for (int j = 0; j < 4; j++) {

                    tableauDuJeu[i - ((grilleChoisie * 4) + grilleChoisie)][j] = nombresDeJeu[i][j];

                }

            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

            }

        }
        tab = new String[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (tableauDuJeu[i][j] == ' ') {
                    tab[i][j] = null;
                } else if (tableauDuJeu[i][j] == '1') {
                    tab[i][j] = "1";
                } else if (tableauDuJeu[i][j] == '2') {
                    tab[i][j] = "2";
                } else if (tableauDuJeu[i][j] == '3') {
                    tab[i][j] = "3";
                } else if (tableauDuJeu[i][j] == '4') {
                    tab[i][j] = "4";
                }

            }
        }
        for (int i = 0; i < 4; i++) {

        }
        return tab;
    }

    public int verifier() {
        //verifications
        int nbVerif = 0;
        nbCasesVertes = 0;
        String tab1 = null;
        String tab2 = null;
        String tab3 = null;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                nbVerif = 0;
                tab1 = bouttons[i][0].getText() + bouttons[i][1].getText() + bouttons[i][2].getText() + bouttons[i][3].getText();
                if (tab1.contains("1") && tab1.contains("2") && tab1.contains("3") && tab1.contains("4")) {

                    nbVerif = nbVerif + 1;

                }
                tab2 = bouttons[0][j].getText() + bouttons[1][j].getText() + bouttons[2][j].getText() + bouttons[3][j].getText();
                if (tab2.contains("1") && tab2.contains("2") && tab2.contains("3") && tab2.contains("4")) {

                    nbVerif = nbVerif + 1;

                }
                tab3 = bouttons[0][0].getText() + bouttons[0][3].getText() + bouttons[3][3].getText() + bouttons[3][0].getText();
                if (tab3.contains("1") && tab3.contains("2") && tab3.contains("3") && tab3.contains("4")) {
                    nbVerif = nbVerif + 1;
                }

                if (nbVerif == 0) {
                    bouttons[i][j].setBackground(Color.black);
                } else if (nbVerif == 1) {
                    bouttons[i][j].setBackground(new Color(1, 140, 0));
                } else if (nbVerif == 2) {
                    bouttons[i][j].setBackground(new Color(1, 200, 0));
                } else if (nbVerif == 3) {
                    bouttons[i][j].setBackground(Color.green);
                }
                if (bouttons[i][j].getBackground() == Color.green) {
                    nbCasesVertes = nbCasesVertes + 1;
                }

            }

        }
        return nbCasesVertes;
    }

}
