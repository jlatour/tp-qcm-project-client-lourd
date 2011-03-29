package modeles;

public class Theme {
	private String code;
	private String libelle;

	public Theme(String code, String libelle) {
		this.code = code;
		this.libelle = libelle;
	}

	public String getCode() {
		return code;
	}
	
	public String getLibelle() {
		return libelle;
	}

}