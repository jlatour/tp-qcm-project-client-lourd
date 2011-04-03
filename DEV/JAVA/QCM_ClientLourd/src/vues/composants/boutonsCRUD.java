package vues.composants;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import vues.evenements.BtnCrudEventHandler;

public class boutonsCRUD extends JPanel {

	private static final long serialVersionUID = 3149897900072208274L;
	private JButton btnADD;
	private JButton btnMINUS;
	private JButton btnOK;
	private JButton btnSUPPR;

	private ActionListener crudEventHandler;
	private GridLayout lay;

	public boutonsCRUD() {
		setPreferredSize(new Dimension(128, 32));
		setSize(new Dimension(128, 32));
		setMinimumSize(new Dimension(128, 32));
		setMaximumSize(new Dimension(128, 32));
		lay = new GridLayout(1, 4);

		this.setLayout(lay);
		add(getBtnADD());
		add(getBtnMINUS());
		add(getBtnOK());
		add(getBtnSUPPR());

		crudEventHandler = new BtnCrudEventHandler();
		getBtnADD().addActionListener(crudEventHandler);
		getBtnMINUS().addActionListener(crudEventHandler);
		getBtnOK().addActionListener(crudEventHandler);
		getBtnSUPPR().addActionListener(crudEventHandler);
	}

	public JButton getBtnADD() {
		if (btnADD == null) {
			btnADD = new JButton(new ImageIcon(boutonsCRUD.class.getResource("/vues/composants/btnImages/add.png")));

		}
		return btnADD;
	}

	public JButton getBtnMINUS() {
		if (btnMINUS == null) {
			btnMINUS = new JButton();
			btnMINUS.setIcon(new ImageIcon(boutonsCRUD.class.getResource("/vues/composants/btnImages/minus.png")));

		}
		return btnMINUS;
	}

	public JButton getBtnSUPPR() {
		if (btnSUPPR == null) {
			btnSUPPR = new JButton();
			btnSUPPR.setIcon(new ImageIcon(boutonsCRUD.class.getResource("/vues/composants/btnImages/close.png")));

		}
		return btnSUPPR;
	}

	public JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton();
			btnOK.setIcon(new ImageIcon(boutonsCRUD.class.getResource("/vues/composants/btnImages/ok.png")));

		}
		return btnOK;
	}

	public enum CRUD_STATE {
		ADD, MINUS, OK, SUPPR, NEUTRE
	}

	public void setActionSUPPR(){
		getBtnADD().setEnabled(true);
		getBtnMINUS().setEnabled(false);
		getBtnSUPPR().setEnabled(true);
		getBtnOK().setEnabled(false);
	}
	
	public void setActionNULL(){
		getBtnADD().setEnabled(false);
		getBtnMINUS().setEnabled(false);
		getBtnSUPPR().setEnabled(false);
		getBtnOK().setEnabled(false);
	}
	
}
