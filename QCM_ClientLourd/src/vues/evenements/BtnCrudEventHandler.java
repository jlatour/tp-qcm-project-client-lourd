package vues.evenements;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JList;

import vues.PanelQuestion;
import vues.composants.boutonsCRUD;
import vues.composants.boutonsCRUD.CRUD_ACTION;
import vues.composants.boutonsCRUD.CRUD_CONTEXT;

public class BtnCrudEventHandler implements ActionListener {

	private CRUD_CONTEXT context;
	private CRUD_ACTION action;

	public BtnCrudEventHandler(CRUD_CONTEXT pContext, CRUD_ACTION pAction) {
		context = pContext;
		action = pAction;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton btn = ((JButton) arg0.getSource());
		switch (context) {
		case QUESTION:
			boutonsCRUD btnCrud = (boutonsCRUD) btn.getParent();
			PanelQuestion vue = ((vues.PanelQuestion) btn.getParent().getParent().getParent());
			JList listQuestions = (JList) btn.getParent().getParent().getComponents()[0];
			//Question q = (Question) listQuestions.getSelectedValue();
			switch (action) {
			case ADD:
				listQuestions.setEnabled(false);
				btnCrud.getBtnADD().setEnabled(false);
				btnCrud.getBtnMINUS().setEnabled(false);				
				btnCrud.getBtnOK().setEnabled(true);
				btnCrud.getBtnSUPPR().setEnabled(true);
				vue.getEnonce().setText(null);
				vue.getReponses().removeAll();
				vue.updateUI();
			case CONFIRM:
				// Tester si reponses il y a
				// 
			case CANCEL:
				
			}
			break;

		case REPONSE:
			// Choix unique / choix multiple
			switch (action) {
			
			case ADD:

			case CONFIRM:

			case CANCEL:
				
			}
			break;
		}

	}
}
