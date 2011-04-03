/***********************************************************************
 * Module:  Reponse.java
 * Author:  fcourtet
 * Purpose: Defines the Class Reponse
 ***********************************************************************/
package modeles;

import java.util.*;

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

	public String getLibelle() {
		return libelle;
	}

	public Boolean getBonneReponse() {
		return bonneReponse;
	}

}