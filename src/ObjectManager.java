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
}
