/***********************************************************************

 * Module:  Test.java
 * Author:  fcourtet
 * Purpose: Defines the Class Test
 ***********************************************************************/
package modeles;

import java.util.*;

/** Description d'un test qu'il est possible de planifier pour les candidats. */
public class Test {
	private Integer numero; 		// N� d'identification du test dans la base de donn�es
	private String nom; 			// Nom du test
	private Short duree;	 		// Dur�e pr�vue pour le test
	private Number seuilReussite; 	// Seuil de R�ussite pour le test

	private ArrayList<Section> LesSections; // Liste des sections du test

	/**
	 * GESTION DES ACCESSEURS DES ATTRIBUTS
	 */

	/**
	 * @return	Le N� d'identification du test dans la base de donn�es.
	 */
	public Integer getNumero() {
		return numero;
	}

	/**
	 * @param numero		Le N� d'identification du test dans la base de donn�es.
	 * @throws Exception 	Identification du test avec un num�ro non conforme
	 */
	public void setNumero(Integer numero) throws Exception {
		if (numero < 0) {
			throw new Exception("Le num�ro d'identification du test est incorrect.");
		}
		this.numero = numero;
	}

	/**
	 * @return 	Le nom du test
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom			Le nom du test
	 * @throws Exception 	Nom du test non instanci� ou valoris�
	 */
	public void setNom(String nom) throws Exception {
		if ((nom == null) || 
			(nom.trim().isEmpty() == true)) {
			throw new Exception("Le nom du test doit imp�rativement �tre renseign�.");
		}
		
		this.nom = nom;
	}

	/**
	 * @return 	La dur�e du test
	 */
	public Short getDuree() {
		return duree;
	}

	/**
	 * @param duree			La dur�e du test
	 * @throws Exception 	Dur�e de test mal valoris�e
	 */
	public void setDuree(Short duree) throws Exception {
		if (duree < 0) {
			throw new Exception("La dur�e du test est incorrecte (Valeur n�gative impossible).");
		}
		this.duree = duree;
	}

	/**
	 * @return	Le seuil de r�ussite pour le test
	 */
	public Number getSeuilReussite() {
		return seuilReussite;
	}

	/**
	 * @param seuilReussite		Le seuil de r�ussite pour le test
	 * @throws Exception 		Seuil de r�ussite mal valoris�
	 */
	public void setSeuilReussite(Number seuilReussite) throws Exception {
		if (seuilReussite.floatValue() < 0f) {
			throw new Exception("Le seuil de r�ussite du test est incorrect (Valeur n�gative impossible).");
		}
		this.seuilReussite = seuilReussite;
	}

	
	
	
	/** 
	 * GESTION DE LA LISTE DES SECTIONS DU TEST
	 */
	
	/**
	 *	R�cup�ration d'une r�f�rence sur la liste des sections du test 
	 * @return
	 */
	public ArrayList<Section> getLesSections() {
		if (LesSections == null)
			LesSections = new java.util.ArrayList<Section>();
		return LesSections;
	}

	/**
	 * Initialisation de la liste des sections du test � partir d'une liste existante
	 * @param newLesSections
	 * @throws Exception
	 */
	public void setLesSections(ArrayList<Section> newLesSections)
			throws Exception {
		
		// Gestion des exceptions 
		if (newLesSections == null) {
			throw new Exception("Valorisation de la liste des sections du test avec une liste non initialis�e.");
		}
		
		// Suppression de toutes les sections existantes
		removeAllLesSections();
		
		// Ajout des nouvelles sections
		for (Section sSect : newLesSections)
			addLesSections(sSect);
	}

	/**
	 * Ajout d'une section dans la liste des sections du test
	 * @param  newSection
	 * @throws Exception
	 */
	public void addLesSections(Section newSection) throws Exception {
		// Gestion des exceptions 
		if (newSection == null) {
			throw new Exception(
					"Ajout d'une section non initialis�e dans un test.");
		}

		// Ajout de la section souhait� si elle n'existe pas d�j�
		if (!getLesSections().contains(newSection))
			this.LesSections.add(newSection);
	}

	/**
	 * Suppression d'une section dans la liste des sections du test
	 * @param oldSection
	 * @throws Exception
	 */
	public void removeLesSections(Section oldSection) throws Exception {
		// Gestion des exceptions
		if (oldSection == null) {
			throw new Exception(
					"Suppression d'une section non initialis�e dans un test.");
		}

		// Validation de l'attribut avant suppression de la section demand�e
		if (this.LesSections != null)
			if (this.LesSections.contains(oldSection))
				this.LesSections.remove(oldSection);
	}

	/**
	 * Suppression de toutes les sections pr�sentent dans le test
	 */
	public void removeAllLesSections() {		
		if (LesSections != null)
			LesSections.clear();
	}

	/**
	 * GESTION DES CONSTRUCTEURS DE L'OBJET TEST
	 */
	
	/**
	 * @param numero			Le numero du test (Identifiant dans la base de donn�es		
	 * @param nom				Le nom du test
	 * @param duree				La dur�e du test
	 * @param seuilReussite		Le seuil de r�ussite pour le test
	 * @param lesSections		La liste des sections
	 * @throws Exception		La liste des sections contient des sections non initialis�e
	 */
	public Test(Integer numero, String nom, Short duree, Number seuilReussite,
			ArrayList<Section> lesSections) throws Exception {
		
		// Utilisation des accesseurs
		this(numero,nom,duree,seuilReussite);
		if (lesSections != null) {
			setLesSections(lesSections);
		}
	}

	/**
	 * @param numero			Le numero du test (Identifiant dans la base de donn�es		
	 * @param nom				Le nom du test
	 * @param duree				La dur�e du test
	 * @param seuilReussite		Le seuil de r�ussite pour le test
	 * @param lesSections		La liste des sections
	 * @throws Exception 		Attributs non instanci�s ou mal valoris�s
	 */
	public Test(Integer numero, String nom, Short duree, Number seuilReussite) throws Exception {

		// Utilisation des accesseurs
		setNumero(numero);
		setNom(nom);
		setDuree(duree);
		setSeuilReussite(seuilReussite);
		removeAllLesSections();
	}
	
}