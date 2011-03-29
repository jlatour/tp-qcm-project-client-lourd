package modeles;

/***********************************************************************
 * Module:  Reponse.java
 * Author:  fcourtet
 * Purpose: Defines the Class Reponse
 ***********************************************************************/

/** 
 * Description d'une réponse possible à une question.
 * 
 */
public class Reponse {
	private Integer numero;
	private String libelle;
	private Boolean bonneReponse;

	public Reponse(Integer pNumero, String pLibelle, Boolean pBonneReponse) {
		this.numero = pNumero;
		this.libelle = pLibelle;
		this.bonneReponse = pBonneReponse;
	}

}