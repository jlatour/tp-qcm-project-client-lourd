package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

/**
 * <b>Identification SQL Server</b> <br />
 * <i>Rappel : Pour cr�er un utilisateur lambda habilit� � la connection sur
 * cette base : - Aller dans S�curit� (au 1er niveau, juste apr�s base de
 * donn�es) - Connexions => Nouvelle connexion (d�cocher les trois cases apr�s
 * le mot de passe, et pr�ciser la base par d�faut). - Utiliser ce nouvel
 * utilisateur pour la nouvelle base.</i>
 * 
 * @author jo
 * 
 */
public class CnxSqlServer {

	private static Connection cnx;

	public static Connection OpenCnx() {

		if (cnx == null) {
			try {

				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				DriverManager.registerDriver(new SQLServerDriver());

				cnx = DriverManager
						.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QCM_Project;user=qcm;password=gonzo");

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

}
