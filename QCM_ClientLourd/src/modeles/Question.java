package modeles;

import java.util.Collection;
import java.util.Iterator;

/***********************************************************************
 * Module: Question.java Author: fcourtet Purpose: Defines the Class Question
 ***********************************************************************/

public class Question {
	private Integer numero;
	private String enonce;
	private String imageIllustration;
	private String miseEnForme;

	public TypeQuestion LeTypeQuestion;
	public Theme LeTheme;
	public Collection<Reponse> LesReponsesDonnees; // Répondues
	public Collection<Reponse> LesReponsesPossibles; // La liste des questions

	public Question(int pNumero, String pEnonce, String pImageURL, String pMiseEnforme) {
		setNumero(pNumero);
		setEnonce(pEnonce);
		setImageIllustration(pMiseEnforme);
		setMiseEnForme(pMiseEnforme);
	}

	/** @pdGenerated default getter */
	public Collection<Reponse> getLesReponsesDonnees() {
		if (LesReponsesDonnees == null) LesReponsesDonnees = new java.util.ArrayList<Reponse>();
		return LesReponsesDonnees;
	}

	/** @pdGenerated default iterator getter */
	public Iterator getIteratorLesReponsesDonnees() {
		if (LesReponsesDonnees == null) LesReponsesDonnees = new java.util.ArrayList<Reponse>();
		return LesReponsesDonnees.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newLesReponsesDonnees
	 */
	public void setLesReponsesDonnees(java.util.Collection<Reponse> newLesReponsesDonnees) {
		removeAllLesReponsesDonnees();
		for (Iterator iter = newLesReponsesDonnees.iterator(); iter.hasNext();)
			addLesReponsesDonnees((Reponse) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newReponse
	 */
	public void addLesReponsesDonnees(Reponse newReponse) {
		if (newReponse == null) return;
		if (this.LesReponsesDonnees == null) this.LesReponsesDonnees = new java.util.ArrayList<Reponse>();
		if (!this.LesReponsesDonnees.contains(newReponse)) this.LesReponsesDonnees.add(newReponse);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldReponse
	 */
	public void removeLesReponsesDonnees(Reponse oldReponse) {
		if (oldReponse == null) return;
		if (this.LesReponsesDonnees != null)
			if (this.LesReponsesDonnees.contains(oldReponse)) this.LesReponsesDonnees.remove(oldReponse);
	}

	/** @pdGenerated default removeAll */
	public void removeAllLesReponsesDonnees() {
		if (LesReponsesDonnees != null) LesReponsesDonnees.clear();
	}

	/** @pdGenerated default getter */
	public java.util.Collection<Reponse> getLesReponsesPossibles() {
		if (LesReponsesPossibles == null) LesReponsesPossibles = new java.util.ArrayList<Reponse>();
		return LesReponsesPossibles;
	}

	/** @pdGenerated default iterator getter */
	public Iterator getIteratorLesReponsesPossibles() {
		if (LesReponsesPossibles == null) LesReponsesPossibles = new java.util.ArrayList<Reponse>();
		return LesReponsesPossibles.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newLesReponsesPossibles
	 */
	public void setLesReponsesPossibles(java.util.Collection<Reponse> newLesReponsesPossibles) {
		removeAllLesReponsesPossibles();
		for (Iterator iter = newLesReponsesPossibles.iterator(); iter.hasNext();)
			addLesReponsesPossibles((Reponse) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newReponse
	 */
	public void addLesReponsesPossibles(Reponse newReponse) {
		if (newReponse == null) return;
		if (this.LesReponsesPossibles == null) this.LesReponsesPossibles = new java.util.ArrayList<Reponse>();
		if (!this.LesReponsesPossibles.contains(newReponse)) this.LesReponsesPossibles.add(newReponse);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldReponse
	 */
	public void removeLesReponsesPossibles(Reponse oldReponse) {
		if (oldReponse == null) return;
		if (this.LesReponsesPossibles != null)
			if (this.LesReponsesPossibles.contains(oldReponse)) this.LesReponsesPossibles.remove(oldReponse);
	}

	/** @pdGenerated default removeAll */
	public void removeAllLesReponsesPossibles() {
		if (LesReponsesPossibles != null) LesReponsesPossibles.clear();
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}

	public String getEnonce() {
		return enonce;
	}

	public void setImageIllustration(String imageIllustration) {
		this.imageIllustration = imageIllustration;
	}

	public String getImageIllustration() {
		return imageIllustration;
	}

	public void setMiseEnForme(String miseEnForme) {
		this.miseEnForme = miseEnForme;
	}

	public String getMiseEnForme() {
		return miseEnForme;
	}

}