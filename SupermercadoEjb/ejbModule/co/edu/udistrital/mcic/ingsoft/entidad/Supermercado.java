package co.edu.udistrital.mcic.ingsoft.entidad;

import java.util.List;

import javax.persistence.*;

@Entity
@Table

public class Supermercado {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	private String direccion;
	private String telefono;
	private String ciudad;
	private AdministradorSupermercado administradorSupermercado;
	private List<Cajero> cajeros;
	
	static final int NUMERO_SUPERMERCADOS=5;
	
	
	public boolean validarMaximoSupermercados() {
		return false;
	}
	
	
	
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public AdministradorSupermercado getAdministradorSupermercado() {
		return administradorSupermercado;
	}
	public void setAdministradorSupermercado(AdministradorSupermercado administradorSupermercado) {
		this.administradorSupermercado = administradorSupermercado;
	}
	public List<Cajero> getCajeros() {
		return cajeros;
	}
	public void setCajeros(List<Cajero> cajeros) {
		this.cajeros = cajeros;
	}
	
	
	
	
}
