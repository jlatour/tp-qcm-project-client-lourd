package vues;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import controleurs.CtrlQuestion;
import controleurs.CtrlRacine;

public class Racine extends JFrame {

	private static final long serialVersionUID = -2978864360128401179L;
	private CtrlRacine _ctrl;
	private static Racine _instance;
	private JPanel _CurPanel; // Panel actif

	/**
	 * Gestion du panel actif & visible
	 * 
	 * @throws Exception
	 *             Panel non instancié
	 */
	private void SetVisible_PanelCourant(boolean bVisible, JPanel LePanel) {

		// Gestion des exceptions
		if (LePanel != null) {
			// Gestion de la visibilité
			if (bVisible == true) {
				_CurPanel = LePanel;
				getContentPane().add(LePanel, BorderLayout.CENTER);
				// Me rendre VISIBLE
				LePanel.setVisible(true);
				LePanel.updateUI();
			} else {
				// Me rendre INVISIBLE
				LePanel.setVisible(false);
				LePanel.updateUI();

				getContentPane().remove(LePanel);
				// Destruction de l'objet
				LePanel = null;
				_CurPanel = null;
			}
		}
	}

	/**
	 * Create the frame.
	 */
	private Racine() {
		// Gestion des données générales de la fenêtre
		setTitle("QCM Project - Alpha version");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);

		// Gestion de la barre de menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		// --> Menu FICHIER
		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);

		// --> Menu QUITTER
		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mntmQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		mnFichier.add(mntmQuitter);

		// --> Menu OPTIONS
		JMenu mnOptions = new JMenu("Options");
		menuBar.add(mnOptions);

		// --> Menu Gestion des Tests
		JMenuItem mntmGestionDesTests = new JMenuItem("Gestion des tests");
		mnOptions.add(mntmGestionDesTests);

		// --> Menu Gestion des EXAMENS
		JMenuItem mntmGestionDesExamens = new JMenuItem("Gestion des examens");
		mntmGestionDesExamens.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Rendre invisble le panel courant
				SetVisible_PanelCourant(false, _CurPanel);

				// Rendre visible le panel de gestion des TESTs
				SetVisible_PanelCourant(true, PanelExamen.GetInstance());
			}
		});
		mnOptions.add(mntmGestionDesExamens);

		// --> Menu Gestion des QUESTIONS
		JMenuItem mntmGestionDesQuestions = new JMenuItem(
				"Gestion des questions");
		mntmGestionDesQuestions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Rendre invisble le panel courant
				SetVisible_PanelCourant(false, _CurPanel);

				// Rendre visible le panel de gestion des QUESTIONs
				SetVisible_PanelCourant(true, CtrlQuestion.getInstance().getVueQuestions());
			}
		});
		mnOptions.add(mntmGestionDesQuestions);

		// Initialisation du ContentPane avec un Layout
		getContentPane().setLayout(new BorderLayout(0, 0));
		// Affichage de la fenêtre principale
		this.setVisible(true);

		_CurPanel = null;
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
