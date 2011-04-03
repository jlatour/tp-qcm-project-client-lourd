/**
 * Gestion de l'accès à la base de données pour gérer les données
 * à mapper sur les objets de type CANDIDAT
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
	 * Définition des accès à la base de données
	 * permettant de manipuler les Candidats
	 */
	private static final String SELECTALL = "{call ChargerCandidats}";
	
	
	
	/**
	 * Recherche d'un type de candidature à partir du code lu dans le candidat, dans la base de données
	 * @param CodeCandidature		Code du type de candidature recherché
	 * @param aTypCandi				Liste des types de candidature connus
	 * @return						L'objet TypeCandidature recherché ou null
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
	 * Instanciation & valorisation d'un objet de type Candidat à partir d'un ResultSet 
	 * @param rs			ResultSet contenant les données issues de la base
	 * @return				Objet Candidat instancié et valorisé
	 * @throws Exception	Sur les attributs de la classe Candidat qui ne peuvent pas être null
	 */
	private static Candidat initCandidatFromResultSet(ResultSet rs,
											ArrayList<TypeCandidature> aTypCandi) throws Exception {
		Candidat cCand = null;
		TypeCandidature tCand = null;
		
		// Gestion des conditions d'exceptions
		if (aTypCandi == null) {
			throw new Exception("La liste des types de candidatures n'est pas renseignée.");
		}
		
		// Recherche du type de candidature pour l'affecter au candidat
		if (SQL_Outils.IsChampNull(rs, (Object) rs.getString("TypeCandidature_Code")) == true) {
			throw new Exception("Le type de candidature du candidat doit impérativement être renseigné.");
		}
		else {
			tCand = RechercherTypeCandidatureDuCandidat(rs.getString("TypeCandidature_Code"), aTypCandi);
		}
		// Le type de candidature n'a pas été trouvé...
		if (tCand == null) {
			throw new Exception("Le type de candidature du candidat doit impérativement être renseigné.");
		}

		// Initialisation du Candidat
		cCand = new Candidat(
				(SQL_Outils.IsChampNull(rs, (Object) rs.getInt("Numero")) == true) ? -1:rs.getInt("Numero"),
				(SQL_Outils.IsChampNull(rs, (Object) rs.getString("Nom")) == true) ? "Nom Inconnu":rs.getString("Nom"), 
				(SQL_Outils.IsChampNull(rs, (Object) rs.getString("Prenom")) == true) ? "Prénom Inconnu":rs.getString("Prenom"), 
				(SQL_Outils.IsChampNull(rs, (Object) rs.getString("Email")) == true) ? "Email Inconnu":rs.getString("Email"), 
				(SQL_Outils.IsChampNull(rs, (Object) rs.getString("Promotion")) == true) ? "Promotion Inconnue":rs.getString("Promotion"), 
				(SQL_Outils.IsChampNull(rs, (Object) rs.getString("Login")) == true) ? "Login Inconnu":rs.getString("Login"), 
				(SQL_Outils.IsChampNull(rs, (Object) rs.getString("MotDePasse")) == true) ? "MotDePasse Inconnu":rs.getString("MotDePasse"),
				tCand);
		
		return cCand;
	}
	
	/**
	 * Récupération des candidats aux QCMs
	 * @return				Liste des candidats ou null
	 * @throws Exception	Propagation des exceptions liées à l'accès à la base de données
	 */
	public static ArrayList<Candidat> ChargerCandidats(ArrayList<TypeCandidature> aTypCandi) throws Exception {
		ArrayList<Candidat> aCandi = null;
		CallableStatement cmd = null;
		ResultSet rs = null;
		Candidat dRep;
		
		try {
			// Préparation de l'appel à la procédure stockée
			cmd = CnxSqlServer.OpenCnx().prepareCall(SELECTALL);

			if (cmd.execute()) {			
				// Préparation du parcours des résultats
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
			// Propagation du souci lié à la lecture des types de candidatures
			throw new Exception(
					"Problème lors de la lecture des candidats : "
					+ System.getProperty("line.separator")
					+ e.getMessage());
		}
		finally {
			// Fermeture des objets que l'on a utilisé
			SQL_Outils.Ferme_Cmd_Connexion(cmd, rs);
		}
		
		return aCandi;
	}

}
