package Projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Fenetre extends JFrame {
	static float afficheScore = 0;
	static double tmpDebut= 0;
	static double tmpFin  = 0;
	static float tmpExec;
	static float tmpTot;
	private JPanel entete = new JPanel();
	static JLabel score = new JLabel("Score: "+afficheScore);
	static JLabel temps = new JLabel("Temps: "+tmpTot+" s");
    private JButton startStop = new JButton("Start");
    private JButton plus = new JButton("  +  ");
    private JButton moins = new JButton("  -  ");
    private JPanel boutons = new JPanel();
    static Panneau panneau = new Panneau();
    static boolean movement = false;
    static boolean CanIncTmpTot = true;
    
    public Fenetre() {
    	
        super("Balles");
        add(entete, BorderLayout.NORTH);
        entete.add(score);
        entete.add(temps);
        panneau.setBackground(Color.lightGray);
        add(panneau, BorderLayout.CENTER);
        add(boutons, BorderLayout.SOUTH);
        boutons.add(startStop);
        boutons.add(plus);
        boutons.add(moins);
        
        startStop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(movement) {
            		CanIncTmpTot=true;
            		tmpFin = System.currentTimeMillis();
            		
            		startStop.setText("Start");
            		movement=false;
            	}else {
            		tmpDebut = System.currentTimeMillis();
            		startStop.setText("Stop");
            		movement=true;
            	}
            }
         });
        
        plus.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
        	   ajoutBalle();
        	   repaint();
           }
        });
        
        moins.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               panneau.retrait();
               repaint();
           }
        });
        
        setSize(500, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private void ajoutBalle() {
        Balle balle = new Balle();      
        panneau.ajout(balle);
        new Thread(new BalleSeparee(balle)).start();
        //panneau.run();
     }
}