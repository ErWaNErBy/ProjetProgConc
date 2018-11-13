package Projet;

import java.awt.*;

public class Balle {
	  private int rad=30;
      private int randx = (int) (Math.random()*((Fenetre.panneau.getWidth()-rad)-1))+1;
      private int randy = (int) (Math.random()*((Fenetre.panneau.getHeight()-rad)-1))+1;
      private int x = randx, y = randy;
      boolean backX, backY = false;
      Color balleCol = new Color((int)(Math.random() * 0x1000000));
      
      
      
      public void move() {
    	  if(x < 1)
    		  backX = false;
    	  if(x > Fenetre.panneau.getWidth()-rad)
    	      backX = true;
    	  if(y < 1)
    	      backY = false;
    	  if(y > Fenetre.panneau.getHeight()-rad)
    	      backY = true;
    	  if(!backX)
    	      ++x;
    	    else
    	      --x;
    	    if(!backY)
    	      ++y;
    	    else
    	      --y;
    	   }

      public int getPosX() {return x;}
      public int getPosY() {return y;}
      public int getRad() {return rad;}
  
      public void setPosX(int x) {this.x = x;}
      public void setPosY(int y) {this.y = y;}
      public void setRad(int y) {this.rad = rad;}

      public void paintComponent(Graphics2D g){
    	  g.setColor(balleCol);
    	  g.fillOval(x,y,rad,rad);
    	  g.drawOval(x,y,rad,rad);
      }
      
   }