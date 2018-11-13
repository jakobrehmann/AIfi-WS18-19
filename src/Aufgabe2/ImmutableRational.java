package Aufgabe2;

public class ImmutableRational {
	// Instanzvariablen definieren
	int zaehler;
	int nenner;
	
	// Konstruktoren
	ImmutableRational() {
		this.zaehler = 0;
		this.nenner = 1;
	}
		
	ImmutableRational(int zaehler, int nenner) {
		this.zaehler = zaehler;
		this.nenner = nenner;
	}
	
	// Methoden
	
	// Rationalzahl ausgeben
	private double printRational() {
		return ((double)zaehler / nenner);  // zum Typ "double" umwandeln
	}
	
	// das Vorzeichen der Rationalzahl umkehren
	private static ImmutableRational negate(ImmutableRational rational) {
		rational.zaehler *= -1;
		return rational;
	}
	
	// Z�hler und Nenner vertauschen
	private static ImmutableRational invert(ImmutableRational rational) {
		// null als Nenner werden?
		if (rational.zaehler == 0) {
			System.out.println("Fehler: divide by 0");
		} else {  // Kehrwert berechnen
			int zaehlerTmp = rational.zaehler;
			int nennerTmp = rational.nenner;
			rational.zaehler = nennerTmp;
			rational.nenner = zaehlerTmp;
		}
		
		return rational;
	}
	
	// Rationalzahl als Typ "double" zur�ckgeben
	private double toDouble() {
		return ((double)zaehler / nenner);
	}
	
	// Bruch k�rzen
	private static ImmutableRational reduce(ImmutableRational rational) {
		// null als Nenner?
		if (rational.nenner == 0) {
			System.out.println("Fehler: Divide by 0");
			return null;
		} else {  // Bruch k�rzen
			int gcd = GCD(rational.zaehler, rational.nenner);  // GCD berechnen
			if (gcd == 1) {  // Bruch kann nicht weiter gek�rzt werden
				return rational;
			} else {  // Bruch kann weiter gek�rzt werden
				rational.zaehler = rational.zaehler / gcd; // gek�rzter Z�hler berechnen
				rational.nenner = rational.nenner / gcd;  // gek�rzter Nenner berechnen
				return rational;
			}
		}
	}
		
	// GCD berechnen
	public static int GCD(int num, int den) {
		if (den == 0) {
			return num;
		}
		return GCD(den, num % den);
	}
	
	// Rationals addieren
	private static ImmutableRational add(ImmutableRational rational, ImmutableRational anderesRational) {
		rational.zaehler = rational.zaehler * anderesRational.getNenner() + 
				anderesRational.getZaehler() * rational.nenner;  // neuer Z�hler
		rational.nenner = rational.nenner * anderesRational.getNenner();  // neuer Nenner
		
		return rational;
	}
	
	// Getters und Setters
	
	// Z�hler abrufen
	private int getZaehler() {
		return zaehler;
	}
		
	// Nenner abrufen
	private int getNenner() {
		return nenner;
	}
	
	// main-Methode
	public static void main (String[] args) {
		// neue Rationalzahl definieren (erster Konstruktor, ohne Argumente)
		ImmutableRational rational = new ImmutableRational(); 
			
		// Rationalzahl ausgeben (erster Konstruktor, ohne Argumente)
		System.out.println("immutable rational = " + rational.printRational());
		
		// neue Rationalzahl definieren (zweiter Konstruktor, mit Argumente)
		ImmutableRational rational2 = new ImmutableRational(6, 8); 
		
		// Rationalzahl ausgeben (erster Konstruktor, ohne Argumente)
		System.out.println("immutable rational2 = " + rational2.printRational());
		
		// Das Verzeichnis der Rationalzahl umkehren
		ImmutableRational negRational = negate(rational2);  // zu negative umkehren
		System.out.println("rational2 (negative) = " + negRational.printRational());
		ImmutableRational posRational = negate(negRational);  // zu positive umkehren
		System.out.println("rational2 (positive) = " + posRational.printRational());
		
		// Der Z�hler und der Nenner vertauschen
		ImmutableRational invRational = invert(rational2);  // Kehrwert
		System.out.println("Kehrwert der rational2 = " + invRational.printRational());
		ImmutableRational invInvRational = invert(invRational);  // wieder zu normal
		System.out.println("Kehrwert des Kehrwerts der rational2 = " +
				invInvRational.printRational());
		
		// toDouble testen
		System.out.println("rational2 mit dem double Typ = " + rational2.toDouble());
		
		// Der Bruch der Rationalzahl k�rzen
		ImmutableRational gekuerzteRational = reduce(rational2);
		System.out.println("Gek�rzter Bruch = " + gekuerzteRational.getZaehler() + "/" + 
				gekuerzteRational.getNenner());
		
		// zweites Rational definieren
		ImmutableRational rational3 = new ImmutableRational(1, 2);
		
		// Der Wert des rational2 ausgeben
		System.out.println("rational3 = " + rational3.printRational());
		
		// zum rational rational2 addieren
		ImmutableRational sumRational = add(rational2, rational3);
		System.out.println("rational2 + rational3 = " + sumRational.printRational());
	}
}
