package vues.evenements;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import vues.PanelQuestion;

public class BtnAddThemeEventHandler implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton b = ((JButton) arg0.getSource());
		PanelQuestion vue = ((vues.PanelQuestion) b.getParent().getParent());
		String result = JOptionPane.showInputDialog(vue, "Renseigner un thème (5 lettres au moins)");
		Boolean condition = false;
		try {
			condition = vue.getCtrl().estThemeExistant(result);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		if (condition) {
			JOptionPane.showMessageDialog(null, "Ce thème existe déjà !");
		}
		else {
			try {
				vue.getCbxTheme().addItem(vue.getCtrl().insererThemeParLibelle(result));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}