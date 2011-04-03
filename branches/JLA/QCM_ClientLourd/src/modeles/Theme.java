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

	@Override
	public String toString() {
		return getLibelle();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Theme) {
			return (((Theme) obj).code).equals(this.code);
		}
		return false;
	}
}