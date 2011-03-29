package vues;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import controleurs.CtrlRacine;

public class Racine extends JFrame {

	private static final long serialVersionUID = -2978864360128401179L;
	private CtrlRacine _ctrl;
	private static Racine _instance;

	/**
	 * Create the frame.
	 */
	private Racine() {
		setTitle("QCM Project - Alpha version");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 655);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);

		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mntmQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnFichier.add(mntmQuitter);

		JMenu mnOptions = new JMenu("Options");

		menuBar.add(mnOptions);

		JMenuItem mntmGestionDesTests = new JMenuItem("Gestion des tests");

		mnOptions.add(mntmGestionDesTests);

		JMenuItem mntmGestionDesExamens = new JMenuItem("Gestion des examens");
		mnOptions.add(mntmGestionDesExamens);

		JMenuItem mntmGestionDesQuestions = new JMenuItem(
				"Gestion des questions");
		mnOptions.add(mntmGestionDesQuestions);

		JTree tree = new JTree();

		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(tree, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(tree, GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		panel_1.setLayout(new GridLayout(1, 4, 0, 0));
		// panel_1.add()
		getContentPane().setLayout(groupLayout);

		this.setVisible(true);
	}

	public CtrlRacine getCtrl() {
		if (_ctrl == null) {
			_ctrl = CtrlRacine.getInstance();
		}
		return _ctrl;
	}

	public static Racine getInstance() {
		if (_instance == null) {
			_instance = new Racine();
		}
		return _instance;
	}
}
