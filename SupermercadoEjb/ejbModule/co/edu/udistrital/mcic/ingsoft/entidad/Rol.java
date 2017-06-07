package co.edu.udistrital.mcic.ingsoft.entidad;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table


public class Rol implements Serializable {

		
	/**
	 * 
	 */
	private static final long serialVersionUID = -6289845792145984986L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String nombre;
	private List<Permiso> permisos=new ArrayList<Permiso>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Permiso> getPermisos() {
		return permisos;
	}
	public void setPermisos(List<Permiso> permisos) {
		this.permisos = permisos;
	}
	
	
	public void agregarPermiso(Permiso p){
		permisos.add(p);
		}

		public void borrarPermiso(Permiso p){
		permisos.remove(p);
		}
	
}
