import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
       RocketShip ship;
       ArrayList<Projectile> pro = new ArrayList<Projectile>();
       ArrayList<Alien> aliens = new ArrayList<Alien>();
       Random random = new Random();
       public ObjectManager(RocketShip ship) {
      
    	this.ship=ship;
    	   
       }
       void AddProjectile(Projectile newPro){
    	pro.add(newPro);
       }
       void AddAlien(Alien alien) {
    	   aliens.add(new Alien(random.nextInt(LeagueInvaders.width),0,50,50));
    	
    	   
       }
       void update(){
    	   for(int i = 0; i < aliens.size(); i++) {
    		  aliens.get(i).update();
    		   
    	   }
    	   
    	   
       }
       void draw(Graphics g) {
    	   ship.draw(g);
    	   for(int i = 0; i < aliens.size(); i++) {
     		  aliens.get(i).draw(g);
     		   
     	   } 
    	   for(int i = 0; i < pro.size(); i++) {
      		  pro.get(i).draw(g);
      		   
      	   } 
       }
       void purgeObject() {
    	   for(int i = 0; i < pro.size(); i++) {
      		 if(pro.get(i).isActive==false) {
      			 pro.remove(i);
      		 }
      	   } 
     	   for(int i = 0; i < aliens.size(); i++) {
       		  if(aliens.get(i).isActive==false) {
       			aliens.remove(i) ; 
       		  }
       		  
       	   } 
    	   
       }
}
