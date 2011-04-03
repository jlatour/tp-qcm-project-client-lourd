package dal;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import modeles.Theme;

public class SqlTheme {
	
	public static Vector<Theme> chargerThemes() throws SQLException {
		Vector<Theme> lt = null;
		String sql = "{call chargerThemes()}";
		lt = new Vector<Theme>();
		CallableStatement statement = CnxSqlServer.OpenCnx().prepareCall(sql);
		if (statement.execute()) {
			ResultSet r = statement.getResultSet();
			while (r.next()) {
				lt.add(new Theme(r.getString("Code"), r.getString("Libelle")));
			}
		}
		return lt;
	}

	public static Theme chargerThemeParCode(String pCode) throws SQLException {
		Theme t = null;
		String sql = "{call chargerThemeParCode(?)}";
		CallableStatement statement = CnxSqlServer.OpenCnx().prepareCall(sql);
		statement.setString(1, pCode);
		if (statement.executeQuery() != null) {
			ResultSet r = statement.getResultSet();
			r.next();
			t = new Theme(pCode, r.getString("Libelle"));
		}
		return t;
	}
	
	public static int insererTheme(Theme pTheme) throws SQLException{
		String sql = "{call insererTheme(?, ?)}";
		CallableStatement statement = CnxSqlServer.OpenCnx().prepareCall(sql);
		statement.setString(1, pTheme.getCode());
		statement.setString(2, pTheme.getLibelle());
		return statement.executeUpdate();
	}

}
