package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CnxMySQL implements IDal {
	private static Connection cnx;

	public static Connection OpenCnx() {
		if (cnx == null) {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				cnx = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/qcm_project", "root", "");
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			catch (SQLException e) {
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

	@Override
	public IDal getDalFactory(ConnectionProvider pCprovider) {
		return (IDal) cnx;
	}
}
