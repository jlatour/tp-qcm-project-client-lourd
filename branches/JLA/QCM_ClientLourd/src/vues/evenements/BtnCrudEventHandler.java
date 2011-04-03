package vues.evenements;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vues.composants.boutonsCRUD;

public class BtnCrudEventHandler implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton btn = ((JButton)arg0.getSource());
		boutonsCRUD bc = (boutonsCRUD) btn.getParent();

	}
}
