package modeles;

/***********************************************************************

 * Module:  TypeQuestion.java
 * Author:  fcourtet
 * Purpose: Defines the Class TypeQuestion
 ***********************************************************************/

/**
 * Description du type de question : Réponse unique. Réponse multiple Meilleure
 * réponse.
 */
public class TypeQuestion {
	private String code;
	private String libelle;

	public TypeQuestion(String pCode, String pLibelle) {
		this.code = pCode;
		this.libelle = pLibelle;
	}

	public String getCode() {
		return code;
	}

	public String getLibelle() {
		return libelle;
	}

	@Override
	public String toString() {
		return libelle;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof TypeQuestion) {
			return (((TypeQuestion) obj).code).equals(this.code);
		}
		return false;
	}
}