package no.hvl.dat100.prosjekt.modell;

import java.util.Random;


import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;
import no.hvl.dat100.prosjekt.TODO;

public class KortUtils {

	/**
	 * Sorterer en samling. Rekkefølgen er bestemt av compareTo() i Kort-klassen.
	 * 
	 * @see Kort
	 * 
	 * @param samling
	 * 			samling av kort som skal sorteres. 
	 */
	
	public static void sorter(KortSamling samling) {
		
		KortSamling tmpSamling = new KortSamling();
		
		
		for(int i= 0; i<samling.getAntalKort(); i++) {
			int minPos = i;
			for (int posNr = 1; posNr<samling.getAntalKort(); posNr++) {
				if(samling.getAllekort()[posNr].compareTo(samling.getAllekort()[minPos]) < 0 ) {
					minPos = posNr;
				}
			}
			
		tmpSamling.leggTil(samling.getAllekort()[minPos]);
		samling.getAllekort()[minPos].setVerdi(4* Regler.MAKS_KORT_FARGE +1);
		samling.getAllekort()[minPos].setFarge(Kortfarge.Spar);
		
		}
		samling = tmpSamling;
	}
	
	/**
	 * Stokkar en kortsamling. 
	 * 
	 * @param samling
	 * 			samling av kort som skal stokkes. 
	 */
	public static void stokk(KortSamling samling) {
		
		KortSamling Stokket = new KortSamling();
	    int n = samling.getAntalKort();

	    for (int i = 0; i < n; i++) {
	        int randomI = (int) (Math.random() * samling.getAntalKort());
	        Kort randomCard = samling.getAllekort()[randomI];
	        Stokket.leggTil(randomCard);
	        
	    } 
	    samling = Stokket;
			
		
		
	}
	
	}
	

