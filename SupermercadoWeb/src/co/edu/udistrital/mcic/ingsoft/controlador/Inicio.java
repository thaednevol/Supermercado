package co.edu.udistrital.mcic.ingsoft.controlador;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import co.edu.udistrital.mcic.ingsoft.entidad.Beneficiario;
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
			session.setAttribute("rol", usuario.getRol().getNombre());
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
		if (session!=null){
			session.invalidate();
		}
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
	
	public void checkAlreadyLoggedin() throws IOException {
		HttpSession session = SessionUtils.getSession();
		if (session!=null){
			if(session.getAttribute("rol")!=null){
				String rol=(String) session.getAttribute("rol");
				if (rol.equals("admin")){
					ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
					ec.redirect(ec.getRequestContextPath() + "/home.xhtml");
				}
			}
		}
//	    if (isLoggedIn()) {
//	        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
//	        ec.redirect(ec.getRequestContextPath() + "/home.xhtml");
//	    }
	}
	
	public void populate(ActionEvent actionEvent){
		Beneficiario b = new Beneficiario();
		b.setNombre("Luisa");
		b.setApellido("Quiroga");
		b.setIdentificacion("10234567");
		b.setFechaNacimiento(java.sql.Date.valueOf( "2010-01-31" ));
		b.setGenero("F");
		b.setCelular("3003748669");
		b.setDireccion("Calle 1 No 2 3");
		b.setCorreo("lfquiroga@correo.com");
		b.setClave("123");
		b.setCupo(10);
		b.setDia("D");
		b.setHoraInicio("8:00");
		b.setHoraFin("16:00");
		b.setCodigo("123");
		
		servicio.guardarBeneficiario(b);
	}
	
}
