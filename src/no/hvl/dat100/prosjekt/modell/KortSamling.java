package no.hvl.dat100.prosjekt.modell;

import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;

/**
 * Struktur for å lagre ei samling kort. Kan lagre hele kortstokken. Det finnes
 * en konstant i klassen Regler som angir antall kort i hver av de 4 fargene. Når
 * programmet er ferdig settes denne til 13, men under utvikling / testing kan
 * det være praktisk å ha denne mindre.
 * 
 */
public class KortSamling {

	private final int MAKS_KORT = 4 * Regler.MAKS_KORT_FARGE;

	private Kort[] samling;
	private int antall;
	
	
	/**
	 * Oppretter en tom Kortsamling med plass til MAKS_KORT (hele kortstokken).
	 */
	public KortSamling() {
		
		
		samling = new Kort[MAKS_KORT];
		
		antall = 0;
		
		
	}

	/**
	 * Returnerer en tabell med kortene i samlinga. Tabellen trenger ikke være
	 * full. Kortene ligger sammenhengende fra starten av tabellen. Kan få
	 * tilgang til antallet ved å bruke metoden getAntallKort(). Metoden er
	 * først og fremst ment å brukes i testklasser. Om man trenger
	 * kortene utenfor, anbefales metoden getAlleKort().
	 * 
	 * @return tabell av kort.
	 */
	public Kort[] getSamling() {
		
		return samling;
		
	}
	
	/**
	 * Antall kort i samlingen.
	 * 
	 * @return antall kort i samlinga.
	 */
	public int getAntalKort() {
		
		return antall;
		
	}
	
	/**
	 * Sjekker om samlinga er tom.
	 * 
	 * @return true om samlinga er tom, false ellers.
	 */
	public boolean erTom() {
		
		if(antall == 0) {
			return true;
		}
		else {
			return false;
		}
		
		
	}

	/**
	 * Legg et kort til samlinga.
	 * 
	 * @param kort
	 *            er kortet som skal leggast til.
	 */
	public void leggTil(Kort kort) {
		
	 if(antall <= MAKS_KORT && kort != null){
		
		
		samling[antall] = kort;
		
		antall++;
	 }
		
	}
	
	/**
	 * Legger alle korta (hele kortstokken) til samlinga. Korta vil være sortert
	 * slik at de normalt må stokkes før bruk.
	 */
	public void leggTilAlle() {
		
		
		int start = 0; 
		
		for(int i = 0; i< Kortfarge.values().length; i++) {
			
			for(int j = 0; j< Regler.MAKS_KORT_FARGE; j ++) {
				samling[start +j] = new Kort(Kortfarge.values()[i], (j+1));
				antall ++;
			}
			start = start + Regler.MAKS_KORT_FARGE;
	
		}
		
	
		
//		for(Kortfarge farge : Kortfarge.values()) {
			
//			for(int i = 1; i <= Regler.MAKS_KORT_FARGE; i++) {
				
//				leggTil(new Kort(farge, i));
//			}
//		}
		
		
		// Husk: bruk Regler.MAKS_KORT_FARGE for å få antall kort per farge
		
	
	}

	/**
	 * Fjerner alle korta fra samlinga slik at den blir tom.
	 */
	public void fjernAlle() {
		
		for(int i = 0; i< samling.length; i ++) {
			
			samling[i] = null;
		}
		antall = 0;
		
	
	}
	
	/**
	 * Ser på siste kortet i samlinga.
	 * 
	 * @return siste kortet i samlinga, men det blir ikke fjernet. Dersom samalinga er tom, returneres
	 *         null.
	 */
	public Kort seSiste() {
		
		if (antall == 0) {
			return null;
		}
		return samling[antall -1];
		
		
		
		
	}

	/**
	 * Tek ut siste kort fra samlinga.
	 * 
	 * @return siste kortet i samlinga. Dersom samalinga er tom, returneres
	 *         null.
	 */
	public Kort taSiste() {
		
		if(antall == 0) {
			return null;
		}
		
		antall --;
		
		Kort siste = samling[antall];
		
		samling[antall] = null;
		
		return siste;
		
		}
	
	/**
	 * Undersøker om et kort finst i samlinga.
	 * 
	 * @param kort.
	 * 
	 * @return true om kortet finst i samlinga, false ellers.
	 */
	public boolean har(Kort kort) {
		
		for(int i = 0; i <antall; i ++ ) {
			
			if(samling[i] == kort) {
				return true;
			}
		
		}
		return false;
	
	}

	/**
	 * Fjernar et kort frå samlinga. Dersom kortet ikke finnest i samlinga,
	 * skjer ingenting med samilingen
	 * 
	 * @param kort
	 *            kortet som skal fjernast. Dersom kortet ikke finnes, skjer
	 *            ingenting.
	 * @return true om kortet blev fjernet fra samlinga, false ellers.
	 */
			 
	public boolean fjern(Kort kort) {
		
		
		
		boolean fjernet = false;
		
		if (kort == null|| antall == 0) {
			return fjernet;
			
		}
		
		int index = -1;
		
		for(int i = 0; i < antall; i ++) {
			
			if(kort.lik(samling[i])) {
				index = i;
				
				break;
			}
		}
		
		if( index != -1) {
			
			for(int k = 0; k < antall; k ++) {
				samling[k] = samling[k+1];
				
			}
			samling[antall-1] = null;
			fjernet = true;
			antall --;
		}
		return fjernet;
			
		
	}

	/**
	 * Gir kortene som en tabell av samme lengde som antall kort i samlingen
	 * 
	 * @return tabell av kort som er i samlingen, der kort skal ha samme rekkefølge
	 *         som i kortsamlinga.
	 */
	public Kort[] getAllekort() {
		
		Kort[] kort = new Kort[antall];
		
		for(int i =0; i<antall; i++) {
			
			kort[i] = samling[i];
			
		}
		return kort;
		
		
	}
	
}
