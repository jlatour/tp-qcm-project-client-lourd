package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class CnxSqlServer {

	private static Connection cnx;

	public static Connection OpenCnx() {

		if (cnx == null) {
			try {

				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				DriverManager.registerDriver(new SQLServerDriver());

				cnx = DriverManager
						.getConnection("jdbc:sqlserver://localhost;databaseName=TPJ2se;"
								+ "integratedSecurity=false;user=dbo:password=");

			} catch (ClassNotFoundException e) {
				e.printStackTrace();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return cnx;
	}

	public static void closeCnx() throws SQLException {
		if (cnx != null && !cnx.isClosed()) {
			cnx.close();
			cnx = null;
		}
	}

}
