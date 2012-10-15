package org.ldv.sio.getap;

import static org.junit.Assert.*;

import java.sql.Date;
import org.junit.Before;
import org.junit.Test;
/**
 * Classe de test des DVCTAP
 * @author Hugo Lecolle, Hugo Suissia
 * @version 1.0
 */
public class DemandeValidationConsoTempsAccPersTest {
	
	/**
	 * Test d'une création d'un étudiant, d'un professeur et d'une DVCTAP qui leur sont approprié.
	 * @return Erreur si jamais il y a une faute des les constructeur sinon cela ne retourne rien.
	 */
	@Test
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
			eleve,4);
	
	
	/**
	 * Test de la valeur initial d'une DVCTAP.
	 * @return Failure si isEtatInitial =! 0 
	 */
	// etat = 0 = etat initial
	@Test
	public void testEtatInitial() {
		assertTrue("Etat : Initial", dvctap.isEtatInitial());
	}
	
	/**
	 * Test une modification de l'etat apres la modification d'un eleve.
	 * @return Ne retourne rien pour les états de 0 a 4
	 */
	// etat 0 -> etat 4
	@Test
	public void testModifEleve() {
		try {
		dvctap.setModifEleve();
		assertTrue("Etat : Modifiee par eleve", dvctap.isModifEleve());
		}
		catch(DVCTAPException e){
			
		}
	}
	
	/**
	 * Test une modification de l'etat apres l'annulation d'un eleve.
	 * @return Retourne failure pour les états supérieur a 4
	 */
	// etat 4 -> 
	@Test
	public void testAnnuleEleve() {
		try  {
		dvctap.setModifDureeProf();
		dvctap.setAnnuleEleve();
		assertTrue("Etat : Annulee par eleve", dvctap.isAnnuleEleve());
		}
		catch(DVCTAPException e){
			
		}
	
	}
}
