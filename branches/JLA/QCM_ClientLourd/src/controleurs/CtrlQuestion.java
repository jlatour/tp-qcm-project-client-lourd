package controleurs;

import java.sql.SQLException;
import java.util.Vector;

import modeles.Question;
import modeles.Reponse;
import modeles.Theme;
import modeles.TypeQuestion;
import vues.PanelQuestion;
import dal.SqlQuestion;
import dal.SqlReponse;
import dal.SqlTheme;
import dal.SqlTypeQuestion;

public class CtrlQuestion {

	private static CtrlQuestion _instance;
	private PanelQuestion vueQuestion;

	public static CtrlQuestion getInstance() {
		if (_instance == null) {
			_instance = new CtrlQuestion();
		}
		return _instance;
	}

	public PanelQuestion getVueQuestions() {
		if (vueQuestion == null) {
			vueQuestion = PanelQuestion.getInstance();
		}
		return vueQuestion;
	}

	public Vector<Question> chargerQuestions() throws Exception {
		Vector<Question> lq = SqlQuestion.chargerQuestions();
		return lq;
	}

	public Vector<TypeQuestion> chargerTypesDeQuestion() throws Exception {
		Vector<TypeQuestion> ltq = SqlTypeQuestion.chargerTypesQuestion();
		return ltq;
	}

	public Vector<Theme> chargerThemes() throws Exception {
		Vector<Theme> lt = SqlTheme.chargerThemes();
		return lt;
	}

	public Vector<Reponse> chargerReponseParQuestion(Question q) throws Exception {
		Vector<Reponse> lr = SqlReponse.chargerReponsesParCodeQuestion(q.getNumero());
		return lr;
	}

	public boolean estThemeExistant(String result) throws Exception {
		boolean flag = false;
		for(Theme th : SqlTheme.chargerThemes()){
			if (th.getLibelle().equalsIgnoreCase(result)){
				flag = true;
				break;
			}
		}
		return flag;
	}

	public Theme insererThemeParLibelle(String pThemeLibelle) throws Exception {
		String code = pThemeLibelle.substring(0, 5).toUpperCase();
		Theme t = new Theme(code, pThemeLibelle);
		if(SqlTheme.insererTheme(t) != 1){
			return null;
		}
		else return t;
	}

}
