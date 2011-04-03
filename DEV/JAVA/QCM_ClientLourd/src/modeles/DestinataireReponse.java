/***********************************************************************
 * Module: DestinataireReponse.java 
 * Author: fcourtet 
 * Purpose: Defines the Class
 * DestinataireReponse
 ***********************************************************************/
package modeles;


public class DestinataireReponse {
	private Integer numero;		// Numéro d'identification dans la base de données
	private String nom;			// Nom du destinataire des réponses aux QCMs
	private String email;		// Email vers lequel envoyer les réponses des QCMs

	
	/**
	 * GESTION DES ACCESSEURS DES ATTRIBUTS
	 */

	/**
	 * @return	Le numéro d'identification du destinataire 
	 * 			des réponses aux QCMs
	 */
	public Integer getNumero() {
		return numero;
	}
	
	/**
	 * @param numero	Initialisation du numéro du destinataire
	 * 					des réponses aux QCMs
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	/**
	 * @return		Le nom du destinataire des réponses aux QCMs
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * @param nom 			Le nom du destinataire des réponses aux QCMs
	 * @throws Exception	Le Nom ne peut pas être null
	 */
	public void setNom(String nom) throws Exception {
		if (nom == null) {
			throw new Exception("Le nom du destinataire des réponses doit impérativement être renseigné.");
		}
		
		this.nom = nom;
	}
	
	/**
	 * @return		L'adresse mail à utiliser pour l'envoi des réponses aux QCMs 
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * @param email			L'adresse mail à utiliser pour l'envoi des réponses aux QCMs
	 * @throws Exception 	L'adresse mail ne peut pas être null
	 */
	public void setEmail(String email) throws Exception {
		if (email == null) {
			throw new Exception("L'adresse mail à utiliser doit impérativement être renseignée.");
		}
		this.email = email;
	}

	/**
	 * GESTION DES CONSTRUCTEURS DE L'OBJET DESTINATAIREREPONSE
	 */
	
	/**
	 * @param numero		Le N° d'identification du destinataire dans la base de données
	 * @param nom			Le Nom du destinataire des réponses aux QCMs
	 * @param email			L'adresse mail à utiliser pour l'envoi des réponses aux QCMs
	 * @throws Exception	Les attributs ne peuvent pas être null 
	 */
	public DestinataireReponse(Integer numero, String nom, String email) throws Exception {
		super();
		
		// Appel aux accesseurs des attributs de la classe 
		setNumero(numero);
		setNom(nom);
		setEmail(email);
	}

	/**
	 * Substitution de la méthode toString
	 */
	@Override
	public String toString() {
		return numero + "\t" + nom + "\t" + email;
	}

}