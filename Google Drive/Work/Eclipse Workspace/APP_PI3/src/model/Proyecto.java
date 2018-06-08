package model;

public class Proyecto {
	
	private int id;
	private String nom;
	private String url;
	private int nota;
	private int anio;
	private int curso;
	private String grupo;
	private int ciclo;
	private String componentes;
	
	public Proyecto(int id, String nom, String url, int nota, int anio, int curso, String grupo, int ciclo,
			String comp) {
		super();
		this.id = id;
		this.nom = nom;
		this.url = url;
		this.nota = nota;
		this.anio = anio;
		this.curso = curso;
		this.grupo = grupo;
		this.ciclo = ciclo;
		this.componentes = comp;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getUrl() {
		return url;
	}

	public int getNota() {
		return nota;
	}

	public int getAnio() {
		return anio;
	}

	public int getCurso() {
		return curso;
	}

	public String getGrupo() {
		return grupo;
	}

	public int getCiclo() {
		return ciclo;
	}

	public String getComponentes() {
		return componentes;
	}

}
