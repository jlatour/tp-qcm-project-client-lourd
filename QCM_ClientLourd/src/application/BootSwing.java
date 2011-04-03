package application;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;

import controleurs.CtrlRacine;

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
		ActivateLookAndFeel();
		CtrlRacine.getInstance();
	}

	private static void ActivateLookAndFeel() {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Metal".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		}
		catch (UnsupportedLookAndFeelException e) {
			// handle exception
		}
		catch (ClassNotFoundException e) {
			// handle exception
		}
		catch (InstantiationException e) {
			// handle exception
		}
		catch (IllegalAccessException e) {
			// handle exception
		}

	}

}
