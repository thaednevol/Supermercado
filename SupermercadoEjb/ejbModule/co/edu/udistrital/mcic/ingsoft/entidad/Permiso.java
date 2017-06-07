package co.edu.udistrital.mcic.ingsoft.entidad;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table



public class Permiso implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3475566652750735171L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String modulo;
	private String estado;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModulo() {
		return modulo;
	}
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

}
