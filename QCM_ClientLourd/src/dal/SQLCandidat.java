/**
 * Gestion de l'acc�s � la base de donn�es pour g�rer les donn�es
 * � mapper sur les objets de type CANDIDAT
 */
package dal;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modeles.Candidat;
import modeles.TypeCandidature;

/**
 * @author fcourtet
 *
 */
public class SQLCandidat {
	/**
	 * D�finition des acc�s � la base de donn�es
	 * permettant de manipuler les Candidats
	 */
	private static final String SELECTALL = "{call ChargerCandidats}";
	
	
	
	/**
	 * Recherche d'un type de candidature � partir du code lu dans le candidat, dans la base de donn�es
	 * @param CodeCandidature		Code du type de candidature recherch�
	 * @param aTypCandi				Liste des types de candidature connus
	 * @return						L'objet TypeCandidature recherch� ou null
	 */
	private static TypeCandidature RechercherTypeCandidatureDuCandidat(String CodeCandidature, 
													ArrayList<TypeCandidature> aTypCandi){
		TypeCandidature tCandTrouvee = null;
		
		for (TypeCandidature tCand : aTypCandi) {
			if (tCand.getCode().equalsIgnoreCase(CodeCandidature)) {
				tCandTrouvee = tCand;
				break;
			}
		}
		return tCandTrouvee;
	}
	
	/**
	 * Instanciation & valorisation d'un objet de type Candidat � partir d'un ResultSet 
	 * @param rs			ResultSet contenant les donn�es issues de la base
	 * @return				Objet Candidat instanci� et valoris�
	 * @throws Exception	Sur les attributs de la classe Candidat qui ne peuvent pas �tre null
	 */
	private static Candidat initCandidatFromResultSet(ResultSet rs,
											ArrayList<TypeCandidature> aTypCandi) throws Exception {
		Candidat cCand = null;
		TypeCandidature tCand = null;
		
		// Gestion des conditions d'exceptions
		if (aTypCandi == null) {
			throw new Exception("La liste des types de candidatures n'est pas renseign�e.");
		}
		
		// Recherche du type de candidature pour l'affecter au candidat
		if (SQL_Outils.IsChampNull(rs, (Object) rs.getString("TypeCandidature_Code")) == true) {
			throw new Exception("Le type de candidature du candidat doit imp�rativement �tre renseign�.");
		}
		else {
			tCand = RechercherTypeCandidatureDuCandidat(rs.getString("TypeCandidature_Code"), aTypCandi);
		}
		// Le type de candidature n'a pas �t� trouv�...
		if (tCand == null) {
			throw new Exception("Le type de candidature du candidat doit imp�rativement �tre renseign�.");
		}

		// Initialisation du Candidat
		cCand = new Candidat(
				(SQL_Outils.IsChampNull(rs, (Object) rs.getInt("Numero")) == true) ? -1:rs.getInt("Numero"),
				(SQL_Outils.IsChampNull(rs, (Object) rs.getString("Nom")) == true) ? "Nom Inconnu":rs.getString("Nom"), 
				(SQL_Outils.IsChampNull(rs, (Object) rs.getString("Prenom")) == true) ? "Pr�nom Inconnu":rs.getString("Prenom"), 
				(SQL_Outils.IsChampNull(rs, (Object) rs.getString("Email")) == true) ? "Email Inconnu":rs.getString("Email"), 
				(SQL_Outils.IsChampNull(rs, (Object) rs.getString("Promotion")) == true) ? "Promotion Inconnue":rs.getString("Promotion"), 
				(SQL_Outils.IsChampNull(rs, (Object) rs.getString("Login")) == true) ? "Login Inconnu":rs.getString("Login"), 
				(SQL_Outils.IsChampNull(rs, (Object) rs.getString("MotDePasse")) == true) ? "MotDePasse Inconnu":rs.getString("MotDePasse"),
				tCand);
		
		return cCand;
	}
	
	/**
	 * R�cup�ration des candidats aux QCMs
	 * @return				Liste des candidats ou null
	 * @throws Exception	Propagation des exceptions li�es � l'acc�s � la base de donn�es
	 */
	public static ArrayList<Candidat> ChargerCandidats(ArrayList<TypeCandidature> aTypCandi) throws Exception {
		ArrayList<Candidat> aCandi = null;
		CallableStatement cmd = null;
		ResultSet rs = null;
		Candidat dRep;
		
		try {
			// Pr�paration de l'appel � la proc�dure stock�e
			cmd = CnxSqlServer.OpenCnx().prepareCall(SELECTALL);

			if (cmd.execute()) {			
				// Pr�paration du parcours des r�sultats
				rs = cmd.getResultSet();
				aCandi = new ArrayList<Candidat>();
				while (rs.next()) {
					dRep = initCandidatFromResultSet(rs, aTypCandi);
					if (dRep != null) {
						aCandi.add(dRep);
					}
				}
			}
			
		} catch (SQLException e) {
			// Propagation du souci li� � la lecture des types de candidatures
			throw new Exception(
					"Probl�me lors de la lecture des candidats : "
					+ System.getProperty("line.separator")
					+ e.getMessage());
		}
		finally {
			// Fermeture des objets que l'on a utilis�
			SQL_Outils.Ferme_Cmd_Connexion(cmd, rs);
		}
		
		return aCandi;
	}

}
