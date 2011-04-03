/**
 * Gestion de l'acc�s � la base de donn�es pour g�rer les donn�es
 * � mapper sur les objets de type TEST
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
	 * D�finition des acc�s � la base de donn�es
	 * permettant de manipuler les TESTS
	 */
	private static final String SELECTALL = "{call ChargerTests}";

	/**
	 * Instanciation & valorisation d'un objet de type Test � partir d'un ResultSet 
	 * @param rs			ResultSet contenant les donn�es issues de la base
	 * @return				Objet Test instanci� et valoris�
	 * @throws Exception	Sur les attributs de la classe Test qui ne peuvent pas �tre null
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
	 * R�cup�ration des tests
	 * @return				Liste des tests ou null
	 * @throws Exception	Propagation des exceptions li�es � l'acc�s � la base de donn�es
	 */
	public static ArrayList<Test> ChargerTests(ArrayList<Section> aSection) throws Exception {
		ArrayList<Test> aTest = null;
		CallableStatement cmd = null;
		ResultSet rs = null;
		Test LeTest;
		
		try {
			// Pr�paration de l'appel � la proc�dure stock�e
			cmd = CnxSqlServer.OpenCnx().prepareCall(SELECTALL);

			if (cmd.execute()) {			
				// Pr�paration du parcours des r�sultats
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
			// Propagation du souci li� � la lecture des types de candidatures
			throw new Exception(
					"Probl�me lors de la lecture des tests : "
					+ System.getProperty("line.separator")
					+ e.getMessage());
		}
		finally {
			// Fermeture des objets que l'on a utilis�
			SQL_Outils.Ferme_Cmd_Connexion(cmd, rs);
		}
		
		return aTest;
	}
	
}
