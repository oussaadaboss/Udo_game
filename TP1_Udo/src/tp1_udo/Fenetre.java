package tp1_udo;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JPanel;

public class Fenetre implements ActionListener {
    // variables

    int nbCasesValides;
private boolean recommencer= false;
    private JFrame onglet;
    private JFrame onglet1;
    private final int hauteur, longeur;
    private int changements = 0;
    private final String titre;
    private final ImageIcon icon;
    private JPanel panel;
    private JPanel panel_1;
    private JPanel panel_2;
    private JPanel panel_3;
    private JPanel panel_4;
    private JPanel panel_5;
    private JPanel panel2;
    private JPanel panel3;
    private JButton button;
    private JButton button1;

    public JButton[][] cases;
    public String[][] tab;
    public String[][] tab2;
    public logique boutton;

    //constructeur 
    public Fenetre(String titre, int longeur, int hauteur, ImageIcon icon) {
        this.titre = titre;
        this.hauteur = hauteur;
        this.longeur = longeur;
        this.icon = icon;

    }

    // methodes
    public void creerFenetre1() {
        do{
        // fenetre
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        onglet = new JFrame(this.titre);
        onglet.setSize(this.longeur, this.hauteur);
        onglet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        onglet.setResizable(false);
        onglet.setLocationRelativeTo(null);
        onglet.setVisible(true);
        onglet.setIconImage(this.icon.getImage());
        onglet.add(panel);
        panel.setLayout(null);

        //buttons
        button = new JButton();
        button.setBounds((this.longeur / 2) - 80, (this.hauteur / 2) - 35, 150, 50);
        button.setText("Jouer");
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                onglet.setVisible(false);
                creeFenetre2();

            }
        });
        panel.add(button);

        button1 = new JButton();
        button1.setBounds((this.longeur / 2) - 80, (this.hauteur / 2) + 25, 150, 50);//x,y,width,hight
        button1.setText("Quitter");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(button1);
        // labels

        JLabel label = new JLabel("UDO");
        label.setBounds((this.longeur / 2) - 50, (this.hauteur / 2) - 150, 100, 100);
        label.setFont(new Font("MV Boli", Font.BOLD, 40));
        panel.add(label);
        // layouts
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.red);
        panel_2.setPreferredSize(new Dimension(10, 10));
        onglet.add(panel_2, BorderLayout.NORTH);

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(Color.red);
        panel_3.setPreferredSize(new Dimension(10, 10));
        onglet.add(panel_3, BorderLayout.SOUTH);

        JPanel panel_4 = new JPanel();
        panel_4.setBackground(Color.red);
        panel_4.setPreferredSize(new Dimension(10, 10));
        onglet.add(panel_4, BorderLayout.EAST);

        JPanel panel_5 = new JPanel();
        panel_5.setBackground(Color.RED);
        panel_5.setPreferredSize(new Dimension(10, 10));
        onglet.add(panel_5, BorderLayout.WEST);
        }while(recommencer);
    }

    public void creeFenetre2() {
        
        onglet1 = new JFrame(this.titre);
        onglet1.setSize(this.longeur, this.hauteur);
        onglet1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        onglet1.setResizable(false);
        onglet1.setLocationRelativeTo(null);
        onglet1.setVisible(true);
        onglet1.setIconImage(this.icon.getImage());

        panel2 = new JPanel();
        panel2.setBounds(620, 20, 350, 350);
        panel2.setBackground(Color.red);
        onglet1.add(panel2, BorderLayout.CENTER);
        panel2.setLayout(new GridLayout(4, 4));
        //
        panel3 = new JPanel();
        panel3.setBounds(100, 222, 330, 330);
        panel3.setBackground(Color.white);
        onglet1.add(panel3, BorderLayout.CENTER);
        panel3.setLayout(null);
        // layouts
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.red);
        panel_2.setPreferredSize(new Dimension(10, 10));
        onglet1.add(panel_2, BorderLayout.NORTH);

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(Color.red);
        panel_3.setPreferredSize(new Dimension(10, 10));
        onglet1.add(panel_3, BorderLayout.SOUTH);

        JPanel panel_4 = new JPanel();
        panel_4.setBackground(Color.red);
        panel_4.setPreferredSize(new Dimension(10, 10));
        onglet1.add(panel_4, BorderLayout.EAST);

        JPanel panel_5 = new JPanel();
        panel_5.setBackground(Color.RED);
        panel_5.setPreferredSize(new Dimension(10, 10));
        onglet1.add(panel_5, BorderLayout.WEST);

        //tableau de cases
        tab = creeTab();
        
        cases = new JButton[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                cases[i][j] = new JButton();

                if (tab[i][j] == null) {
                    cases[i][j].setBackground(Color.white);
                    cases[i][j].addActionListener(this);

                }

                cases[i][j].setText(tab[i][j]);
                panel2.add(cases[i][j]);

            }

        }

        //bouttons
        //labels
        JLabel label = new JLabel("UDO");
        label.setBounds(10, 0, 100, 100);
        label.setFont(new Font("MV Boli", Font.BOLD, 40));
        panel3.add(label);

        //
        panel3.revalidate();
        panel3.repaint();
    }

    public String[][] creeTab() {
        tab = new String[4][4];
        logique a = new logique("fichier123.txt");
        tab = a.lireGrille();

        return tab;
    }

    public void reStart() {
        String[] choix = {"oui", "non"};
        String decision = (String) JOptionPane.showInputDialog(onglet1, "voulez vous recommencer ?", "recommencer", JOptionPane.WARNING_MESSAGE, null, choix, null);
        if (decision == "oui") {
            onglet1.setVisible(false);
          creeFenetre2();
            
        } else if (decision == "non") {

            System.exit(0);
        }
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {

        tab2 = new String[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                if (e.getSource() == cases[i][j] && cases[i][j].getText() == null) {
                    cases[i][j].setText("1");
                    for (int a = 0; a < 4; a++) {
                        for (int b = 0; b < 4; b++) {
                            tab2[a][b] = cases[a][b].getText();

                        }

                    }
                } else if (e.getSource() == cases[i][j] && cases[i][j].getText().equals("1")) {
                    cases[i][j].setText("2");
                } else if (e.getSource() == cases[i][j] && cases[i][j].getText().equals("2")) {
                    cases[i][j].setText("3");
                } else if (e.getSource() == cases[i][j] && cases[i][j].getText().equals("3")) {
                    cases[i][j].setText("4");
                } else if (e.getSource() == cases[i][j] && cases[i][j].getText().equals("4")) {
                    cases[i][j].setText("1");
                }
                

                if (e.getSource() == cases[i][j]) {
                    logique p = new logique(cases);
                    nbCasesValides = p.verifier();
                    changements = changements + 1;
                }

            }
        }
        if (nbCasesValides == 16) {
            JLabel nbChangements = new JLabel("Nombre de changements : " + changements);
            nbChangements.setBounds(20, 70, 250, 50);
            panel3.add(nbChangements);
            panel3.revalidate();
            panel3.repaint();
            reStart();

        }

    }

}
