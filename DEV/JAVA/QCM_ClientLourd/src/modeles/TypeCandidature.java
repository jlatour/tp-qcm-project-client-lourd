/***********************************************************************
 * Module:  TypeCandidature.java
 * Author:  fcourtet
 * Purpose: Defines the Class TypeCandidature
 ***********************************************************************/

package modeles;

public class TypeCandidature {
	private String code;		// Code du type de candidature
	private String libelle;		// Libell� du type de candidature
	
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
	 * @param code			Le code du type de candidature � positionner
	 * @throws Exception	Le code ne peut pas �tre NULL
	 */
	public void setCode(String code) throws Exception {
		// Gestion des exceptions sur le code
		if (code == null) {
			throw new Exception("Le code d'un type de candidature doit imp�rativement �tre renseign�");
		}
		
		this.code = code;
	}
	
	/**
	 * @return	Le libell� du type de candidature
	 */
	public String getLibelle() {
		return libelle;
	}
	/**
	 * @param libelle		Le libell� du type de candidature � positionner
	 * @throws Exception	Le code ne peut pas �tre NULL
	 */
	public void setLibelle(String libelle) throws Exception {
		// Gestion des exceptions sur le code
		if (code == null) {
			throw new Exception("Le libell� d'un type de candidature doit imp�rativement �tre renseign�");
		}
		this.libelle = libelle;
	}

	/**
	 * Gestion des constructeurs de l'objet TYPECANDIDATURE
	 */
	
	/**
	 * Constructeur de la Classe TypeCandidature avec TOUS les attributs
	 * @param code			Le code identifiant du type de candidature
	 * @param libelle		Le libell� du type de candidature
	 * @throws Exception	Les attributs ne peuvent pas �tre null
	 */
	public TypeCandidature(String code, String libelle) throws Exception {
		super();
		
		// Appels aux accesseurs des attributs de la classe
		setCode(code);
		setLibelle(libelle);
	}

	/**
	 * Substitution de la m�thode toString
	 */
	@Override
	public String toString() {
		return code + "\t" + libelle;
	}	
	

	
}