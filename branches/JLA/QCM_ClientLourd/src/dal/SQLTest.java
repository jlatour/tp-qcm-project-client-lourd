/**
 * Gestion de l'accès à la base de données pour gérer les données
 * à mapper sur les objets de type TEST
 */
package dal;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeles.Section;
import modeles.Test;

/**
 * @author fcourtet
 *
 */
public class SQLTest {
	/**
	 * Définition des accès à la base de données
	 * permettant de manipuler les TESTS
	 */
	private static final String SELECTALL = "{call ChargerTests}";

	/**
	 * Instanciation & valorisation d'un objet de type Test à partir d'un ResultSet 
	 * @param rs			ResultSet contenant les données issues de la base
	 * @return				Objet Test instancié et valorisé
	 * @throws Exception	Sur les attributs de la classe Test qui ne peuvent pas être null
	 */
	private static Test initTestFromResultSet(ResultSet rs,
											ArrayList<Section> aSection) throws Exception {
		Test leTest = null;
		
		// Gestion des conditions d'exceptions
		

		// Initialisation du Test
		leTest = new Test(
				(SQL_Outils.IsChampNull(rs, (Object) rs.getInt("Numero")) == true) ? -1:rs.getInt("Numero"),
				(SQL_Outils.IsChampNull(rs, (Object) rs.getString("Nom")) == true) ? "Nom Inconnu":rs.getString("Nom"), 
				(SQL_Outils.IsChampNull(rs, (Object) rs.getShort("Duree")) == true) ? -1:rs.getShort("Duree"), 
				(SQL_Outils.IsChampNull(rs, (Object) rs.getFloat("SeuilReussite")) == true) ? -1f:rs.getFloat("SeuilReussite"), 
				aSection);
		
		return leTest;
	}
	
	/**
	 * Récupération des tests
	 * @return				Liste des tests ou null
	 * @throws Exception	Propagation des exceptions liées à l'accès à la base de données
	 */
	public static ArrayList<Test> ChargerTests(ArrayList<Section> aSection) throws Exception {
		ArrayList<Test> aTest = null;
		CallableStatement cmd = null;
		ResultSet rs = null;
		Test LeTest;
		
		try {
			// Préparation de l'appel à la procédure stockée
			cmd = CnxSqlServer.OpenCnx().prepareCall(SELECTALL);

			if (cmd.execute()) {			
				// Préparation du parcours des résultats
				rs = cmd.getResultSet();
				aTest = new ArrayList<Test>();
				while (rs.next()) {
					LeTest = initTestFromResultSet(rs, aSection);
					if (LeTest != null) {
						aTest.add(LeTest);
					}
				}
			}
			
		} catch (SQLException e) {
			// Propagation du souci lié à la lecture des types de candidatures
			throw new Exception(
					"Problème lors de la lecture des tests : "
					+ System.getProperty("line.separator")
					+ e.getMessage());
		}
		finally {
			// Fermeture des objets que l'on a utilisé
			SQL_Outils.Ferme_Cmd_Connexion(cmd, rs);
		}
		
		return aTest;
	}
	
}
