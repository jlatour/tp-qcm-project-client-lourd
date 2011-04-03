package modeles;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class ReponseModel extends AbstractTableModel {

	private static final long serialVersionUID = -6174463861332728750L;

	private String[] colonnes = { "Libellé", "Bonne réponse" };
	private Vector<Reponse> reponses;

	public ReponseModel(Vector<Reponse> pReponses) {
		this.reponses = pReponses;
	}

	public String getColumnName(int col) {
		return colonnes[col].toString();
	}

	public int getRowCount() {
		return reponses.size();
	}

	public int getColumnCount() {
		return colonnes.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Reponse e = reponses.get(rowIndex);
		Object o = null;
		switch (columnIndex) {
		case 0:
			o = e.getLibelle();
			break;
		case 1:
			o = e.getBonneReponse();
			break;
		}
		return o;
	}

	public void addRow(Reponse e) {
		reponses.add(e);
		this.fireTableDataChanged();
	}

	@SuppressWarnings("unchecked")
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	public boolean isCellEditable(int row, int col) {
		if (col < 2) {
			return false;
		}
		else {
			return true;
		}
	}

}
