package controleurs;

import vues.Racine;

public class CtrlRacine {

        private static CtrlRacine _instance;
        private Racine vueRacine;


        public static CtrlRacine getInstance() {
                if (_instance == null)
                        _instance = new CtrlRacine();
                return _instance;
        }
       
        private CtrlRacine() {
                getVueRacine();
        }
       
        public Racine getVueRacine() {
                if (vueRacine == null) {
                        vueRacine = Racine.getInstance();
                }
                return vueRacine;
        }

}

