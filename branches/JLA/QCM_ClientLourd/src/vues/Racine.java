package vues;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controleurs.CtrlRacine;

public class Racine extends JFrame {

	private static final long serialVersionUID = -7067891082241207557L;
	private static Racine _instance;
	private JMenuBar _menuBar;
	private CtrlRacine _ctrl;

	public static Racine getInstance() {
		if (_instance == null) {
			_instance = new Racine();
		}
		return _instance;
	}

	private Racine() {
		this.setSize(600, 450);
		this.setTitle("QCM Project - Alpha");
		Dimension dimEcran = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dimEcran.width / 2 - this.getWidth() / 2,
				dimEcran.height / 2 - this.getHeight() / 2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		this.setJMenuBar(getMenu());
		
		this.setVisible(true);
	}

	public CtrlRacine getCtrl() {
		if (_ctrl == null) {
			_ctrl = CtrlRacine.getInstance();
		}
		return _ctrl;
	}

	private JMenuBar getMenu(){
		if(_menuBar == null){
			_menuBar = new JMenuBar();
			JMenu fMenu = new JMenu();
			fMenu.setText("Fichier");
			JMenuItem exitAction = new JMenuItem("Exit");
			fMenu.add(exitAction);
			
			JMenu oMenu = new JMenu();
			oMenu.setText("Options");
			_menuBar.add(fMenu);
			_menuBar.add(oMenu);
		}
		return _menuBar;
	}
}
