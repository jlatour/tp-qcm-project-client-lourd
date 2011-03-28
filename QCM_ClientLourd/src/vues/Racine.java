package vues;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controleurs.CtrlRacine;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTree;
import java.awt.Panel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

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
		setBounds(100, 100, 450, 300);

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
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(tree, GroupLayout.PREFERRED_SIZE, 95,
								GroupLayout.PREFERRED_SIZE).addPreferredGap(
								ComponentPlacement.RELATED).addComponent(panel,
								GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				groupLayout.createSequentialGroup().addContainerGap().addGroup(
						groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(tree, Alignment.LEADING,
										GroupLayout.DEFAULT_SIZE, 224,
										Short.MAX_VALUE).addComponent(panel,
										Alignment.LEADING,
										GroupLayout.DEFAULT_SIZE, 230,
										Short.MAX_VALUE)).addContainerGap()));
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
