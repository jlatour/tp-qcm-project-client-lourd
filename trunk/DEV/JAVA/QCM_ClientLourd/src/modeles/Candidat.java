/***********************************************************************
 * Module:  Candidat.java
 * Author:  fcourtet
 * Purpose: Defines the Class Candidat
 ***********************************************************************/

package modeles;

/**
 * Description des candidats aux tests. Ce sont toutes les personnes qui doivent
 * passer un examen, que ce soit un test dans le cadre d'une formation, continue
 * ou pas, ou des personnes passant les tests de sélection.
 */
public class Candidat {
	private Integer numero; 	// Num�ro d'identification du candidat dans la base
								// de donn�es
	private String nom; 		// Nom du candidat
	private String prenom; 		// Pr�nom du candidat
	private String email; 		// Adresse mail du candidat
	private String promotion; 	// Libell� de la promotion du candidat
	private String login; 		// Login du candidat
	private String password; 	// Mot de passe du candidat

	public TypeCandidature TypeCandidat; 	// Type de candidature : Formation
											// Continue, Contrat Pro., Passage
											// S�lections...

	/**
	 * Gestion des accesseurs des attributs
	 */

	/**
	 * @param numero		Le num�ro d'identification du candidat dans la base de donn�es	
	 * @throws Exception 	Num�ro de candidat n�gatif non acceptable
	 */
	public void setNumero(Integer numero) throws Exception {
		if (numero < 0) {
			throw new Exception("Le num�ro d'identification du candidat est incorrect.");
		}
		
		this.numero = numero;
	}

	/**
	 * @return 	Le nom du candidat
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom			Le nom du candidat
	 * @throws Exception 	Le nom de candidat est null
	 */
	public void setNom(String nom) throws Exception {
		if ((nom == null) || 
			(nom.trim().isEmpty() == true)) {
			throw new Exception("Le nom doit imp�rativement �tre renseign�.");
		}
		this.nom = nom;
	}

	/**
	 * @return Le pr�nom du candidat
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom		Le pr�nom du candidat
	 * @throws Exception 	Le pr�nom du candidat est null
	 */
	public void setPrenom(String prenom) throws Exception {
		if ((prenom == null) || 
			(prenom.trim().isEmpty() == true)) {
			throw new Exception("Le pr�nom doit imp�rativement �tre renseign�.");
		}
		this.prenom = prenom;
	}

	/**
	 * @return 	Le mail du candidat
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email			Le mail du candidat
	 * @throws Exception 	L'Email du candidat est null
	 */
	public void setEmail(String email) throws Exception {
		if ((email == null) || 
			(email.trim().isEmpty() ==true)) {
			throw new Exception("L'email doit imp�rativement �tre renseign�.");
		}
		this.email = email;
	}

	/**
	 * @return 	Le libell� de la promotion du candidat
	 */
	public String getPromotion() {
		return promotion;
	}

	/**
	 * @param promotion		Le libell� de la promotion du candidat
	 * @throws Exception 	La promotion du candidat est null
	 */
	public void setPromotion(String promotion) throws Exception {
		if ((promotion == null) || 
			(promotion.trim().isEmpty() == true)) {
			throw new Exception("La promotion doit imp�rativement �tre renseign�e.");
		}
		this.promotion = promotion;
	}

	/**
	 * @return Le Login d'identification du candidat
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login			Le Login d'identification du candidat
	 * @throws Exception	Le login est null 
	 */
	public void setLogin(String login) throws Exception {
		if ((login == null) ||
			(login.trim().isEmpty() == true)) {
			throw new Exception("Le login doit imp�rativement �tre renseign�.");
		}
		this.login = login;
	}

	/**
	 * @return		Le mot de passe du candidat
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password		Le mot de passe du candidat
	 * @throws Exception 	Le mot de passe est null
	 */
	public void setPassword(String password) throws Exception {
		if ((password == null) ||
			(password.trim().isEmpty() == true)) {
			throw new Exception("Le mot de passe doit imp�rativement �tre renseign�.");
		}
		this.password = password;
	}

	/**
	 * @param typeCandidat	Le type de candidature : Formation continue, Contrat Pro. etc
	 * @throws Exception 	Le type de candidature ne peut pas �tre null
	 */
	public void setTypeCandidat(TypeCandidature typeCandidat) throws Exception {
		if (typeCandidat == null) {
			throw new Exception("Le type de candidature doit imp�rativement �tre renseign�e.");
		}
		TypeCandidat = typeCandidat;
	}

	/**
	 * Gestion des constructeurs de l'objet CANDIDAT
	 */
	
	/**
	 * @param numero			N� d'identification du candidat
	 * @param nom				Nom du candidat
	 * @param prenom			Pr�nom du candidat	
	 * @param email				Email du candidat
	 * @param promotion			Libell� de la promotion du candidat
	 * @param login				Login du candidat
	 * @param password			Mot de passe du candidat
	 * @param typeCandidat		Type de candidature
	 * @throws Exception 		Les attributs ne peuvent pas �tre null
	 */
	public Candidat(Integer numero, String nom, String prenom, String email,
			String promotion, String login, String password,
			TypeCandidature typeCandidat) throws Exception {
		super();
		
		// Appels aux accesseurs
		setNumero(numero);
		setNom(nom);
		setPrenom(prenom);
		setEmail(email);
		setPromotion(promotion);
		setPromotion(promotion);
		setLogin(login);
		setPassword(password);
		setTypeCandidat(typeCandidat);
	}

	/**
	 * Substitution de la m�thode toString
	 */
	@Override
	public String toString() {
		String machaine = "";
		
		machaine += numero.toString();
		machaine += "\t" + TypeCandidat.getLibelle();
		machaine += "\t" + nom;
		machaine += "\t" + prenom;
		machaine += "\t" + email;
		machaine += "\t" + promotion;
		machaine += "\t" + login;
		machaine += "\t" + password;
		
		return numero + "\t" + TypeCandidat.getLibelle()  + "\t" + nom + "\t" + prenom 
				+ "\t" + email + "\t" + promotion + "\t" + login + "\t" + password;
	}	
}