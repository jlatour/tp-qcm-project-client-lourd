/**
 *  Gestion de l'accès à la base de données pour gérer les données
 *  à mapper sur les objets de type TYPECANDIDATURE
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
	 * Définition des accès à la base de données
	 * permettant de manipuler les Types de Candidature
	 */
	private static final String SELECTALL = "{call ChargerTypeCandidature}";
	

	/**
	 * Instanciation & valorisation d'un objet de TypeCandidature à partir d'un ResultSet
	 * @param rs			ResultSet contenant les données issues de la base
	 * @return				Objet TypeCandidature instancié & valorisé
	 * @throws Exception	Sur les attributs de la classe TypeCandidature qui ne peuvent pas être null
	 */
	private static TypeCandidature initTypeCandidatureFromResultSet(ResultSet rs) throws Exception {
		TypeCandidature TCand = null;
		
		// Gestion des conditions d'exceptions
		
		// Initialisation du type de candidature
		TCand = new TypeCandidature(
				(SQL_Outils.IsChampNull(rs, (Object) rs.getString("Code")) == true) ? "Code Inconnu":rs.getString("Code"), 
				(SQL_Outils.IsChampNull(rs, (Object) rs.getString("Libelle")) == true) ? "Libellé Inconnu":rs.getString("Libelle"));
		
		return TCand;
	}
	
	
	/**
	 * Récupération de la liste des types de candidatures possible
	 * @throws Exception 	Propagation des exceptions liées à l'accès à la base de données
	 * @return				Liste des types de candidatures ou null 
	 */
	public static ArrayList<TypeCandidature> ChargerTypeCandidature() throws Exception {
		ArrayList<TypeCandidature> aTypeCand = null;
		CallableStatement cmd = null;
		ResultSet rs = null;
		TypeCandidature tCand;
		
		try {
			// Préparation de l'appel à la procédure stockée
			cmd = CnxSqlServer.OpenCnx().prepareCall(SELECTALL);

			if (cmd.execute()) {			
				// Préparation du parcours des résultats
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
			// Propagation du souci lié à la lecture des types de candidatures
			throw new Exception(
					"Problème lors de la lecture des types de candidatures : "
					+ System.getProperty("line.separator")
					+ e.getMessage());
		}
		finally {
			// Fermeture des objets que l'on a utilisé
			SQL_Outils.Ferme_Cmd_Connexion(cmd, rs);
		}
		
		return aTypeCand;
	}
	
}
