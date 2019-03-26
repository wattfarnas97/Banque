package metier;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CreditMetierImplTest {
	private ICreditMetier metier;
	@Before
	public void setUp() throws Exception {
		metier=new CreditMetierImpl();
	}

	@Test
	public void testCalculerMensualiteCredit() {
		double capital=200000;
		int duree=240;
		double taux=4.5;
		
		double resultatAttendue=1265.2987;
		double resCalcule=metier.calculerMensualiteCredit(capital, taux, duree);
		assertEquals(resultatAttendue, resCalcule, 0.0001);
	
	}

}
