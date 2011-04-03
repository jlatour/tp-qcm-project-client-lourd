/***********************************************************************
 * Module: DestinataireReponse.java 
 * Author: fcourtet 
 * Purpose: Defines the Class
 * DestinataireReponse
 ***********************************************************************/
package modeles;


public class DestinataireReponse {
	private Integer numero;		// Num�ro d'identification dans la base de donn�es
	private String nom;			// Nom du destinataire des r�ponses aux QCMs
	private String email;		// Email vers lequel envoyer les r�ponses des QCMs

	
	/**
	 * GESTION DES ACCESSEURS DES ATTRIBUTS
	 */

	/**
	 * @return	Le num�ro d'identification du destinataire 
	 * 			des r�ponses aux QCMs
	 */
	public Integer getNumero() {
		return numero;
	}
	
	/**
	 * @param numero	Initialisation du num�ro du destinataire
	 * 					des r�ponses aux QCMs
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	/**
	 * @return		Le nom du destinataire des r�ponses aux QCMs
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * @param nom 			Le nom du destinataire des r�ponses aux QCMs
	 * @throws Exception	Le Nom ne peut pas �tre null
	 */
	public void setNom(String nom) throws Exception {
		if (nom == null) {
			throw new Exception("Le nom du destinataire des r�ponses doit imp�rativement �tre renseign�.");
		}
		
		this.nom = nom;
	}
	
	/**
	 * @return		L'adresse mail � utiliser pour l'envoi des r�ponses aux QCMs 
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * @param email			L'adresse mail � utiliser pour l'envoi des r�ponses aux QCMs
	 * @throws Exception 	L'adresse mail ne peut pas �tre null
	 */
	public void setEmail(String email) throws Exception {
		if (email == null) {
			throw new Exception("L'adresse mail � utiliser doit imp�rativement �tre renseign�e.");
		}
		this.email = email;
	}

	/**
	 * GESTION DES CONSTRUCTEURS DE L'OBJET DESTINATAIREREPONSE
	 */
	
	/**
	 * @param numero		Le N� d'identification du destinataire dans la base de donn�es
	 * @param nom			Le Nom du destinataire des r�ponses aux QCMs
	 * @param email			L'adresse mail � utiliser pour l'envoi des r�ponses aux QCMs
	 * @throws Exception	Les attributs ne peuvent pas �tre null 
	 */
	public DestinataireReponse(Integer numero, String nom, String email) throws Exception {
		super();
		
		// Appel aux accesseurs des attributs de la classe 
		setNumero(numero);
		setNom(nom);
		setEmail(email);
	}

	/**
	 * Substitution de la m�thode toString
	 */
	@Override
	public String toString() {
		return numero + "\t" + nom + "\t" + email;
	}

}