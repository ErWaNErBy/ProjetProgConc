package Projet;

import java.text.DecimalFormat;

public class BalleSeparee implements Runnable {
    private Balle balle;
    
    public BalleSeparee(Balle balle) {
        this.balle = balle;
    }
    
    public void run() {
       try {
          while(true){
        	Fenetre.panneau.collision();
          	if(Fenetre.movement) {
          		balle.move();
          		Fenetre.panneau.repaint();
          		Thread.sleep(5);	
          	} else {
          		Fenetre.tmpExec =  (float) ((Fenetre.tmpFin - Fenetre.tmpDebut) /1000F); 
          		if (Fenetre.CanIncTmpTot) {
          			Fenetre.tmpTot+=Fenetre.tmpExec;
          			Fenetre.CanIncTmpTot=false;
          		}
          		DecimalFormat df = new DecimalFormat ();
          		df.setMaximumFractionDigits (2);
          		Fenetre.temps.setText("Temps: "+df.format(Fenetre.tmpTot)+" s");
          	}
          }
       } catch (InterruptedException e) { }
    }
 }