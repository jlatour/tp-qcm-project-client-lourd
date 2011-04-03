/**
 *  Gestion de l'acc�s � la base de donn�es pour g�rer les donn�es
 *  � mapper sur les objets de type TYPECANDIDATURE
 */
package dal;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modeles.TypeCandidature;


/**
 * @author fcourtet
 * 
 */
public class SQLTypeCandidature {
	
	/**
	 * D�finition des acc�s � la base de donn�es
	 * permettant de manipuler les Types de Candidature
	 */
	private static final String SELECTALL = "{call ChargerTypeCandidature}";
	

	/**
	 * Instanciation & valorisation d'un objet de TypeCandidature � partir d'un ResultSet
	 * @param rs			ResultSet contenant les donn�es issues de la base
	 * @return				Objet TypeCandidature instanci� & valoris�
	 * @throws Exception	Sur les attributs de la classe TypeCandidature qui ne peuvent pas �tre null
	 */
	private static TypeCandidature initTypeCandidatureFromResultSet(ResultSet rs) throws Exception {
		TypeCandidature TCand = null;
		
		// Gestion des conditions d'exceptions
		
		// Initialisation du type de candidature
		TCand = new TypeCandidature(
				(SQL_Outils.IsChampNull(rs, (Object) rs.getString("Code")) == true) ? "Code Inconnu":rs.getString("Code"), 
				(SQL_Outils.IsChampNull(rs, (Object) rs.getString("Libelle")) == true) ? "Libell� Inconnu":rs.getString("Libelle"));
		
		return TCand;
	}
	
	
	/**
	 * R�cup�ration de la liste des types de candidatures possible
	 * @throws Exception 	Propagation des exceptions li�es � l'acc�s � la base de donn�es
	 * @return				Liste des types de candidatures ou null 
	 */
	public static ArrayList<TypeCandidature> ChargerTypeCandidature() throws Exception {
		ArrayList<TypeCandidature> aTypeCand = null;
		CallableStatement cmd = null;
		ResultSet rs = null;
		TypeCandidature tCand;
		
		try {
			// Pr�paration de l'appel � la proc�dure stock�e
			cmd = CnxSqlServer.OpenCnx().prepareCall(SELECTALL);

			if (cmd.execute()) {			
				// Pr�paration du parcours des r�sultats
				rs = cmd.getResultSet();
				aTypeCand = new ArrayList<TypeCandidature>();
				while (rs.next()) {
					tCand = initTypeCandidatureFromResultSet(rs);
					if (tCand != null) {
						aTypeCand.add(tCand);
					}
				}
			}
			
		} catch (SQLException e) {
			// Propagation du souci li� � la lecture des types de candidatures
			throw new Exception(
					"Probl�me lors de la lecture des types de candidatures : "
					+ System.getProperty("line.separator")
					+ e.getMessage());
		}
		finally {
			// Fermeture des objets que l'on a utilis�
			SQL_Outils.Ferme_Cmd_Connexion(cmd, rs);
		}
		
		return aTypeCand;
	}
	
}
