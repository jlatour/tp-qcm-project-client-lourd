package dal;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeles.Question;

public class SqlQuestion {

	public static ArrayList<Question> chargerQuestions() throws SQLException {
		ArrayList<Question> lq = null;
		String sql = "{call chargerQuestions()}";
		lq = new ArrayList<Question>();
		CallableStatement statement = CnxSqlServer.OpenCnx().prepareCall(sql);
		if (statement.execute()) {
			ResultSet r = statement.getResultSet();
			while (r.next()) {
				lq.add(new Question(r.getInt("Numero"), r.getString("Enonce"), r.getString("ImageIllustration"), r
						.getString("MiseEnForme")));
			}
		}
		return lq;
	}

}
