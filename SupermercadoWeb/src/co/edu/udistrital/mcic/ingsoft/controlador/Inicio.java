package co.edu.udistrital.mcic.ingsoft.controlador;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import co.edu.udistrital.mcic.ingsoft.entidad.Usuario;
import co.edu.udistrital.mcic.ingsoft.servicios.UsuarioServicios;
import co.edu.udistrital.mcic.ingsoft.utilidades.SessionUtils;

@ManagedBean
@ViewScoped
public class Inicio {
	private String nombreUsuario;
	private String clave;
	private Usuario usuario;
	private UsuarioServicios servicio = new UsuarioServicios();

	public String login(){
		validarUsuario();
		
		if (usuario!= null){
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", usuario.getNombre());
			System.out.println("ALGO!!!! "+usuario.getRol().getNombre());
			return usuario.getRol().getNombre();
		}
		else {
			System.out.println("NADA!!!!");
			FacesContext.getCurrentInstance().addMessage( null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Nombre de usuario o clave incorrecta",
							"Verifique nombre de usuario y clave"));
			return "login";
		}
	}
	
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login";
	}
	
	public Usuario validarUsuario() {
		Usuario u = servicio.find(nombreUsuario,clave);
		if (u != null){
			this.usuario=u;
			return usuario;
		}
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
	
	public UsuarioServicios getServicio() {
		return servicio;
	}

	public void setServicio(UsuarioServicios servicio) {
		this.servicio = servicio;
	}
	
	
	
}
