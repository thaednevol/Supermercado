package co.edu.udistrital.mcic.ingsoft.controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import co.edu.udistrital.mcic.ingsoft.entidad.Usuario;

@ManagedBean
@ViewScoped
public class Inicio {
	private String nombreUsuario;
	private String clave;
	private Usuario usuario;
	
	public Usuario validarUsuario () {
		return null;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	
}
