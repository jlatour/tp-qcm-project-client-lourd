package application;

import java.sql.SQLException;

import controleurs.CtrlRacine;
import dal.ConnectionProvider;
import dal.DalFactory;
import dal.IDal;
import dal.SqlQuestion;

public class BootSwing {
	
	/**
	 * Lanceur de l'application
	 * 
	 * Lance la première action du controleur.
	 * 
	 * @param args
	 *            pas d'arguments requis pour l'instant
	 */
	public static void main(String[] args) {
		CtrlRacine.getInstance();
		
		try {
			SqlQuestion.chargerQuestions();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
