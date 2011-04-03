/**
 *  Gestion de l'acc�s � la base de donn�es pour g�rer les donn�es
 *  � mapper sur les objets de type TYPECANDIDATURE
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
	 * D�finition des acc�s � la base de donn�es
	 * permettant de manipuler les destinataires des r�ponses aux QCMs
	 */
	private static final String SELECTALL = "{call ChargerDestinataireReponses}";
	
	/**
	 *	Instanciation & valorisation d'un objet de type DestinataireReponse � partir d'un ResultSet 
	 * @param rs			ResultSet contenant les donn�es issues de la base
	 * @return				Objet DestinataireReponse instanci� et valoris�
	 * @throws Exception	Sur les attributs de la classe DestinataireReponse qui ne peuvent pas �tre null
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
	 * R�cup�ration des destinataires des r�ponses aux QCMs
	 * @return				Liste des destinataires des r�ponses ou null
	 * @throws Exception	Propagation des exceptions li�es � l'acc�s � la base de donn�es
	 */
	public static ArrayList<DestinataireReponse> ChargerDestinataireReponse() throws Exception {
		ArrayList<DestinataireReponse> aDestRep = null;
		CallableStatement cmd = null;
		ResultSet rs = null;
		DestinataireReponse dRep;
		
		try {
			// Pr�paration de l'appel � la proc�dure stock�e
			cmd = CnxSqlServer.OpenCnx().prepareCall(SELECTALL);

			if (cmd.execute()) {			
				// Pr�paration du parcours des r�sultats
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
			// Propagation du souci li� � la lecture des types de candidatures
			throw new Exception(
					"Probl�me lors de la lecture des destinataires des r�ponses : "
					+ System.getProperty("line.separator")
					+ e.getMessage());
		}
		finally {
			// Fermeture des objets que l'on a utilis�
			SQL_Outils.Ferme_Cmd_Connexion(cmd, rs);
		}
		
		return aDestRep;
	}

	
}
