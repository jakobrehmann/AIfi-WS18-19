package Hausaufgaben;

public class Wurzelest {
	public static void main(String[] args) {	
	double a=9.0, xneu=a/2, xalt=a; // Wert f�r a hier eingeben
	boolean abbr=false;
	int i = 0;
		
	// Kommentare zur Fehlersuche
	
		while (abbr== false) {
			if ((xalt- xneu) <= 0.0001){
				System.out.println("Die Wurzel aus " + a + " kann ann�hrend genau mit " + xneu + " abgegeben werden");
				System.out.println("Daf�r hat es: " + i + " Durchl�ufe gebraucht");
				abbr = true;
			}
			else {
				xalt = xneu;
				xneu = (xalt + (a/xalt)) /2;
//				System.out.println("Schleifendurchlauf: " + i);
//				System.out.println(xneu);
				i++;
//	}
			}
		}}}


