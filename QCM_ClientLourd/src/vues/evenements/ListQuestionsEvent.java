package vues.evenements;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modeles.Question;
import modeles.ReponseModel;
import vues.PanelQuestion;

public class ListQuestionsEvent implements ListSelectionListener {

	@Override
	public void valueChanged(ListSelectionEvent e) {
		JList li = ((JList) e.getSource());
		Question q = (Question) li.getModel().getElementAt(
				li.getSelectedIndex());
		
		PanelQuestion vue = ((vues.PanelQuestion) li.getParent().getParent());
		vue.getEnonce().setText(q.getEnonce());
		ReponseModel rm = null;
		try {
			rm = new ReponseModel(vue.getCtrl().chargerReponseParQuestion(q));
			vue.getReponses().getTableauReponse().setModel(rm);
		}
		catch (Exception e1) {
			System.out.println();
		}

		try {
			vue.getCbxTheme().setSelectedItem(q.getTheme());
			vue.getCbxTypeDeQuestion().setSelectedItem(q.getTypeQuestion());
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}

		vue.updateUI();
	}

}
