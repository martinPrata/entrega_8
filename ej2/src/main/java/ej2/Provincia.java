package ej2;

import ej2.Pais;

public class Provincia {
	private int id;
	private String descripcion;
	private Pais pais;
	
	public Provincia(int id, String descripcion, Pais pais) {
		this.id = id;
		this.descripcion = descripcion;
		this.pais = pais;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	
	
}
