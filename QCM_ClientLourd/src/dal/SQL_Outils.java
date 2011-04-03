/**
 * 
 */
package dal;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author fcourtet Outils de manipulation des objets dans la cadre des accès
 *         base de données
 */
public class SQL_Outils {

	/**
	 * Validation de la "Null(ité)" des paramètres récupérés de la base de
	 * données
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
	 * Gestion de la fermeture des objets manipulés lors des accès à la base de
	 * données
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

			// Fermeture de la connexion à la base de données
			CnxSqlServer.closeCnx();
		} catch (SQLException e) {
			// ON NE FAIT RIEN
		}
	}
}
