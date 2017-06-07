package co.edu.udistrital.mcic.ingsoft.entidad;

import java.io.Serializable;

public class Producto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7399769603479734475L;
	private double precio;
	private String  nombre;
	private String  descripcion;
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
