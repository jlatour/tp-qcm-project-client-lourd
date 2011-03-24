package dal;

import java.sql.Connection;
import java.sql.SQLException;
// import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class Connexion {

	private static Connection cnx;

	public static Connection OpenCnx() {
		// Load the driver into the VM
		if (cnx == null) {
//			try {
//
//			}
//			catch (SQLException e) {
//				e.printStackTrace();
//			}

			return cnx;
		}
		return cnx;
	}

	public static void CloseCnx() throws SQLException {
		if (cnx != null && !cnx.isClosed()) {
			cnx.close();
			cnx = null;
		}

	}
}
