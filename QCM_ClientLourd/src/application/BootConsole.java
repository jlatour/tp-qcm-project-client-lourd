/**
 * 
 */
package application;

import java.util.ArrayList;

import dal.SQLCandidat;
import dal.SQLDestinataireReponse;
import dal.SQLTypeCandidature;

import modeles.Candidat;
import modeles.DestinataireReponse;
import modeles.TypeCandidature;

/**
 * @author fcourtet
 *	Application console permettant de valider le bon fonctionnement 
 *	des classes m�tiers
 */
public class BootConsole {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// D�clarations des objets utiles � la validation des classes m�tiers
		ArrayList<TypeCandidature> aTypeCandidature = null;
		ArrayList<DestinataireReponse> aDestReponses = null;
		ArrayList<Candidat> aCandidats = null;
		Integer iIndex; 

		System.out.println("---------------------------------------------");
		System.out.println(" QCM PROJECT: Validation des classes m�tiers ");
		System.out.println("---------------------------------------------");
		System.out.println(System.getProperty("line.separator"));
		
		// Gestion des types de candidatures
		//----------------------------------------------------------
		// Lecture des types de candidatures en BD
		System.out.println("-> Lecture des types de candidatures ");
		try {
			aTypeCandidature = SQLTypeCandidature.ChargerTypeCandidature();
			
			if ((aTypeCandidature != null) &&
				(aTypeCandidature.isEmpty()== false)) {
				// Affichage de la liste
				for (iIndex = 0 ; iIndex < aTypeCandidature.size() ; iIndex ++) {
					System.out.println(aTypeCandidature.get(iIndex).toString());
				}
			}
			else {
				System.out.println("La liste des types de candidatures est vide.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		
		// Gestion des destinataires des r�ponses
		//----------------------------------------------------------
		// Lecture des destinataires des r�ponses en BD
		System.out.println(System.getProperty("line.separator"));
		System.out.println("-> Lecture des destinataires des r�ponses ");
		
		try {
			aDestReponses = SQLDestinataireReponse.ChargerDestinataireReponse();
			
			if ((aDestReponses != null) &&
				(aDestReponses.isEmpty() == false)) {
				// Affichage de la liste
				for (iIndex = 0; iIndex < aDestReponses.size() ; iIndex ++) {
					System.out.println(aDestReponses.get(iIndex).toString());
				}
			}
			else {
				System.out.println("La liste des destinataires des r�ponses aux QCMs est vide.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		// Gestion des candidats
		//----------------------------------------------------------
		// Lecture des candidats pr�sents en BD
		System.out.println(System.getProperty("line.separator"));
		System.out.println("-> Lecture des candidats ");
		
		try {
			aCandidats = SQLCandidat.ChargerCandidats(aTypeCandidature);
			
			if ((aCandidats != null) &&
				(aCandidats.isEmpty() == false)) {
				// Affichage de la liste
				for (iIndex = 0; iIndex < aCandidats.size() ; iIndex ++) {
					System.out.println(aCandidats.get(iIndex).toString());
				}
			}
			else {
				System.out.println("La liste des candidats est vide.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
