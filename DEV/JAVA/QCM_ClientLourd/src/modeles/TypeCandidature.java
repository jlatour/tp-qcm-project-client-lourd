/***********************************************************************
 * Module:  TypeCandidature.java
 * Author:  fcourtet
 * Purpose: Defines the Class TypeCandidature
 ***********************************************************************/

package modeles;

public class TypeCandidature {
	private String code;		// Code du type de candidature
	private String libelle;		// Libellé du type de candidature
	
	/**
	 * Gestion des accesseurs des attributs
	 */
	
	/**
	 * @return	Le code du type de candidature
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code			Le code du type de candidature à positionner
	 * @throws Exception	Le code ne peut pas être NULL
	 */
	public void setCode(String code) throws Exception {
		// Gestion des exceptions sur le code
		if (code == null) {
			throw new Exception("Le code d'un type de candidature doit impérativement être renseigné");
		}
		
		this.code = code;
	}
	
	/**
	 * @return	Le libellé du type de candidature
	 */
	public String getLibelle() {
		return libelle;
	}
	/**
	 * @param libelle		Le libellé du type de candidature à positionner
	 * @throws Exception	Le code ne peut pas être NULL
	 */
	public void setLibelle(String libelle) throws Exception {
		// Gestion des exceptions sur le code
		if (code == null) {
			throw new Exception("Le libellé d'un type de candidature doit impérativement être renseigné");
		}
		this.libelle = libelle;
	}

	/**
	 * Gestion des constructeurs de l'objet TYPECANDIDATURE
	 */
	
	/**
	 * Constructeur de la Classe TypeCandidature avec TOUS les attributs
	 * @param code			Le code identifiant du type de candidature
	 * @param libelle		Le libellé du type de candidature
	 * @throws Exception	Les attributs ne peuvent pas être null
	 */
	public TypeCandidature(String code, String libelle) throws Exception {
		super();
		
		// Appels aux accesseurs des attributs de la classe
		setCode(code);
		setLibelle(libelle);
	}

	/**
	 * Substitution de la méthode toString
	 */
	@Override
	public String toString() {
		return code + "\t" + libelle;
	}	
	

	
}