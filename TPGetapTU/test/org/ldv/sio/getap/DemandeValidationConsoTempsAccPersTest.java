package org.ldv.sio.getap;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

public class DemandeValidationConsoTempsAccPersTest {
	
	@Before
	  public void setUp() throws Exception {
		
	}
	@Test
	public void testEtatInitial() {
		Classe classe1 = new Classe(0, "SIO22");

		User eleve = new User(1L, "Nizar", "Ben Ragdel", classe1, "eleve");
		
		User prof = new User(2L, "Olivier", "Kpu", classe1, "prof");
		
		AccPersonalise test = new AccPersonalise(0, "Salon du libre", 0, 1L);
		
		Date date = Date.valueOf("2012-10-07");
		
		DemandeValidationConsoTempsAccPers dvctap = new DemandeValidationConsoTempsAccPers(
				1L, "2012",date, 240, 
				prof, test, 
				eleve, 0);
		
		assertTrue("Etat initial", dvctap.isEtatInitial());
		}


}
