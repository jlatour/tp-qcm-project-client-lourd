package application;

import controleurs.CtrlRacine;
import dal.ConnectionProvider;
import dal.DalFactory;
import dal.IDal;

public class BootSwing {

	/**
	 * Lanceur de l'application
	 * 
	 * Lance la première action du controleur. 
	 * @param args pas d'arguments requis pour l'instant
	 */
	public static void main(String[] args) {
		CtrlRacine.getInstance();
		// JLA Test
		IDal c = new DalFactory(ConnectionProvider.sqlserver);
		System.out.println(c);
	}

}
