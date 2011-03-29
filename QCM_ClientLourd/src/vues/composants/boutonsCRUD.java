package vues.composants;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class boutonsCRUD extends JPanel {

	private static final long serialVersionUID = 3149897900072208274L;
	private JButton btnADD;
	private JButton btnMINUS;
	private JButton btnOK;
	private JButton btnSUPPR;
	
	private GridLayout lay; 
	private static int w = 32;
	private static int h = 32;

	public boutonsCRUD() {
		lay = new GridLayout(1, 4);
		this.setLayout(lay);
		this.add(getBtnADD());
		this.add(getBtnMINUS());
		this.add(getBtnOK());
		this.add(getBtnSUPPR());
	}

	private JButton getBtnADD() {
		if (btnADD == null) {
			btnADD = new JButton(new ImageIcon("./btnImages/add.png"));
			btnADD.setSize(w, h);
		}
		return btnADD;
	}

	private JButton getBtnMINUS() {
		if (btnMINUS == null) {
			btnMINUS = new JButton();
			btnMINUS.setSize(w, h);
		}
		return btnMINUS;
	}
	
	private JButton getBtnSUPPR() {
		if (btnSUPPR == null) {
			btnSUPPR = new JButton();
			btnSUPPR.setSize(w, h);
		}
		return btnSUPPR;
	}
	
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton();
			btnOK.setSize(w, h);
		}
		return btnOK;
	}
}
