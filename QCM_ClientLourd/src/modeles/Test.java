/***********************************************************************

 * Module:  Test.java
 * Author:  fcourtet
 * Purpose: Defines the Class Test
 ***********************************************************************/
package modeles;

import java.util.*;

/** Description d'un test qu'il est possible de planifier pour les candidats. */
public class Test {
	private Integer numero; 		// N° d'identification du test dans la base de données
	private String nom; 			// Nom du test
	private Short duree;	 		// Durée prévue pour le test
	private Number seuilReussite; 	// Seuil de Réussite pour le test

	private ArrayList<Section> LesSections; // Liste des sections du test

	/**
	 * GESTION DES ACCESSEURS DES ATTRIBUTS
	 */

	/**
	 * @return	Le N° d'identification du test dans la base de données.
	 */
	public Integer getNumero() {
		return numero;
	}

	/**
	 * @param numero		Le N° d'identification du test dans la base de données.
	 * @throws Exception 	Identification du test avec un numéro non conforme
	 */
	public void setNumero(Integer numero) throws Exception {
		if (numero < 0) {
			throw new Exception("Le numéro d'identification du test est incorrect.");
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
	 * @throws Exception 	Nom du test non instancié ou valorisé
	 */
	public void setNom(String nom) throws Exception {
		if ((nom == null) || 
			(nom.trim().isEmpty() == true)) {
			throw new Exception("Le nom du test doit impérativement être renseigné.");
		}
		
		this.nom = nom;
	}

	/**
	 * @return 	La durée du test
	 */
	public Short getDuree() {
		return duree;
	}

	/**
	 * @param duree			La durée du test
	 * @throws Exception 	Durée de test mal valorisée
	 */
	public void setDuree(Short duree) throws Exception {
		if (duree < 0) {
			throw new Exception("La durée du test est incorrecte (Valeur négative impossible).");
		}
		this.duree = duree;
	}

	/**
	 * @return	Le seuil de réussite pour le test
	 */
	public Number getSeuilReussite() {
		return seuilReussite;
	}

	/**
	 * @param seuilReussite		Le seuil de réussite pour le test
	 * @throws Exception 		Seuil de réussite mal valorisé
	 */
	public void setSeuilReussite(Number seuilReussite) throws Exception {
		if (seuilReussite.floatValue() < 0f) {
			throw new Exception("Le seuil de réussite du test est incorrect (Valeur négative impossible).");
		}
		this.seuilReussite = seuilReussite;
	}

	
	
	
	/** 
	 * GESTION DE LA LISTE DES SECTIONS DU TEST
	 */
	
	/**
	 *	Récupération d'une référence sur la liste des sections du test 
	 * @return
	 */
	public ArrayList<Section> getLesSections() {
		if (LesSections == null)
			LesSections = new java.util.ArrayList<Section>();
		return LesSections;
	}

	/**
	 * Initialisation de la liste des sections du test à partir d'une liste existante
	 * @param newLesSections
	 * @throws Exception
	 */
	public void setLesSections(ArrayList<Section> newLesSections)
			throws Exception {
		
		// Gestion des exceptions 
		if (newLesSections == null) {
			throw new Exception("Valorisation de la liste des sections du test avec une liste non initialisée.");
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
					"Ajout d'une section non initialisée dans un test.");
		}

		// Ajout de la section souhaité si elle n'existe pas déjà
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
					"Suppression d'une section non initialisée dans un test.");
		}

		// Validation de l'attribut avant suppression de la section demandée
		if (this.LesSections != null)
			if (this.LesSections.contains(oldSection))
				this.LesSections.remove(oldSection);
	}

	/**
	 * Suppression de toutes les sections présentent dans le test
	 */
	public void removeAllLesSections() {		
		if (LesSections != null)
			LesSections.clear();
	}

	/**
	 * GESTION DES CONSTRUCTEURS DE L'OBJET TEST
	 */
	
	/**
	 * @param numero			Le numero du test (Identifiant dans la base de données		
	 * @param nom				Le nom du test
	 * @param duree				La durée du test
	 * @param seuilReussite		Le seuil de réussite pour le test
	 * @param lesSections		La liste des sections
	 * @throws Exception		La liste des sections contient des sections non initialisée
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
	 * @param numero			Le numero du test (Identifiant dans la base de données		
	 * @param nom				Le nom du test
	 * @param duree				La durée du test
	 * @param seuilReussite		Le seuil de réussite pour le test
	 * @param lesSections		La liste des sections
	 * @throws Exception 		Attributs non instanciés ou mal valorisés
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