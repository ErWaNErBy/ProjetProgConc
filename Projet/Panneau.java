package Projet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Panneau extends JPanel {
	private Balle balle;
    private ArrayList<Balle> balles = new ArrayList<Balle>(10);
    private ArrayList<Balle> ballesRem = new ArrayList<Balle>(10);
    static Color balleCouleur = new Color((int)(Math.random() * 0x1000000));
    
    public void ajout(Balle balle) {
  	 if(balles.size() < 10) {
  		 balles.add(balle);
  	 }

    }
    public void retrait() {
  	  if(balles.size() != 0) {
  		  balles.remove(balles.size() - 1);
  	  }
    }

    public void collision() {
  	  
  	  for(int i=0;i<balles.size();i++) {
  		  //System.out.println("i:"+balles.size());
  		  for(int j=0;j<balles.size() && j!=i;j++) {
  			  //System.out.println("j:"+balles.size());
  			  int dx = balles.get(i).getPosX() - balles.get(j).getPosX();
  			  int dy = balles.get(i).getPosY() - balles.get(j).getPosY();
  			  int dist =dx*dx+dy*dy;
  			  if(i!=j && dist < (balles.get(i).getRad()/2 + balles.get(j).getRad()/2)*(balles.get(i).getRad()/2 + balles.get(j).getRad()/2)) {
  				  System.out.println("collision");
  				  Fenetre.afficheScore+= 0.5;
  				  Fenetre.score.setText("Score: "+Fenetre.afficheScore);
  				  //ballesRem.add(balles.get(i));
  				  //ballesRem.add(balles.get(j));
  				  balles.remove(i);
  				  balles.remove(j);

  			  }
  		  }
  	  }
  	 /* for(Balle balle : ballesRem) {
  		  ballesRem.remove(balle);
  	  }*/
    }

    @Override
    protected void paintComponent(Graphics g) {
       super.paintComponent(g);
       Graphics2D surface = (Graphics2D) g;
       for (Balle balle : balles) balle.paintComponent(surface);
    }
 }