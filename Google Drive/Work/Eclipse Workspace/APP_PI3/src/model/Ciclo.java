package model;

public class Ciclo {
	
	private int id;
	private String nom;
	private String desc;
	
	public Ciclo(int id, String nom, String desc) {
		super();
		this.id = id;
		this.nom = nom;
		this.desc = desc;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getDesc() {
		return desc;
	}

}
