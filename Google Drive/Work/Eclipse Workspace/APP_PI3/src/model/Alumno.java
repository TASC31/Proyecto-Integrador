package model;

public class Alumno {
	
	private int id;
	private String nom;
	private int num;
	
	public Alumno(int id, String nom, int num) {
		super();
		this.id = id;
		this.nom = nom;
		this.num = num;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public int getNum() {
		return num;
	}

}
