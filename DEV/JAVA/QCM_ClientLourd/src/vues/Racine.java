package vues;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import controleurs.CtrlRacine;

public class Racine extends JFrame {

        private static final long serialVersionUID = -7067891082241207557L;
        private static Racine _instance;
        private CtrlRacine _ctrl;

        public static Racine getInstance() {
                if (_instance == null)
                        _instance = new Racine();
                return _instance;
        }

        private Racine() {
                this.setSize(500, 350);
                this.setTitle("QCM Project - Alpha");
                Dimension dimEcran = Toolkit.getDefaultToolkit().getScreenSize();
                this.setLocation(dimEcran.width / 2 - this.getWidth() / 2,
                                dimEcran.height / 2 - this.getHeight() / 2);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                this.setVisible(true);
        }

        public CtrlRacine getCtrl() {
                if (_ctrl == null) {
                        _ctrl = CtrlRacine.getInstance();
                }
                return _ctrl;
        }

}

