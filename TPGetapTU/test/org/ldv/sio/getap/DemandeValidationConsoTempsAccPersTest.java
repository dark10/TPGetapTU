package org.ldv.sio.getap;

import static org.junit.Assert.*;

import java.sql.Date;
import org.junit.Before;
import org.junit.Test;
/**
 * Classe de test d'une DVCTAP
 * @author Hugo Lecolle, Hugo Suissia
 * @version 1.0
 */
public class DemandeValidationConsoTempsAccPersTest {
	
	@Before
	  public void setUp() throws Exception {
		
	}
	
	Classe classe1 = new Classe(0, "SIO22");
    
	User eleve = new User(1L, "Nizar", "Ben Ragdel", classe1, "eleve");
	
	User prof = new User(2L, "Olivier", "Kpu", classe1, "prof");
	
	AccPersonalise test = new AccPersonalise(0, "Salon du libre", 0, 1L);
	
	Date date = Date.valueOf("2012-10-07");
	
	DemandeValidationConsoTempsAccPers dvctap = new DemandeValidationConsoTempsAccPers(
			1L, "2012",date, 240, 
			prof, test, 
			eleve,7);
	
	
	/**
	 * Permet de tester que la DVCTAP est a l'etat initial
	 * 
	 * Test l'etat de l'objet et il y a
	 * Failure si l'etat de la DVCTAP != 7
	 * 
	 * Une exception est retournee en cas d'echec.
	 */
	
	@Test
	public void testEtatInitial() {
		try {
			assertTrue("Etat : Initial", dvctap.isEtatInitial());
		}
		catch(DVCTAPException e){
			System.out.println(e.toString());
		}
	}
	
	/**
	 * Permet de tester que la DVCTAP passe a l'etat modifie par l'eleve
	 * 
	 * Test que l'objet à pu parcourir le chemin d'etat specifie :
	 * 		Chemin d'etat 'passant le test' ex : 7 -> 4.
	 * 		// Chemin d'etat entrainant 'Failure' ex : 7 -> 8 -> (passage impossible vers 4).
	 * Failure si l'etat de la DVCTAP != 4, en fin de chemin
	 * 
	 *  Une exception est retournee en cas d'echec.
	 */
	
	@Test
	public void testModifEleve() {
		try {
			// dvctap.setAnnuleEleve();
			dvctap.setModifEleve();
		    assertTrue("Etat : Modifiee par eleve", dvctap.isModifEleve());
		}
		catch(DVCTAPException e){
			
		}
	}
	
	/**
	 * Permet de tester que la DVCTAP passe a l'etat annule par l'eleve
	 * 
	 * Test que l'objet à pu parcourir le chemin d'etat specifie
	 * 		Chemin d'etat 'passant le test' ex : 7 -> 4 -> 8.
	 * 		// Chemin d'etat entrainant 'Failure' ex : 7 -> 1024 -> (passage impossible vers 8).
	 * Failure si l'etat de la DVCTAP != 4 en fin de chemin
	 * 
	 * Une exception est retournee en cas d'echec.
	 */
	 
	@Test
	public void testAnnuleEleve() {
		try  {
			// dvctap.setModifDateProf();
			dvctap.setAnnuleEleve();
			assertTrue("Etat : Annulee par eleve", dvctap.isAnnuleEleve());
		}
		catch(DVCTAPException e){
		}
	}
}
