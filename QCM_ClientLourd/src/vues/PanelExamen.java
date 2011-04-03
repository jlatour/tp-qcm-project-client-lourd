package vues;

import javax.swing.JPanel;

import controleurs.CTRLExamen;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTree;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;

public class PanelExamen extends JPanel {

	private static CTRLExamen LeCtrlTest;			// Controleur de l'écran
	private static PanelExamen _instance;		// L'instance unique de la classe
	
	private JTextField TxtMailDestRep;
	private JTree Tree_ListeStagiaires;
	private JTree Tree_PlaningExams;
	private JComboBox CbxDestinataireRep;
	private JList listInscrit;
	private JButton btnValider;
	
	
	/** 
	 * Mise en place du Design Pattern Singleton
	 */
	public static PanelExamen GetInstance() {
		if (_instance == null) {
			_instance = new PanelExamen();
		}
		
		// Récupération d'une instance sur le controleur de l'écran
		LeCtrlTest = CTRLExamen.GetInstance();
		
		return _instance;
	}
	

	/**
	 * Create the panel.
	 */
	private PanelExamen() {
		
		Tree_PlaningExams = new JTree();
		Tree_PlaningExams.setEditable(true);
		
		JLabel lblGestionDesInscriptions = new JLabel("Gestion des Inscriptions aux Tests");
		lblGestionDesInscriptions.setForeground(SystemColor.desktop);
		lblGestionDesInscriptions.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblDateHeureDbt = new JLabel("Date / Heure de d\u00E9but ");
		lblDateHeureDbt.setForeground(SystemColor.desktop);
		lblDateHeureDbt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblDateHeureFin = new JLabel("Date / Heure de Fin ");
		lblDateHeureFin.setForeground(SystemColor.desktop);
		lblDateHeureFin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblDestinataireDesRponses = new JLabel("Destinataire des r\u00E9ponses ");
		lblDestinataireDesRponses.setForeground(SystemColor.desktop);
		lblDestinataireDesRponses.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblListeDesStagiaires = new JLabel("Liste des Stagiaires ");
		lblListeDesStagiaires.setForeground(SystemColor.desktop);
		lblListeDesStagiaires.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblListeDesInscrits = new JLabel("Liste des Inscrits ");
		lblListeDesInscrits.setForeground(SystemColor.desktop);
		lblListeDesInscrits.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		CbxDestinataireRep = new JComboBox();
		CbxDestinataireRep.setEditable(true);
		
		TxtMailDestRep = new JTextField();
		TxtMailDestRep.setColumns(10);
		
		btnValider = new JButton("Valider");
		
		listInscrit = new JList();
		
		Tree_ListeStagiaires = new JTree();
		Tree_ListeStagiaires.setEditable(true);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(Tree_PlaningExams, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblDateHeureDbt)
								.addComponent(lblDateHeureFin)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblDestinataireDesRponses, Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblListeDesStagiaires)
												.addComponent(CbxDestinataireRep, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
												.addComponent(Tree_ListeStagiaires, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE))
											.addGap(18)
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(TxtMailDestRep, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
												.addComponent(lblListeDesInscrits)
												.addComponent(listInscrit, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))))
									.addGap(18)
									.addComponent(btnValider)
									.addGap(127))))
						.addComponent(lblGestionDesInscriptions))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblGestionDesInscriptions)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(Tree_PlaningExams, GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDateHeureDbt)
							.addGap(12)
							.addComponent(lblDateHeureFin)
							.addGap(17)
							.addComponent(lblDestinataireDesRponses)
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(CbxDestinataireRep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(TxtMailDestRep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnValider))
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblListeDesStagiaires)
								.addComponent(lblListeDesInscrits))
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(listInscrit, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
								.addComponent(Tree_ListeStagiaires, GroupLayout.PREFERRED_SIZE, 543, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		groupLayout.linkSize(SwingConstants.VERTICAL, new Component[] {listInscrit, Tree_ListeStagiaires});
		groupLayout.linkSize(SwingConstants.VERTICAL, new Component[] {CbxDestinataireRep, TxtMailDestRep});
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {lblDateHeureDbt, lblDateHeureFin});
		setLayout(groupLayout);

	}
}
