/**
 *  Gestion de l'accès à la base de données pour gérer les données
 *  à mapper sur les objets de type TYPECANDIDATURE
 */
package dal;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeles.DestinataireReponse;

/**
 * @author fcourtet
 *
 */
public class SQLDestinataireReponse {
	/**
	 * Définition des accès à la base de données
	 * permettant de manipuler les destinataires des réponses aux QCMs
	 */
	private static final String SELECTALL = "{call ChargerDestinataireReponses}";
	
	/**
	 *	Instanciation & valorisation d'un objet de type DestinataireReponse à partir d'un ResultSet 
	 * @param rs			ResultSet contenant les données issues de la base
	 * @return				Objet DestinataireReponse instancié et valorisé
	 * @throws Exception	Sur les attributs de la classe DestinataireReponse qui ne peuvent pas être null
	 */
	private static DestinataireReponse initDestinataireReponseFromResultSet(ResultSet rs) throws Exception {
		DestinataireReponse destRep = null;
		
		// Gestion des conditions d'exceptions
		
		// Initialisation du type de candidature
		destRep = new DestinataireReponse(
				(SQL_Outils.IsChampNull(rs, (Object) rs.getInt("Numero")) == true) ? null:rs.getInt("Numero"), 
				(SQL_Outils.IsChampNull(rs, (Object) rs.getString("Nom")) == true) ? "Nom Inconnu":rs.getString("Nom"), 
				(SQL_Outils.IsChampNull(rs, (Object) rs.getString("Email")) == true) ? "Email Inconnu":rs.getString("Email"));
		
		return destRep;
	}
	
	/**
	 * Récupération des destinataires des réponses aux QCMs
	 * @return				Liste des destinataires des réponses ou null
	 * @throws Exception	Propagation des exceptions liées à l'accès à la base de données
	 */
	public static ArrayList<DestinataireReponse> ChargerDestinataireReponse() throws Exception {
		ArrayList<DestinataireReponse> aDestRep = null;
		CallableStatement cmd = null;
		ResultSet rs = null;
		DestinataireReponse dRep;
		
		try {
			// Préparation de l'appel à la procédure stockée
			cmd = CnxSqlServer.OpenCnx().prepareCall(SELECTALL);

			if (cmd.execute()) {			
				// Préparation du parcours des résultats
				rs = cmd.getResultSet();
				aDestRep = new ArrayList<DestinataireReponse>();
				while (rs.next()) {
					dRep = initDestinataireReponseFromResultSet(rs);
					if (dRep != null) {
						aDestRep.add(dRep);
					}
				}
			}
			
		} catch (SQLException e) {
			// Propagation du souci lié à la lecture des types de candidatures
			throw new Exception(
					"Problème lors de la lecture des destinataires des réponses : "
					+ System.getProperty("line.separator")
					+ e.getMessage());
		}
		finally {
			// Fermeture des objets que l'on a utilisé
			SQL_Outils.Ferme_Cmd_Connexion(cmd, rs);
		}
		
		return aDestRep;
	}

	
}
