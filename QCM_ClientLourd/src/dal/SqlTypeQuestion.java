package dal;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import modeles.TypeQuestion;

public class SqlTypeQuestion {

	public static Vector<TypeQuestion> chargerTypesQuestion() throws SQLException{
		Vector<TypeQuestion> ltq = null;
		String sql = "{call chargerTypesQuestion()}";
		ltq = new Vector<TypeQuestion>();
		CallableStatement statement = CnxSqlServer.OpenCnx().prepareCall(sql);
		if (statement.execute()) {
			ResultSet r = statement.getResultSet();
			while (r.next()) {
				ltq.add(new TypeQuestion(r.getString("Code"), r.getString("Libelle")));
			}
		}
		return ltq;
	}

	public static TypeQuestion chargerTypeQuestionParCode(String pCode) throws SQLException {
		TypeQuestion tq = null;
		String sql = "{call chargerTypeQuestionParCode(?)}";
		CallableStatement statement = CnxSqlServer.OpenCnx().prepareCall(sql);
		statement.setString(1, pCode);
		if (statement.executeQuery() != null) {
			ResultSet r = statement.getResultSet();
			r.next();
			tq = new TypeQuestion(pCode, r.getString("Libelle"));
		}
		return tq;
	}
}
