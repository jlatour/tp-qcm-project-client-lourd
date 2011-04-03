package dal;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import modeles.Question;

public class SqlQuestion {

	public static Vector<Question> chargerQuestions() throws SQLException {
		Vector<Question> lq = null;
		String sql = "{call chargerQuestions()}";
		lq = new Vector<Question>();
		CallableStatement statement = CnxSqlServer.OpenCnx().prepareCall(sql);
		if (statement.execute()) {
			ResultSet r = statement.getResultSet();
			while (r.next()) {
				Question q = new Question(r.getString("Enonce"), r.getString("ImageIllustration"), r
						.getString("MiseEnForme"));
				q.setNumero(r.getInt("Numero"));
				q.setTheme(SqlTheme.chargerThemeParCode(r.getString("themeCode")));
				q.setTypeQuestion(SqlTypeQuestion.chargerTypeQuestionParCode(r.getString("typeQuestionCode")));
				q.setLesReponsesPossibles(SqlReponse.chargerReponsesParCodeQuestion(q.getNumero()));
				lq.add(q);
			}
		}
		return lq;
	}
	
	public static void insererQuestion(Question pQuestion) throws SQLException{
		String sql = "{call insererQuestion(?, ?, ?, ?, ?)}";
		CallableStatement statement = CnxSqlServer.OpenCnx().prepareCall(sql);
		statement.setString(1, pQuestion.getTheme().getCode());
		statement.setString(2, pQuestion.getTypeQuestion().getCode());
		statement.setString(3, pQuestion.getEnonce());
		statement.setString(4, pQuestion.getImageIllustration());
		statement.setString(5, pQuestion.getMiseEnForme());
		statement.execute();
	}

}
