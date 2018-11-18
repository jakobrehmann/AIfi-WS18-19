package gridworld.myWorld;

import java.awt.Color;

import gridworld.framework.actor.ActorWorld;
import gridworld.framework.actor.Bug;
import gridworld.framework.actor.Rock;

public class FirstSteps {
	
	public static void main (String args []){
		
		 ActorWorld world1 = new ActorWorld ();
		 DBug dbug1 = new DBug (Color.BLUE);
		 Bug bug1 = new Bug();
		 world1.add(bug1);
//		 world1.add(dbug1);
		 world1.add(new Breeder());
		 BabyBug bbb1 = new BabyBug (Color.BLUE);
//		 world1.add(bbb1);
		 
		 Breeder breeder1 = new Breeder ();
//		 world1.add(breeder1);
		 
		 world1.add(new Rock());
		 world1.add(new Rock());
		 world1.add(new Rock());
		 world1.add(new Rock());
		
//		 world1.add(new DBug()); // wieso geht das? ohne dem DBug einen Namen zu geben?
//		 DBug dbug1 = new DBug (Color.BLUE); 
//		 dbug1 ist nicht der Name, sondern eine Referenzvariable, die den R�ckgabetyp des Konstrukors speichert, was ein Objekt der Klasse ist
//		 die dir nur den Zugriff auf dein Objekt erm�glicht, du �bergibst der world1 in beiden F�llen den Speicherort
//		 des Objektes
 
		 
	     world1.show();
		
	}

}
