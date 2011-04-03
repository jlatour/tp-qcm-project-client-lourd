/**
 * Controleur des données manipulées dans l'écran
 * de gestion des Tests (Inscription des stagiaires aux examens ...)
 */
package controleurs;

import java.util.ArrayList;

import modeles.DestinataireReponse;

/**
 * @author fcourtet
 *
 */
public class CTRLExamen {
	/**
	 * Attributs static.
	 */
	private static CTRLExamen _Instance;		// Instance UNIQUE de la classe
	
	/**
	 * Attributs de la classe
	 */
	private ArrayList<DestinataireReponse> aDestReponse;	

	
	/**
	 * @return the aDestReponse
	 */
	public ArrayList<DestinataireReponse> getaDestReponse() {
		return aDestReponse;
	}

	/**
	 * @param aDestReponse the aDestReponse to set
	 */
	public void setaDestReponse(ArrayList<DestinataireReponse> aDestReponse) {
		this.aDestReponse = aDestReponse;
	}

	/**
	 * MISE EN PLACE DU PATTERN DESIGN SINGLETON
	 */
	public static CTRLExamen GetInstance() {
		if (_Instance == null) {
			_Instance = new CTRLExamen();			
		}
		
		return _Instance;
	}
	
	/**
	 * Constructeur de la classe.
	 */
	 private CTRLExamen() {
		 
	 }
}
