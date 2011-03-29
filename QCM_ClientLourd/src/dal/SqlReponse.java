package dal;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeles.Reponse;

public class SqlReponse {

	public static ArrayList<Reponse> chargerReponsesParCodeQuestion(int pCodeQuestion) throws SQLException{
		ArrayList<Reponse> lr = null;
		String sql = "{call chargerReponsesParQuestion(?)}";
		lr = new ArrayList<Reponse>();
		CallableStatement statement = CnxSqlServer.OpenCnx().prepareCall(sql);
		statement.setInt(1, pCodeQuestion);
		if (statement.execute()) {
			ResultSet r = statement.getResultSet();
			while (r.next()) {
				lr.add(new Reponse(r.getInt("Numero"), r.getString("Libelle"), r.getBoolean("BonneReponse")));
			}
		}
		return lr;
	}
	
	
}
