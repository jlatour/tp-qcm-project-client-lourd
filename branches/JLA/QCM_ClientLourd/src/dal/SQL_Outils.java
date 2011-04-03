/**
 * 
 */
package dal;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author fcourtet Outils de manipulation des objets dans la cadre des acc�s
 *         base de donn�es
 */
public class SQL_Outils {

	/**
	 * Validation de la "Null(it�)" des param�tres r�cup�r�s de la base de
	 * donn�es
	 * 
	 * @param rs
	 * @param obj
	 * @return
	 * @throws SQLException
	 */
	public static boolean IsChampNull(ResultSet rs, Object obj)
			throws SQLException {
		return ((obj==null) || (rs.wasNull()));
	}

	/**
	 * Gestion de la fermeture des objets manipul�s lors des acc�s � la base de
	 * donn�es
	 * 
	 * @param cmd
	 * @param rs
	 */
	public static void Ferme_Cmd_Connexion(java.sql.Statement cmd, ResultSet rs) {
		try {
			// Fermeture de l'instruction
			if (cmd != null) {
				cmd.close();
			}

			// Fermeture du resultset
			if (rs != null) {
				rs.close();
			}

			// Fermeture de la connexion � la base de donn�es
			CnxSqlServer.closeCnx();
		} catch (SQLException e) {
			// ON NE FAIT RIEN
		}
	}
}
