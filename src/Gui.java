


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calculatrice extends JFrame {
    private JPanel container = new JPanel();
    //Tableau stockant les éléments à afficher dans la calculatrice
    String[] tab_string = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", "=", "C", "+", "-", "*", "/", "(", ")", "%", "π", "e", "Rad", "Inv", "Ans", "sin", "cos", "tan", "?", "Exp", "x!", "ln", "log", "√", "xy"};
    //Un bouton par élément à afficher
    JButton[] tab_button = new JButton[tab_string.length];
    private JLabel ecran = new JLabel();
    // private Dimension dim = new Dimension(60, 40);
    private Dimension dim2 = new Dimension(60,25);

    private double chiffre1;
    private boolean clicOperateur = false, update = false;
    private String operateur = "";

    public Calculatrice(){
        this.setSize(540,218);
        this.setTitle("Calculette");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        //On initialise le conteneur avec tous les composants
        initComposant();
        //On ajoute le conteneur
        this.setContentPane(container);
        this.setVisible(true);
    }

    private void initComposant(){
        //On définit la police d'écriture à utiliser
        Font police = new Font("Arial", Font.BOLD, 20);
        ecran = new JLabel("0");
        ecran.setFont(police);
        //On aligne les informations à droite dans le JLabel
        ecran.setHorizontalAlignment(JLabel.RIGHT);
        ecran.setPreferredSize(new Dimension(490,20));
        JPanel operateur = new JPanel();
        operateur.setPreferredSize(new Dimension(70,205));
        JPanel chiffre = new JPanel();
        chiffre.setPreferredSize(new Dimension(220,205));
        JPanel panEcran = new JPanel();
        panEcran.setPreferredSize(new Dimension(490,25));

        JPanel charakter = new JPanel();
        charakter.setPreferredSize(new Dimension (220,205));
        //On parcourt le tableau initialisé
        //afin de créer nos boutons
        for(int i = 0; i < tab_string.length; i++){
            tab_button[i] = new JButton(tab_string[i]);
            //tab_button[i].setPreferredSize(dim);
            switch(i){
                //Pour chaque élément situé à la fin du tableau
                //et qui n'est pas un chiffre
                //on définit le comportement à avoir grâce à un listener
                case 11 :

                    tab_button[i].addActionListener(new EgalListener());
                    tab_button[i].setPreferredSize(dim2);
                    chiffre.add(tab_button[i]);
                    break;
                case 12 :
                    tab_button[i].setForeground(Color.red);
                    tab_button[i].addActionListener(new ResetListener());
                    tab_button[i].setPreferredSize(dim2);
                    operateur.add(tab_button[i]);
                    break;
                case 13 :
                    tab_button[i].addActionListener(new PlusListener());
                    tab_button[i].setPreferredSize(dim2);
                    operateur.add(tab_button[i]);
                    break;
                case 14 :
                    tab_button[i].addActionListener(new MoinsListener());
                    tab_button[i].setPreferredSize(dim2);
                    operateur.add(tab_button[i]);
                    break;
                case 15 :
                    tab_button[i].addActionListener(new MultiListener());
                    tab_button[i].setPreferredSize(dim2);
                    operateur.add(tab_button[i]);
                    break;
                case 16 :
                    tab_button[i].addActionListener(new DivListener());
                    tab_button[i].setPreferredSize(dim2);
                    operateur.add(tab_button[i]);
                    break;

                case 17:
                    tab_button[i].setPreferredSize(dim2);
                    chiffre.add(tab_button[i]);
                    break;
                case 18:
                    tab_button[i].setPreferredSize(dim2);
                    chiffre.add(tab_button[i]);
                    break;
                case 19:
                    tab_button[i].setPreferredSize(dim2);
                    chiffre.add(tab_button[i]);
                    break;
                case 20:
                    tab_button[i].setPreferredSize(dim2);
                    charakter.add(tab_button[i]);
                    break;
                case 21:
                    tab_button[i].setPreferredSize(dim2);
                    charakter.add(tab_button[i]);
                    break;
                case 22:
                    tab_button[i].setPreferredSize(dim2);
                    charakter.add(tab_button[i]);
                    break;

                case 23:
                    tab_button[i].setPreferredSize(dim2);
                    charakter.add(tab_button[i]);
                    break;
                case 24:
                    tab_button[i].setPreferredSize(dim2);
                    charakter.add(tab_button[i]);
                    break;
                case 25:
                    tab_button[i].setPreferredSize(dim2);
                    charakter.add(tab_button[i]);
                    break;
                case 26:
                    tab_button[i].setPreferredSize(dim2);
                    charakter.add(tab_button[i]);
                    break;
                case 27:
                    tab_button[i].setPreferredSize(dim2);
                    charakter.add(tab_button[i]);
                    break;
                case 28:
                    tab_button[i].setPreferredSize(dim2);
                    charakter.add(tab_button[i]);
                    break;
                case 29:
                    tab_button[i].setPreferredSize(dim2);
                    charakter.add(tab_button[i]);
                    break;
                case 30:
                    tab_button[i].setPreferredSize(dim2);
                    charakter.add(tab_button[i]);
                    break;
                case 31:
                    tab_button[i].setPreferredSize(dim2);
                    charakter.add(tab_button[i]);
                    break;
                case 32:
                    tab_button[i].setPreferredSize(dim2);
                    charakter.add(tab_button[i]);
                    break;
                case 33:
                    tab_button[i].setPreferredSize(dim2);
                    charakter.add(tab_button[i]);
                    break;
                case 34:
                    tab_button[i].setPreferredSize(dim2);
                    charakter.add(tab_button[i]);
                    break;

                default :
                    //Par défaut, ce sont les premiers éléments du tableau
                    //donc des chiffres, on affecte alors le bon listener
                    chiffre.add(tab_button[i]);
                    tab_button[i].addActionListener(new ChiffreListener());
                    tab_button[i].setPreferredSize(dim2);
                    break;
            }
        }
        panEcran.add(ecran);
        panEcran.setBorder(BorderFactory.createLineBorder(Color.black));
        container.add(panEcran, BorderLayout.NORTH);
        container.add(chiffre, BorderLayout.EAST);
        container.add(operateur, BorderLayout.WEST);
        container.add(charakter, BorderLayout.CENTER);
    }

    //Méthode permettant d'effectuer un calcul selon l'opérateur sélectionné
    private void calcul(){
        if(operateur.equals("+")){
            chiffre1 = chiffre1 +
                    Double.valueOf(ecran.getText()).doubleValue();
            ecran.setText(String.valueOf(chiffre1));
        }
        if(operateur.equals("-")){
            chiffre1 = chiffre1 -
                    Double.valueOf(ecran.getText()).doubleValue();
            ecran.setText(String.valueOf(chiffre1));
        }
        if(operateur.equals("*")){
            chiffre1 = chiffre1 *
                    Double.valueOf(ecran.getText()).doubleValue();
            ecran.setText(String.valueOf(chiffre1));
        }
        if(operateur.equals("/")){
            try{
                chiffre1 = chiffre1 /
                        Double.valueOf(ecran.getText()).doubleValue();
                ecran.setText(String.valueOf(chiffre1));
            } catch(ArithmeticException e) {
                ecran.setText("0");
            }
        }
    }

    //Listener utilisé pour les chiffres
    //Permet de stocker les chiffres et de les afficher
    class ChiffreListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            //On affiche le chiffre additionnel dans le label
            String str = ((JButton)e.getSource()).getText();
            if(update){
                update = false;
            }
            else{
                if(!ecran.getText().equals("0"))
                    str = ecran.getText() + str;
            }
            ecran.setText(str);
        }
    }

    //Listener affecté au bouton =
    class EgalListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
            calcul();
            update = true;
            clicOperateur = false;
        }
    }

    //Listener affecté au bouton +
    class PlusListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
            if(clicOperateur){
                calcul();
                ecran.setText(String.valueOf(chiffre1));
            }
            else{
                chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
                clicOperateur = true;
            }
            operateur = "+";
            update = true;
        }
    }

    //Listener affecté au bouton -
    class MoinsListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
            if(clicOperateur){
                calcul();
                ecran.setText(String.valueOf(chiffre1));
            }
            else{
                chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
                clicOperateur = true;
            }
            operateur = "-";
            update = true;
        }
    }

    //Listener affecté au bouton *
    class MultiListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
            if(clicOperateur){
                calcul();
                ecran.setText(String.valueOf(chiffre1));
            }
            else{
                chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
                clicOperateur = true;
            }
            operateur = "*";
            update = true;
        }
    }

    //Listener affecté au bouton /
    class DivListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
            if(clicOperateur){
                calcul();
                ecran.setText(String.valueOf(chiffre1));
            }
            else{
                chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
                clicOperateur = true;
            }
            operateur = "/";
            update = true;
        }
    }

    //Listener affecté au bouton de remise à zéro
    class ResetListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
            clicOperateur = false;
            update = true;
            chiffre1 = 0;
            operateur = "";
            ecran.setText("");
        }
    }
}