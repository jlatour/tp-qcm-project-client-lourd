package vues.composants;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

/**
 * TableDemo is just like SimpleTableDemo, except that it uses a custom
 * TableModel.
 */
public class tableauReponses extends JPanel {

	private static final long serialVersionUID = -6118091386757460425L;
	private JTable table;

	public tableauReponses() {
		super(new GridLayout(1, 0));
		setBorder(new TitledBorder(null, "R\u00E9ponse(s)", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getTableauReponse();
		JScrollPane scrollPane = new JScrollPane(getTableauReponse());
		add(scrollPane);
	}

	public JTable getTableauReponse() {
		if (table == null) {
			table = new JTable();
			table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		}
		return table;
	}

}
