package org.ldv.sio.getap;

import java.sql.Date;

public class Exemple {
	public static void main(String args[]){
	Classe classe1 = new Classe(0, "SIO22");

	User eleve = new User(1L, "Nizar", "Ben Ragdel", classe1, "eleve");
	
	User prof = new User(2L, "Olivier", "Kpu", classe1, "prof");
	
	AccPersonalise test = new AccPersonalise(0, "Salon du libre", 0, 1L);
	
	Date date = Date.valueOf("2012-10-07");
	
	DemandeValidationConsoTempsAccPers test2 = new DemandeValidationConsoTempsAccPers(
			1L, "2012",date, 240, 
			prof, test, 
			eleve, 0);
	
	System.out.println(test2);
	
	test2.setEtat(4);
	
	System.out.println(test2);
	
	test2.setEtat(32);
	
	System.out.println(test2);
	
	test2.setEtat(4);
	
	System.out.println(test2);
	
	test2.setEtat(2048);
	
	System.out.println(test2);
	
	test2.setEtat(2);
	
	System.out.println(test2);
	
	test2.setEtat(32);
	
	System.out.println(test2);
	}
}
